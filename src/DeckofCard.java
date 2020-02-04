import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

/** Models a deck of cards as an object */
public class DeckofCard {
    /** sets the amount of cards in the DeckofCard object to 52*/
    private int amountCards = 52;
    /** represents the deck as an ArrayList */
    private ArrayList<Card> deck;

    /** Constructs the default DeckofCards */
    public DeckofCard () {
        deck = new ArrayList<Card>();
    }

    /** Constructs a DeckofCard object with a certain amount of cards*/
    public DeckofCard (int numCards) {
        amountCards = numCards;
        deck = new ArrayList<Card>(amountCards);
    }

    /** Shuffles all the elements in the deck */
    public void shuffleCards() {
        Collections.shuffle(deck);
    }

    /**
     * Divides the cards evenly to players in the game
     *
     * @param numPlayer amount of players participating in the game
     * @return  players' deck of cards as an ArrayList
     */
    public ArrayList<DeckofCard> deal(int numPlayer) {
        ArrayList<DeckofCard> playerList = new ArrayList<DeckofCard> (numPlayer);

        for (int n = 0; n < numPlayer; n++) {
            playerList.add(new DeckofCard());
        }
        System.out.println("player size: " + playerList.size());

        Iterator deckIterator = deck.iterator();
        for (int i = 0; i < numPlayer; i++) {
            DeckofCard tempArray = playerList.get(i);
            for ( int j = 0; j < (deck.size() / numPlayer); j++) {
                tempArray.add((Card) deckIterator.next());
            }
        }
        return playerList;
    }

    /**
     * Removes the first card out of a deck
     *
     * @return the card that was removed from a deck
     */
    public Card play() {
        return deck.remove(0);
    }

    /**
     * Adds one card to the back of the deck
     *
     * @param userCard  card that will be put at the bottom of the deck
     */
    public void add(Card userCard) {
        deck.add(userCard);
    }

    /**
     * Add one deck of cards to the back of another deck
     *
     * @param cardDeck deck that will be put behind another deck
     */
    public void addDeck(DeckofCard cardDeck) {
        for (int k = 0; k < cardDeck.size() ; k++){
            deck.add(cardDeck.get(k));
        }
    }

    /**
     * Calculates the size of the deck
     *
     * @return the amount of cards in a deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Obtains the card in a deck
     *
     * @param index integer used to get a certain card at a location
     * @return the card at the specific index
     */
    public Card get(int index) {
        return deck.get(index);
    }

    /** Clears all cards out of a deck */
    public void clear() {
        deck.clear();
    }

    /**
     * Assigns each rank to 4 suits
     *
     * @param rank  integer that will be assigned to 4 different suits
     * @return ArrayList of 1 rank with 4 suits
     */
    public ArrayList<Card> defaultDeck(int rank){
        ArrayList<Card> cardsF = new ArrayList<Card>();
        Card card1 = new Card(rank, "Spades");
        Card card2 = new Card(rank, "Hearts");
        Card card3 = new Card(rank, "Clubs");
        Card card4 = new Card(rank, "Diamonds");

        cardsF.add(card1);
        cardsF.add(card2);
        cardsF.add(card3);
        cardsF.add(card4);

        return cardsF;
    }

    /**
     * Checks the deck to see if it is empty
     *
     * @return true or false if the deck is empty
     */
    public boolean isEmpty(){
        return deck.isEmpty();
    }

    /**
     * String representation of the deck
     *
     * @return DeckofCard objects as a string
     */
    public String toString() {
        ArrayList <Object> tempArr = new ArrayList <Object> ();
        for (int i = 0; i < deck.size(); i++) {
            tempArr.add(deck.get(i));
        }
        return "" + tempArr;
    }
}