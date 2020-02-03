import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeckofCard {
    private int amountCards = 52;
    private ArrayList<Card> deck;


    public static void main(String[] args){
        ArrayList<String> array1 = new ArrayList<String>(5);
        array1.add("hi");
        array1.add("base");
        array1.add("nice");
        array1.add("change");
        array1.add("noice");
        array1.add("hello");
        Collections.shuffle(array1);

        DeckofCard hand1 = new DeckofCard(5);
        Card card1 = new Card();
        Card card2 = new Card(2, "glove");

        Card card3 = new Card(3, "glove");
        Card card4 = new Card(4, "glove");
        Card card5 = new Card(5, "glove");
        Card card6 = new Card(6, "glove");
        Card card7 = new Card(7, "glove");
        Card card8 = new Card(8, "glove");
        Card card9 = new Card(9, "glove");
        hand1.add(card1);
        hand1.add(card2);
        hand1.add(card3);
        hand1.add(card4);
        hand1.add(card5);
        hand1.add(card6);
        hand1.add(card7);
        hand1.add(card8);
        hand1.add(card9);
        System.out.println(hand1.size());
        //ArrayList<DeckofCard> arr1 = hand1.deal(2);
        System.out.println(hand1.deal(2).size());
        System.out.println(card4);
    }

    public DeckofCard () {
        deck = new ArrayList<Card>();
    }

    public DeckofCard (int numCards) {
        amountCards = numCards;
        deck = new ArrayList<Card>(amountCards);
    }

    public void shuffleCards() {
        Collections.shuffle(deck);
    }

    public ArrayList<DeckofCard> deal(int numPlayer) {
        amountCards = amountCards % numPlayer;
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

    public Card play() {
        return deck.remove(0);
    }

    public void add(Card userCard) {
        deck.add(userCard);
    }
    public void addDeck(DeckofCard cardDeck) {
        for (int k = 0; k < cardDeck.size() ; k++){
	        deck.add(cardDeck.get(k));
        }
    }
    /*public boolean addFront(DeckofCard cardDeck) {
	deck.addAll(cardDeck);
	}*/
    public int size() {
        return deck.size();
    }

    public Card get(int index) {
	    return deck.get(index);
    }

    public void clear() {
        deck.clear();
    }

    /**This method is to compare all the cards in the deck and
     * @return biggestCard, @param deckofcard
     */
    public int compareCards() {
        int biggestIndex = 0;
        //iterate the the arraryList and update the largest card.
        for (int j = 1; j < deck.size() - 1; j++){
            if (deck.get(j).getRank() == deck.get(biggestIndex).getRank()) {
                System.out.println("initiate war");
                return -1;
            }
            else if (deck.get(j).getRank() > deck.get(biggestIndex).getRank()) {
                biggestIndex = j;


            }
            System.out.println("biggest index: " + biggestIndex);
            return biggestIndex;
        }

        return biggestIndex;
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
