package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

/*
 * Class:			SimplePlayer
 * Description:		The class represents a specific player Object
 * Author:			Sebastian Wisidagama - s3769969
 */

public class SimplePlayer implements Player{

	private String playerId;
	private String playerName;
	private int points;
	private int bet = 0;
	private BetType betType = BetType.NO_BET;
	private CoinPair result;
	
	//Constructs player taking id, name and initial points as arguments
	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.points = initialPoints;
	}
	
	//Getter for player name
	@Override
	public String getPlayerName() {
		return playerName;
	}

	//Setter for player name
	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	//Getter for player points
	@Override
	public int getPoints() {
		return points;
	}

	//Setter for player points
	@Override
	public void setPoints(int points) {
		this.points = points;	
	}

	//Getter for player id
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

	//Getter for player bet amount
	@Override
	public int getBet() {
		return bet;
	}

	//Setter for player betType
	@Override
	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	//Getter for player betType
	@Override
	public BetType getBetType() {
		return betType;
	}

	//Sets player bet to 0 and betType to NO_BET
	@Override
	public void resetBet() {
		this.bet = 0;
		this.betType = BetType.NO_BET;
	}

	//Getter for players coinPair results
	@Override
	public CoinPair getResult() {
		return this.result;
	}

	//Setter for players coinPair results after spin
	@Override
	public void setResult(CoinPair coinPair) {
		this.result = coinPair;
	}
	
	//Returns string of player details in human readable format
	@Override
	public String toString() {
		return String.format("Player: id=%s, name=%s, bet=%d, betType=%s,"
				+ " points=%d, RESULT .. %s", playerId, playerName, bet, betType,
				points, result);
	}
	
}
