/** Each Card object contains a rank and suit that will be a part of a deck */
public class Card {
    /** value of each Card object */
    private int rank;
    /** suit of each Card object */
    private String suit;

    /** Makes the default card have a rank of 1 and a suit of spades*/
    public Card () {
        rank = 1;
        suit = "Spades";
    }

    /**
     * Constructs and sets a Card object with an inputted rank and suit
     *
     * @param userRank  integer assigned to a Card object's rank
     * @param userSuit  suit attribute assigned to a Card object's rank
     */
    public Card (int userRank, String userSuit) {
        rank = userRank;
        suit = userSuit;
    }

    /**
     * Obtains a Card object's rank
     *
     * @return the rank of a Card object
     */
    public int getRank() {
        return rank;
    }

    /**
     * Obtains a Card object's suit
     *
     * @return the suit of a Card object
     */
    public String getSuit() {
        return suit;
    }

    /**
     * String representation of a Card object
     *
     * @return Card object as a string with rank and suit
     */
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
        if(rank == 1) {
            return "Ace of " + suit;
        }
        return rank + " of " + suit;
    }
}