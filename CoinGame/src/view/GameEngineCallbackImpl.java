package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.enumeration.CoinFace;
import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
   private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

   public GameEngineCallbackImpl()
   {
      // NOTE need to also set the console to FINE in %JRE_HOME%\lib\logging.properties
      logger.setLevel(Level.FINE);
   }

   //logs player name, coin number and coin face after each coin flip
   public void playerCoinUpdate(Player player, Coin coin, GameEngine engine)
   {
      // intermediate results logged at Level.FINE
      logger.log(Level.FINE, String.format(" %s coin %s flipped to %s", player.getPlayerName(), coin.getNumber(),
    		  (coin.getFace() == CoinFace.HEADS) ? "Heads" : "Tails"));
   }

   //logs player name and coin pair after both coins have landed
   public void playerResult(Player player, CoinPair coinPair, GameEngine engine)
   {
      // final results logged at Level.INFO
      logger.log(Level.INFO, String.format(" %s, final result=%s", player.getPlayerName(), coinPair.toString()));
   }

   	//logs spinner coin number and coin face after each coin flip
	@Override
	public void spinnerCoinUpdate(Coin coin, GameEngine engine) {
		logger.log(Level.FINE, String.format(" Spinner coin %s flipped to %s", coin.getNumber(),
				(coin.getFace() == CoinFace.HEADS) ? "Heads" : "Tails"));	
	}
	
	//logs all player details and results of betting round after both spinner coins have landed
	@Override
	public void spinnerResult(CoinPair coinPair, GameEngine engine) {
		logger.log(Level.INFO, String.format(" Spinner, final result=%s", coinPair.toString()));
		String playerResults = "";
		for(Player player: engine.getAllPlayers()) {
			playerResults += "\n" + player.toString();
		}
		logger.log(Level.INFO, String.format(" Final Player Results%s", playerResults));
	}
	}
