package model;

import model.enumeration.CoinFace;
import model.interfaces.Coin;

public class CoinImpl implements Coin{

	private int number;
	private CoinFace coinFace;
	
	
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
		if (coinFace == coinFace.HEADS){
			coinFace = coinFace.TAILS;
		}else {
			coinFace = coinFace.HEADS;
		}
	}

	@Override
	public boolean equals(Coin coin) {
		// TODO Auto-generated method stub
		return false;
	}

}
