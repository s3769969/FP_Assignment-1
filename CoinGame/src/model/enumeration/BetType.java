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
         @Override
         public void applyWinLoss(Player player, CoinPair spinnerResult)
         {
            // TODO implementation COIN1 get result == COIN 1 spin result
         }
      },
      COIN2{

		@Override
		public void applyWinLoss(Player player, CoinPair spinnerResult) {
			// TODO Auto-generated method stub
			
		}
    	  
      },
      BOTH{

		@Override
		public void applyWinLoss(Player player, CoinPair spinnerResult) {
			// TODO Auto-generated method stub
			
		}
    	  
      },
      NO_BET{

		@Override
		public void applyWinLoss(Player player, CoinPair spinnerResult) {
			// TODO Auto-generated method stub
			
		}
    	  
      };
      
      // TODO finish this class with other enum constants
   
      /**
       * This method is to be overridden for each bet type<br>
       * see assignment specification for betting odds and how win/loss is applied
       * 
       * @param player - the player to apply the win/loss points balance adjustment
       * @param spinnerResult - the CoinPair result of the spinner to compare to
       */
      public abstract void applyWinLoss(Player player, CoinPair spinnerResult);
}