import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeckofCard {
    private int amountCards = 52;
    private ArrayList<Card> deck;


    public static void main(String[] args){
    }

    public DeckofCard () {
        deck = new ArrayList<Card>();
    }

    public DeckofCard (int numCards) {
        amountCards = numCards;
        deck = new ArrayList<Card>(amountCards);
    }

    //shuffle all the elements in the deck
    public void shuffleCards() {
        Collections.shuffle(deck);
    }

    //divide the cards evenly to multiple players in the game
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

    //remove the first card out of a deck
    public Card play() {
        return deck.remove(0);
    }

    //add one card to the back of the deck
    public void add(Card userCard) {
        deck.add(userCard);
    }

    //add one deck of card to the back of another deck
    public void addDeck(DeckofCard cardDeck) {
        for (int k = 0; k < cardDeck.size() ; k++){
            deck.add(cardDeck.get(k));
        }

    }
    //return the size of the deck
    public int size() {
        return deck.size();
    }

    //reutrn the card in a deck
    public Card get(int index) {
	    return deck.get(index);
    }

    //clear all cards out of a deck
    public void clear() {
        deck.clear();
    }

    public ArrayList<Card> defaultDeck(int rank){
        //array of 1 rank with 4 suits
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

    //Check the deck to see if it is empty
    public boolean isEmpty(){
        return deck.isEmpty();
    }

    public Card backImage(Card warCard){
        warCard = new Card(0,"xx");
        return warCard;
    }

    public String toString() {
        ArrayList <Object> tempArr = new ArrayList <Object> ();
        for (int i = 0; i < deck.size(); i++) {
            tempArr.add(deck.get(i));
        }
        return "" + tempArr;
    }
}
