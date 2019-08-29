package model;

import model.interfaces.Coin;
import model.interfaces.CoinPair;

/*
 * Class:			CoinPairImpl
 * Description:		The class represents a specific CoinPair Object
 * Author:			Sebastian Wisidagama - s3769969
 */

public class CoinPairImpl implements CoinPair{

	private Coin coin1;
	private Coin coin2;
	
	//CoinPair is constructed with 2 new coin objects
	public CoinPairImpl() {
		this.coin1 = new CoinImpl(1);
		this.coin2 = new CoinImpl(2);
	}
	
	//Getter for coin 1 in coin pair
	@Override
	public Coin getCoin1() {
		return coin1;
	}

	//Getter for coin 2 in coin pair
	@Override
	public Coin getCoin2() {
		return coin2;
	}

	/*Returns true if arguments coinPair 1st coin has same face for coin1 and
	arguments coinPair 2nd coin has same face for coin2. Else returns false*/
	@Override
	public boolean equals(CoinPair coinPair) {
		if (coinPair.getCoin1().equals(coin1) && coinPair.getCoin2().equals(coin2)) {
			return true;
		}
		return false;
	}
	
	/*Returns true if argument object is a coinPair AND arguments coinPair 1st coin has same
	face for coin1 and arguments coinPair 2nd coin has same face for coin2. Else returns false*/
	@Override
	public boolean equals(Object coinPair) {
		if (coinPair instanceof CoinPair){
			return equals((CoinPair)coinPair);
		}
		return false;
	}
	
	/*Generates hash based on coin1 and coin2 hashes using each respectively (4 outcomes assuming
	coin1 always has a number value of 1 and coin2 always has a number value of 2)*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coin1 == null) ? 0 : coin1.hashCode());
		result = prime * result + ((coin2 == null) ? 0 : coin2.hashCode());
		return result;
	}
	
	//Returns string of coinFace details in human readable format
	@Override
	public String toString() {
		return String.format("%s, %s", coin1.toString(), coin2.toString());
	}
}
