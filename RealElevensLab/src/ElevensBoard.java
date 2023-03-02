import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		if(selectedCards.size()==2){ //checking to make sure that only two cards are selected to add up to 11
			if(containsPairSum11(selectedCards)==true){
				return true;
			}
		}
	if(selectedCards.size()==3){ //if 3 cards are selected then it checks for a J, Q, K
		if(containsJQK(selectedCards)==true){
			return true;
		}
	}
	
		return false; //if the selected cards don't number 2 or 3 then the play is automatically false
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		if(containsPairSum11(super.cardIndexes())== true){ //for all the card indexes is containsPairSum11 true, if it is then another play is possible
			return true;
		}
		if(containsJQK(super.cardIndexes())== true){ //for all the card indexes is containsJQK true, if it is then another play is possible
			return true;
		}

		return false; //if nothing is possible return false
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		//the list contains indexes not card values
		//must use helper method to grab the cards
		//double loop
		for(int i = 0; i < selectedCards.size(); i++){ //checking the indexes of both the selected cards
			for(int k = 1; k < selectedCards.size(); k++){
	if(super.cardAt(selectedCards.get(i)).pointValue() + super.cardAt(selectedCards.get(k)).pointValue() == 11){ //if all the selected cards point values add up to 11 then an 11-pair is possible
			return true; //therefore you return true
					}
				}
		} return false; //if the 11 pair is not possible you return false
	}
		
	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		//single loop
		boolean J = false; // is there a J?
		boolean Q = false; //is there a Q?
		boolean K = false; //is there a K?
	for(int i = 0; i < selectedCards.size(); i++){
		
		if(cardAt(selectedCards.get(i)).pointValue() == 0 && cardAt(selectedCards.get(i)).rank()=="jack"){ //checking to make sure that there is a jack
			J = true; //if there is a Jack then that means you break out of the loop so you can continue checking for other values
			break;
		}
	   if(cardAt(selectedCards.get(i)).pointValue() == 0 && cardAt(selectedCards.get(i)).rank()=="queen"){ //making sure there is a queen
			Q = true; //same as jack but with a queen
			break;
		}
      if(cardAt(selectedCards.get(i)).pointValue() == 0 && cardAt(selectedCards.get(i)).rank()=="king"){ //making sure there is a king
    	   K = true; //same as jack but with a king
    	   break;
        }
	}
		
	if(J && Q && K == true){ // if there is a jack, a queen, and a king, then the play is possible, so you return true
		return true;
		}
	
		return false; //otherwise if the conditions are not all met, then the play is not true or possible
	}
}
