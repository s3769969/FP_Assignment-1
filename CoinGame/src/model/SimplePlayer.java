package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SimplePlayer implements Player{

	private String playerId;
	private String playerName;
	private int initialPoints;
	private int points;
	private int bet;
	private BetType betType;
	
	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.initialPoints = initialPoints;
	}
	
	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;	
	}

	@Override
	public String getPlayerId() {
		return this.playerId;
	}

	@Override
	public boolean setBet(int bet) {
		if (this.bet > bet && bet >= 0) {
			this.bet = bet;
			return true;
		}
		return false;
	}

	@Override
	public int getBet() {
		return bet;
	}

	@Override
	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	@Override
	public BetType getBetType() {
		return betType;
	}

	@Override
	public void resetBet() {
		this.bet = 0;
	}

	@Override
	public CoinPair getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResult(CoinPair coinPair) {
		// TODO Auto-generated method stub
		
	}
	
}
