package model;

import model.interfaces.Coin;
import model.interfaces.CoinPair;

public class CoinPairImpl implements CoinPair{

	private Coin coin1;
	private Coin coin2;
	
	
	@Override
	public Coin getCoin1() {
		return coin1;
	}

	@Override
	public Coin getCoin2() {
		return coin2;
	}

	@Override
	public boolean equals(CoinPair coinPair) {
		// TODO Auto-generated method stub
		return false;
	}

}
