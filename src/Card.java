
public class Card {
	private int rank;
	private String suit;

        public static void main(String[] args){
	}
	
	public Card () {
		rank = 2;
		suit = "Heart";
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
		return rank + " of " + suit;
	}

	 
}

