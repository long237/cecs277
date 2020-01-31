/*Name: Long & Selina Do
 * Date: 01/28/20
 * Purpose: Play a War of Card games between players
 * Inputs: Required the user to provide how many players are playing
 * Output: Bunch of strings
 * Just testing version control
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
        System.out.println(deck);
        // shuffles deck
        deck.shuffleCards();
        System.out.println(deck);
        //System.out.println(deck.deal(numPlayers));

        deck.play();

        System.out.println(deck.play());

        ArrayList<DeckofCard> players = deck.deal(numPlayers);
        System.out.println(players);


        boolean emptyHand = false;
        while (emptyHand == false) {
            for (int i = 0; i < players.size(); i++) {
                emptyHand = players.get(i).isEmpty();
                if (emptyHand) {
                    emptyHand = true;
                }

                Card p = players.get(i).play();

                System.out.println(p);
            }
        }
    }


        //System.out.println(p2);

        //hello
        //deck.play(p1);
        //System.out.println(deck.play(p1));


}
