package model.enumeration;

import model.interfaces.CoinPair;
import model.interfaces.Player;

/**
 * Provided enum type for Further Programming representing a type of Bet<br>
 * See inline comments for where you need to provide additional code
 * 
 * @author Caspar Ryan
 * 
 */
public enum BetType
{	
      COIN1
      {
    	  /*Checks if player's 1st coin is equal to spinner's 1st coin after spinning and adds bet value
    	  to player points. Else subtracts bet value from player points*/
         @Override
         public void applyWinLoss(Player player, CoinPair spinnerResult)
         {
        	 if (player.getResult().getCoin1().equals(spinnerResult.getCoin1())) {
        		 player.setPoints(player.getPoints() + player.getBet());
        	 }else {
        		 player.setPoints(player.getPoints() - player.getBet());
        	 }
         }
      },
      COIN2
      {
    	  /*Checks if player's 1st coin is equal to spinner's 1st coin after spinning and adds bet value
    	  to player points. Else subtracts bet value from player points*/
		@Override
		public void applyWinLoss(Player player, CoinPair spinnerResult) {
			if (player.getResult().getCoin2().equals(spinnerResult.getCoin2())) {
				player.setPoints(player.getPoints() + player.getBet());
       	 	}else {
       	 		player.setPoints(player.getPoints() - player.getBet());
       	 	}
		}   	  
      },
      BOTH{
    	  /*Checks if player's 1st coin is equal to spinner's 1st coin AND player's 2nd coin is equal to spinner's
    	  2nd coin after spinning adds twice bet value to player points. Else subtracts bet value from player points*/
		@Override
		public void applyWinLoss(Player player, CoinPair spinnerResult) {
			if (player.getResult().equals(spinnerResult)) {
				player.setPoints(player.getPoints() + player.getBet()*2);
			}else {
       		 	player.setPoints(player.getPoints() - player.getBet());
			}
		}  	  
      },
      NO_BET{
    	  //Does nothing as player is not betting this round
		@Override
		public void applyWinLoss(Player player, CoinPair spinnerResult) {		
		}  
      };
   
      /**
       * This method is to be overridden for each bet type<br>
       * see assignment specification for betting odds and how win/loss is applied
       * 
       * @param player - the player to apply the win/loss points balance adjustment
       * @param spinnerResult - the CoinPair result of the spinner to compare to
       */
      public abstract void applyWinLoss(Player player, CoinPair spinnerResult);
}