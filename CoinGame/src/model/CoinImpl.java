package model;

import java.util.Random;

import model.enumeration.CoinFace;
import model.interfaces.Coin;

public class CoinImpl implements Coin{

	private int number;
	private CoinFace coinFace;
	
	public CoinImpl(int number) {
		this.number = number;
		int randInt = new Random().nextInt(CoinFace.values().length);
		this.coinFace = CoinFace.values()[randInt];
	}
	
	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public CoinFace getFace() {
		return coinFace;
	}

	@Override
	public void flip() {
		if (this.coinFace == CoinFace.HEADS){
			this.coinFace = CoinFace.TAILS;
		}else {
			this.coinFace = CoinFace.HEADS;
		}
	}

	@Override
	public boolean equals(Coin coin) {
		if (this.coinFace == coin.getFace()){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object coin) {
		if (coin instanceof Coin){
			return equals((Coin)coin);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coinFace == null) ? 0 : coinFace.hashCode());
		result = prime * result + number;
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("COIN %d: %s", number, (coinFace == CoinFace.HEADS) ? "Heads" : "Tails");
	}

}
