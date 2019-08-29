package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SimplePlayer implements Player{

	private String playerId;
	private String playerName;
	private int points;
	private int bet = 0;
	private BetType betType = BetType.NO_BET;
	private CoinPair result;
	
	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.points = initialPoints;
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

	/*Returns true if bet is greater than 1 and player has at least as many points.
	Else, resets bet and returns false.*/
	@Override
	public boolean setBet(int bet) {
		if (points >= bet && bet > 0) {
			this.bet = bet;
			return true;
		}
		resetBet();
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
		this.betType = BetType.NO_BET;
	}

	@Override
	public CoinPair getResult() {
		return this.result;
	}

	@Override
	public void setResult(CoinPair coinPair) {
		this.result = coinPair;
	}
	
	@Override
	public String toString() {
		return String.format("Player: id=%s, name=%s, bet=%d, betType=%s,"
				+ " points=%d, RESULT .. %s", playerId, playerName, bet, betType,
				points, result);
	}
	
}
