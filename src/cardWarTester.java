/*Name: Long & Selina Do
 * Date: 01/28/20
 * Purpose: Play a War of Card games between players
 * Inputs: Required the user to provide how many players are playing
 * Output: Bunch of strings
 */
import java.io.CharArrayReader;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
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
        DeckofCard player1Hand = players.get(0);
        DeckofCard player2Hand = players.get(1);

        oneGame(player1Hand, player2Hand);
        //Check to see who wins the game
        if (player1Hand.size() < 4) {
            System.out.println("Congratulation !!! Player 2 win the game. ");
        }
        else {
            System.out.println("Congratulation !!! Player 1 win the game. ");
        }
        System.out.println("Game over !!!");
    }
    //keep the game going a long as both players have more than 4 cards
    public static void oneGame(DeckofCard player1, DeckofCard player2) {
        DeckofCard discardPile = new DeckofCard();
        while (player1.size() > 4 && player2.size() > 4) {
            Card player1Card = player1.play();
            Card player2Card = player2.play();
            discardPile.add(player1Card);
            discardPile.add(player2Card);
            System.out.println("Player 1 play: " + player1Card);
            System.out.println("Player 2 play: " + player2Card);
            //if player 1 has the bigger card, add the both cards to player 1 hand.
            if (player1Card.getRank() > player2Card.getRank()) {
                System.out.println("Player 1 win the round ");
                player1.addDeck(discardPile);
                //clear the discard pile after player 1 takes it
                discardPile.clear();
                //System.out.println("Player 1 cards after winning the round " + player1);
                System.out.println("");
            }
            //if player 2 has the bigger card, add the discard pile to player 2 hand.
            else if (player2Card.getRank() > player1Card.getRank()) {
                System.out.println("Player 2 win the round ");
                player2.addDeck(discardPile);
                //clear the discard pile after player 2 took it
                discardPile.clear();
                //System.out.println("Player 2 cards after winning the round " + player2);
                System.out.println("");
            }
            //if 2 cards are of the same rank, initiate war
            else {
                System.out.println("War!!!");
                war(player1,player2);
            }
        }
    }
    //War
    public static void war(DeckofCard player1, DeckofCard player2) {
        //faceDown cards to keep all of the face-down cards both players put down
        DeckofCard discardPile = new DeckofCard();
        DeckofCard faceDown = new DeckofCard();
        //tempFaceup store face up cards from previous round in a case of continous wars
        DeckofCard tempFaceup = new DeckofCard();
        boolean sameCard = true;

        /*keep playing war as long as both players has the same cards and both
        players have more than 4 cards */
        while (sameCard && player1.size() > 4 && player2.size() > 4) {
            //add 3 cards to the faceDown deck from both players
            for (int i = 0; i < 3; i++) {
                Card player1FDCard = player1.play();
                System.out.println("Player 1 play xx");
                Card player2FDCard = player2.play();
                System.out.println("Player 2 play xx");
                faceDown.add(player1FDCard);
                faceDown.add(player2FDCard);
            }
            //System.out.println("this is the face down deck: " + faceDown);
            //play 2 face up cards and add to the discard pile
            Card player1Card = player1.play();
            Card player2Card = player2.play();
            discardPile.add(player1Card);
            discardPile.add(player2Card);

            System.out.println("Player 1 play " + player1Card);
            System.out.println("Player 2 play " + player2Card);
            //System.out.println("Discard Pile: " + discardPile);

            /*If player 1 has the higher rank card, player 1 takes all the face down cards, discardPile cards and
            discardPile cards of the previous round store in the tempFaceup deck if there are any (for multiple war
            at once case) */
            if (player1Card.getRank() > player2Card.getRank())
            {
                System.out.println("Player 1 win the war");
                player1.addDeck(faceDown);
                player1.addDeck(discardPile);
                player1.addDeck(tempFaceup);
                //System.out.println("Player 1 deck after winning war: " + player1);
                System.out.println("");

                //clear the discard pile
                discardPile.clear();
                //clear the faceDown deck since player 1 took them
                faceDown.clear();
                //clear tempFaceup deck because player 1 also won those
                tempFaceup.clear();
                sameCard = false;
            }
            /*If player 2 has the higher rank card, player 1 takes all the face down cards, discardPile cards and
            discardPile cards of the previous round store in the tempFaceup deck if there are any (for multiple war
            at once case) */
            else if (player2Card.getRank() > player1Card.getRank())
            {
                System.out.println("Player 2 win the war");
                player2.addDeck(faceDown);
                player2.addDeck(discardPile);
                player2.addDeck(tempFaceup);
                //System.out.println("Player 2 deck after winning war: " + player2);
                System.out.println("");

                discardPile.clear();
                //clear the faceDown deck since player 2 took them
                faceDown.clear();
                //clear tempFaceup deck because player 2 also won those
                tempFaceup.clear();
                sameCard = false;
            }
            /*if both players still play the same cards, save the played cards (face up) into the
            tempFaceup deck and clear the discardPile. All cards in faceDown deck are
            kept intact for whoever wins the next war to take*/
            else
                {
                tempFaceup.addDeck(discardPile);
                discardPile.clear();
                System.out.println("Another round of war because 2 players play the same card");
            }
        }
    }
}
