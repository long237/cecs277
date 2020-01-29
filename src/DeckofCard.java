import java.util.Collections;
import java.util.ArrayList;
public class DeckofCard {
	private int amountCards;
	private Object deck;
        public static void main(String[] args){
		ArrayList<String> array1 = new ArrayList<String>(5);
		array1.add("hi");
		array1.add("base");	
		array1.add("nice");
		array1.add("change");
		array1.add("noice");
		array1.add("hello");
		Collections.shuffle(array1);
		
	}
	
	public DeckofCard () {
		ArrayList<String> deck = new ArrayList<String>(52);
	
	}
	
	public DeckofCard (int numCards) {
		amountCards = numCards;
		ArrayList<String> deck = new ArrayList<String>(amountCards);
	}

	public void shuffleCards() {
		Collections.shuffle(deck);
	}

	public void deal() {
	}

	public void play() {

	}

	public void add() {
	} 
	
	public bool isEmpty() {
	}
	
}
