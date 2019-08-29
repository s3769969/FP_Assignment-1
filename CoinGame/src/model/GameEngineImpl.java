package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine{
	
	private Collection<Player> players = new HashSet<Player>();
	private Collection<GameEngineCallback> gameEngineCallbacks = new ArrayList<GameEngineCallback>();
	
	//Checks for invalid parameters and throws exception. Else spins player coins via generic spin
	@Override
	public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2) throws IllegalArgumentException {
		
		validArgs(initialDelay1, finalDelay1, delayIncrement1, initialDelay2,finalDelay2, delayIncrement2);
		try {
			genericSpin(initialDelay1, finalDelay1, delayIncrement1, initialDelay2,finalDelay2, delayIncrement2, player);
		} catch (InterruptedException e) {
		} catch (Exception e) {
		}
	}

	//Checks for invalid parameters and throws exception. Else spins spinner coins via generic spin
	@Override
	public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) throws IllegalArgumentException {
		
		Player player = null;
		validArgs(initialDelay1, finalDelay1, delayIncrement1, initialDelay2,finalDelay2, delayIncrement2);
		try {
			genericSpin(initialDelay1, finalDelay1, delayIncrement1, initialDelay2,finalDelay2, delayIncrement2, player);
		} catch (InterruptedException e) {
		} catch (Exception e) {
		}
	}

	//Applies bet results for each player, updating points based on bet amount and type
	@Override
	public void applyBetResults(CoinPair spinnerResult) {
		for (Player player: players) {
			player.getBetType().applyWinLoss(player, spinnerResult);
		}
	}

	//Checks if player with same id is in players Collection and deletes existing player. Then adds new player
	@Override
	public void addPlayer(Player player) {
		Player sameIdPlayer = getPlayer(player.getPlayerId());
		if (sameIdPlayer != null){
			players.remove(sameIdPlayer);
		}
		players.add(player);
	}

	//Checks if player with id exists in players Collection and returns player. Else returns null
	@Override
	public Player getPlayer(String id) {
		for (Player player: players) {
			if (player.getPlayerId().equals(id)){
				return player;
			}
		}
		return null;
	}

	//Removes player if found in players Collection and returns true. Else, returns false
	@Override
	public boolean removePlayer(Player player) {
		if (players.remove(player)) {
			return true;
		}
		return false;
	}

	//Adds game engine callback to gameEngineCallbacks Collection and returns true. Else, returns false
	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		gameEngineCallbacks.add(gameEngineCallback);
	}

	//Removes game engine callback if found in gameEngineCallbacks Collection and returns true. Else, returns false
	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		if (gameEngineCallbacks.remove(gameEngineCallback)) {
			return true;
		}
		return false;
	}

	//Returns temporary copy of players Collection
	@Override
	public Collection<Player> getAllPlayers() {
		Collection<Player> playersTemp = new HashSet<Player>();
		playersTemp = players;
		return playersTemp;
	}

	/*Places bet for given player if player is in players Collection and, bet amount and type is valid for 
	current player points and returns true. Else returns false*/
	@Override
	public boolean placeBet(Player player, int bet, BetType betType) {
		
		if (players.contains(player)) {
			player.setBetType(betType);
			if (player.setBet(bet)) {
				return true;
			}
		}
		return false;
	}
	
	//Checks if any parameter is not valid and throws exception
	private void validArgs(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2) throws IllegalArgumentException{
		if (initialDelay1 <= 0 || finalDelay1 <= 0 || delayIncrement1 <= 0 || initialDelay2 <= 0 || finalDelay2 <= 0 ||
				delayIncrement2 <= 0 || finalDelay1 <= initialDelay1 || finalDelay2 <= initialDelay2 ||
				delayIncrement1 > (finalDelay1 - initialDelay1) || delayIncrement2 > (finalDelay2 - initialDelay2) ) {
			throw new IllegalArgumentException();
		}
	}
	
	/*Creates a coin pair and spins each coin according to parameters. Delay for coin spinning is represented by
	sleep time on thread. Spinning continues until both coins have spun until at least final delay time. For each
	spin each game engine callback in Collection are called for logging. When coins have stopped results are logged
	for each game engine callback in Collection*/
	private void genericSpin(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2, Player player) throws InterruptedException {
		CoinPair coinPair = new CoinPairImpl();
		int currentDelay1 = 0;
		Thread.sleep((long)initialDelay1);
		currentDelay1 += initialDelay1;
		int currentDelay2 = 0;
		Thread.sleep((long)initialDelay2);
		currentDelay2 += initialDelay2;
		do {
			if (currentDelay1 < finalDelay1) {
				Thread.sleep((long)delayIncrement1);
				currentDelay1 += delayIncrement1;
				coinPair.getCoin1().flip();
				if (player != null) {
					for(GameEngineCallback gec : gameEngineCallbacks) {
						gec.playerCoinUpdate(player, coinPair.getCoin1(), (GameEngine)this);
					}		
				}else {
					for(GameEngineCallback gec : gameEngineCallbacks) {
						gec.spinnerCoinUpdate(coinPair.getCoin1(), (GameEngine)this);
					}
				}
			}
			if (currentDelay2 < finalDelay2){
				Thread.sleep((long)delayIncrement2);
				currentDelay2 += delayIncrement2;
				coinPair.getCoin2().flip();
				if (player != null) {
					for(GameEngineCallback gec : gameEngineCallbacks) {
						gec.playerCoinUpdate(player, coinPair.getCoin2(), (GameEngine)this);
					}
				}else {
					for(GameEngineCallback gec : gameEngineCallbacks) {
						gec.spinnerCoinUpdate(coinPair.getCoin2(), (GameEngine)this);
					}
				}
			}
		}while(currentDelay1 < finalDelay1 && currentDelay2 < finalDelay2);	
		
		if (player != null) {
			player.setResult(coinPair);
			for(GameEngineCallback gec : gameEngineCallbacks) {
				gec.playerResult(player, coinPair, (GameEngine)this);
			}
		}else {
			applyBetResults(coinPair);
			for(GameEngineCallback gec : gameEngineCallbacks) {
				gec.spinnerResult(coinPair, (GameEngine)this);
			}
		}
	}

}
