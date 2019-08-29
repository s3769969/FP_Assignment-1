package model;

import model.interfaces.Coin;
import model.interfaces.CoinPair;

public class CoinPairImpl implements CoinPair{

	private Coin coin1;
	private Coin coin2;
	
	public CoinPairImpl() {
		this.coin1 = new CoinImpl(1);
		this.coin2 = new CoinImpl(2);
	}
	
	@Override
	public Coin getCoin1() {
		return coin1;
	}

	@Override
	public Coin getCoin2() {
		return coin2;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s", coin1.toString(), coin2.toString());
	}

	@Override
	public boolean equals(CoinPair coinPair) {
		if (coinPair.getCoin1().equals(coin1) && coinPair.getCoin2().equals(coin2)) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object coinPair) {
		if (coinPair instanceof CoinPair){
			return equals((CoinPair)coinPair);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coin1 == null) ? 0 : coin1.hashCode());
		result = prime * result + ((coin2 == null) ? 0 : coin2.hashCode());
		return result;
	}
}
