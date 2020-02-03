/*Name: Long & Selina Do
 * Date: 01/28/20
 * Purpose: Play a War of Card games between players
 * Inputs: Required the user to provide how many players are playing
 * Output: Bunch of strings
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class cardWarTester {
    public static void main(String[] args) {
        // # of players
        Scanner in = new Scanner(System.in);
        System.out.print("How many people will be playing?: ");
        int numPlayers = in.nextInt();

        // create a main dech and adds 52 cards into deck
        DeckofCard deck = new DeckofCard(52);
        for (int i = 1; i < 14; i++) {
            ArrayList<Card> ranks = deck.defaultDeck(i);
            for (int j = 0; j < 4; j++) {
                deck.add(ranks.get(j));
            }
        }

        // shuffles deck
        deck.shuffleCards();
        //System.out.println(deck);
	
	//create an Arraylist that contains multiple decks of card objects that represent
	//each player hands.
        ArrayList<DeckofCard> playersList = deck.deal(numPlayers);
        System.out.println(playersList);
		DeckofCard discardPile = new DeckofCard();
		DeckofCard warDeck = new DeckofCard();

	//boolean contPlay = true;
	int eliminatedPlayers = 0;
	//Keep the game going as long as there are 2 players still have cards
	while (eliminatedPlayers != (numPlayers - 1) ) {
		/*check every players hands and increase the counter
		when a player has no card left*/
		for (int i = 0; i < playersList.size(); i++) {
			if (playersList.get(i).isEmpty()) {
				eliminatedPlayers++;
			}

			//every player play a card each iteration of the while loop
			else {
				/*remove a card from the player hand
				and add it to the discard pile. */
				Card playerCard = playersList.get(i).play();
				System.out.println("Player " + (i + 1) + " plays " + playerCard);
				discardPile.add(playerCard);
			}
		}

		/*compare all the cards on the table and return the
		index of the biggest card (which is also the index of the player */
		int roundWPlayer = discardPile.compareCards();
		System.out.println("this is the winner: " + roundWPlayer);

		//if 2 players play the same card then they enter a war.
/*		if (roundWPlayer == -1) {
			DeckofCard faceDownDeck = war(playersList);
		}

		//other wise add the discardPile to the winning player deck*/
		//else {
		//add the discardPile to the winning player deck
			playersList.get(roundWPlayer).addDeck(discardPile);
		//}
	}





















        //ArrayList<Card> discardPile = new ArrayList<Card>();
        /*DeckofCard discardPile = new DeckofCard();
        boolean emptyHand = false;
        while (!emptyHand) {
            for (int i = 0; i < players.size(); i++) {
                emptyHand = players.get(i).isEmpty();
                if (emptyHand) {
                    break;
                }

                Card p = players.get(i).play();
                System.out.println("Player " + (i+1) + " plays " + p);
                discardPile.add(p);

                // Cards players play are put into an ArrayList to make discard pile
                if ( i == players.size() - 1 ){

                    // find the index(player) that has the biggest rank
                    int biggestIndex = discardPile.compareCards();
                    for (int j = 0; j < players.size() - 1; j++){
                        if (discardPile.get(j).getRank() < discardPile.get(j+1).getRank()){
                            biggestIndex = j+1;
                        }
                        else {
                            biggestIndex = j;
                        }
                    }

                    // Tells who put down the highest card
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("Player " + (biggestIndex+1) + " wins the round");

                    // puts the played cards into the deck that put down the higher rank card (winner's deck
                    DeckofCard winningDeck = players.get(biggestIndex);
                    for (int k = 0; k < players.size() ; k++){
                        winningDeck.add(discardPile.get(k));
                    }
                    discardPile.clear();
                    // shows winning players deck with the added new cards
                    System.out.println("winning deck: " + winningDeck);
                    // shows both players deck after the round
                    System.out.println("both players deck after round: " + players);
                    System.out.println();

                }
            }
            // used to test for 1 round, delete if want to see multiple rounds
            //break;
        } */
    }

/*    public static void war(ArrayList<DeckofCard> players) {
		DeckofCard discardPile = new DeckofCard();
		DeckofCard warDeck = new DeckofCard();
		int keepPlaying = -1;
		while (keepPlaying == -1) {
			for (int i = 0; i < players.size(); i++) {
				for (int j = 0; j < 3; j++) {
					Card faceDown = players.get(i).play();
					warDeck.add(faceDown);
					Card playerCard = players.get(i).play();
					System.out.println("Player " + (i + 1) + " plays " + playerCard);
					discardPile.add(playerCard);
				}
			}
			int wPlayer = discardPile.compareCards();
			if (wPlayer == -1) {
				return warDeck;
			} else {
				players.get(wPlayer).addDeck(discardPile);
				players.get(wPlayer).addDeck(warDeck);
			}
		}
	}*/
}

