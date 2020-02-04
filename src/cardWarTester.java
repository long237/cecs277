/*Name: Long Nguyen & Selina Do
 * Date: 02/02/20
 * Purpose: Plays a War of Card game between players
 * Inputs: Requires the user to provide how many players are playing
 * Output: Multiple rounds of the card game War and which player wins
 */

import java.util.ArrayList;
import java.util.Scanner;

/** Used to run and play the card game War*/
public class cardWarTester {
    public static void main(String[] args) {
        // # of players
        Scanner in = new Scanner(System.in);
        System.out.print("How many people will be playing?: ");
        int numPlayers = in.nextInt();

        // adds 52 cards into deck
        DeckofCard deck = new DeckofCard(52);
        for (int i = 2; i < 15; i++) {
            ArrayList<Card> ranks = deck.defaultDeck(i);
            for (int j = 0; j < 4; j++) {
                deck.add(ranks.get(j));
            }
        }

        // Shuffles deck
        deck.shuffleCards();

        // Deals deck to 2 players and assigns the players to a deck
        ArrayList<DeckofCard> players = deck.deal(numPlayers);
        DeckofCard player1Hand = players.get(0);
        DeckofCard player2Hand = players.get(1);

        // Plays a game to see who wins
        oneGame(player1Hand, player2Hand);

        // Checks to see who wins the game
        if (player1Hand.size() < 4) {
            System.out.println("Congratulations !!! Player 2 wins the game. ");
        }
        else {
            System.out.println("Congratulations !!! Player 1 wins the game. ");
        }
        System.out.println("Game over !!!");
    }

    /**
     * Keeps the game going as long as both players have more than 4 cards
     *
     * @param player1   deck of player 1
     * @param player2   deck of player 2
     */
    public static void oneGame(DeckofCard player1, DeckofCard player2) {
        DeckofCard discardPile = new DeckofCard();
        while (player1.size() > 4 && player2.size() > 4) {
            Card player1Card = player1.play();
            Card player2Card = player2.play();
            discardPile.add(player1Card);
            discardPile.add(player2Card);
            System.out.println("Player 1 plays: " + player1Card);
            System.out.println("Player 2 plays: " + player2Card);
            // if player 1 has the bigger card, add both cards to player 1's hand.
            if (player1Card.getRank() > player2Card.getRank()) {
                System.out.println("Player 1 wins the round ");
                player1.addDeck(discardPile);
                // Clears the discard pile after player 1 takes it
                discardPile.clear();
                System.out.println();
            }
            // if player 2 has the bigger card, add the discard pile to player 2's hand.
            else if (player2Card.getRank() > player1Card.getRank()) {
                System.out.println("Player 2 wins the round ");
                player2.addDeck(discardPile);
                // clears the discard pile after player 2 takes it
                discardPile.clear();
                System.out.println();
            }
            // if 2 cards are of the same rank, initiate war
            else {
                System.out.println("War!!!");
                war(player1,player2);
            }
        }
    }

    /**
     * War part of the game
     *
     * @param player1   deck of player 1
     * @param player2   deck of player 2
     */
    public static void war(DeckofCard player1, DeckofCard player2) {
        // Deck to keep all of the face-down cards both players put down
        DeckofCard discardPile = new DeckofCard();
        DeckofCard faceDown = new DeckofCard();

        // Stores the face up cards from previous round in case of continuous wars
        DeckofCard tempFaceup = new DeckofCard();
        boolean sameCard = true;

        // Keeps playing war as long as both players have the same cards and both
        // players have more than 4 cards
        while (sameCard && player1.size() > 4 && player2.size() > 4) {
            // Adds 3 cards to the faceDown deck from both players
            for (int i = 0; i < 3; i++) {
                Card player1FDCard = player1.play();
                System.out.println("Player 1 play xx");
                Card player2FDCard = player2.play();
                System.out.println("Player 2 play xx");
                faceDown.add(player1FDCard);
                faceDown.add(player2FDCard);
            }
            // Plays 2 face up cards and adds to the discard pile
            Card player1Card = player1.play();
            Card player2Card = player2.play();
            discardPile.add(player1Card);
            discardPile.add(player2Card);

            System.out.println("war card for Player 1 is " + player1Card);
            System.out.println("war card for Player 2 is " + player2Card);

            // If player 1 has the higher rank card, player 1 takes all the face down cards, discardPile cards, and
            // discardPile cards of the previous round stored in the tempFaceup deck, if there are any (for multiple war
            // at once case)
            if (player1Card.getRank() > player2Card.getRank()) {
                System.out.println("Player 1 wins the war");
                player1.addDeck(faceDown);
                player1.addDeck(discardPile);
                player1.addDeck(tempFaceup);
                System.out.println();

                // Clears the discard pile
                discardPile.clear();
                // Clears the faceDown deck since player 1 took them
                faceDown.clear();
                // Clears tempFaceup deck because player 1 also won those
                tempFaceup.clear();
                sameCard = false;
            }
            // If player 2 has the higher rank card, player 1 takes all the face down cards, discardPile cards, and
            // discardPile cards of the previous round stored in the tempFaceup deck, if there are any (for multiple war
            // at once case)
            else if (player2Card.getRank() > player1Card.getRank()) {
                System.out.println("Player 2 wins the war");
                player2.addDeck(faceDown);
                player2.addDeck(discardPile);
                player2.addDeck(tempFaceup);
                System.out.println();

                discardPile.clear();
                // Clears the faceDown deck since player 2 took them
                faceDown.clear();
                // Clears tempFaceup deck because player 2 also won those
                tempFaceup.clear();
                sameCard = false;
            }
            // If both players still play the same cards, save the played cards (face up) into the
            // tempFaceup deck and clear the discardPile. All cards in faceDown deck are
            // kept intact for whoever wins the next war to take
            else {
                tempFaceup.addDeck(discardPile);
                discardPile.clear();
                System.out.println("Another round of war because 2 players played the same card");
            }
        }
    }
}