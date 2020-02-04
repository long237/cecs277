
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

	public String toString() {
		if(rank == 11) {
			return "Jack of " + suit;
		}
		if(rank == 12) {
			return "Queen of " + suit;
		}
		if(rank == 13) {
			return "King of " + suit;
		}
		if(rank == 14
		) {
			return "Ace of " + suit;
		}
		return rank + " of " + suit;
	}

	 
}

