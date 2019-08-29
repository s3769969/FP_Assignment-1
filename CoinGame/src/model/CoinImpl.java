package model;

import java.util.Random;

import model.enumeration.CoinFace;
import model.interfaces.Coin;

/*
 * Class:			CoinImpl
 * Description:		The class represents a specific Coin Object
 * Author:			Sebastian Wisidagama - s3769969
 */

public class CoinImpl implements Coin{

	private int number;
	private CoinFace coinFace;
	
	//Coin is constructed with argument as coin number and assigned a random coinFace
	public CoinImpl(int number) {
		this.number = number;
		int randInt = new Random().nextInt(CoinFace.values().length);
		this.coinFace = CoinFace.values()[randInt];
	}
	
	//Getter for coin number
	@Override
	public int getNumber() {
		return number;
	}

	//Getter for coinFace
	@Override
	public CoinFace getFace() {
		return coinFace;
	}

	//Flips the coin face from heads to tails and vice versa depending on current coinFace state
	@Override
	public void flip() {
		if (this.coinFace == CoinFace.HEADS){
			this.coinFace = CoinFace.TAILS;
		}else {
			this.coinFace = CoinFace.HEADS;
		}
	}

	//Returns true if argument coin has same face. Else returns false
	@Override
	public boolean equals(Coin coin) {
		if (this.coinFace == coin.getFace()){
			return true;
		}
		return false;
	}
	
	//Returns true if argument object is a coin and coin has same face. Else returns false
	@Override
	public boolean equals(Object coin) {
		if (coin instanceof Coin){
			return equals((Coin)coin);
		}
		return false;
	}
	
	/*Generates hash based on coinFace and coin number (4 outcomes assuming number is 1 or 2
	and coinFace is either HEADS or TAILS*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coinFace == null) ? 0 : coinFace.hashCode());
		result = prime * result + number;
		return result;
	}
	
	//Returns string of coin details in human readable format
	@Override
	public String toString() {
		return String.format("COIN %d: %s", number, (coinFace == CoinFace.HEADS) ? "Heads" : "Tails");
	}

}
