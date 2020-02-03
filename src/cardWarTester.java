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

        // adds 52 cards into deck
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

        ArrayList<DeckofCard> players = deck.deal(numPlayers);
        System.out.println(players);

        //ArrayList<Card> discardPile = new ArrayList<Card>();
        DeckofCard discardPile = new DeckofCard();
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
        }
    }
}
