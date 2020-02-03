
public class Card {
	private int rank;
	private String suit;

        public static void main(String[] args){
	}
	
	public Card () {
		rank = 1;
		suit = "Spades";
	}

	public Card (int userRank, String userSuit) {
		rank = userRank;
		suit = userSuit;
	}
	public int getRank() {
		return rank;
	}

	public String getSuit() {
		return suit;
	} 
	
	/**This method is to compare all the cards in the deck and 
	 * @return biggestCard, @param deckofcard
	 */

	public String toString() {
		return rank + " of " + suit;
	}

	 
}

