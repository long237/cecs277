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
		System.out.println("player 1 hand size: " + player1Hand.size());
		System.out.println("player 2 hand size: " + player2Hand.size());
		System.out.println("this is player 1 hand: " + player1Hand);
		System.out.println("this is player 2 hand: " + player2Hand);
        //System.out.println(players);

		playRound(player1Hand, player2Hand);
		//Check to see who wins the game
		if (player1Hand.size() < 4) {
			System.out.println("Congratulation !!! Player 2 win the game. ");
		}
		else {
			System.out.println("Congratulation !!! Player 1 win the game. ");
		}
		System.out.println("Game over !!!");
    }

    public static void playRound(DeckofCard player1, DeckofCard player2) {
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
				discardPile.clear();
				System.out.println("Player 1 cards after winning the round " + player1);
			}
			else if (player2Card.getRank() > player1Card.getRank()) {
				System.out.println("Player 2 win the round ");
				player2.addDeck(discardPile);
				discardPile.clear();
				System.out.println("Player 2 cards after winning the round " + player2);
			}
			//if 2 cards are of the same rank, initiate war
			else {
				System.out.println("War!!!");
				war(player1,player2);
			}
    	}
	}
	public static void war(DeckofCard player1, DeckofCard player2) {
    	DeckofCard discardPile = new DeckofCard();
    	DeckofCard faceDown = new DeckofCard();
    	DeckofCard tempFaceup = new DeckofCard();
    	boolean sameCard = true;

    	while (sameCard && player1.size() > 4 && player2.size() > 4) {
			//while (player1.size() > 4 && player2.size() > 4) {
				for (int i = 0; i < 3; i++) {
					Card player1FDCard = player1.play();
					Card player2FDCard = player2.play();
					faceDown.add(player1FDCard);
					faceDown.add(player2FDCard);
				}
				System.out.println("this is the face down deck: " + faceDown);
/*    		Card player1Card = player1.play();
    		Card player2Card = player2.play();*/
				Card player1Card = player1.play();
				Card player2Card = player2.play();
				discardPile.add(player1Card);
				discardPile.add(player2Card);

				//discardPile.add(player1.play());
				//discardPile.add(player2.play());
	/*			Card player1Card = discardPile.get(0);
				Card player2Card = discardPile.get(1);*/
				System.out.println("Player 1 play " + player1Card);
				System.out.println("Player 2 play " + player2Card);
				System.out.println("Discard Pile: " + discardPile);

				if (player1Card.getRank() > player2Card.getRank()) {
					System.out.println("Player 1 win the war");
					player1.addDeck(faceDown);
					player1.addDeck(discardPile);
					player1.addDeck(tempFaceup);
					System.out.println("Player 1 deck after winning war: " + player1);

					discardPile.clear();
					faceDown.clear();
					tempFaceup.clear();
					sameCard = false;
				} else if (player2Card.getRank() > player1Card.getRank()) {
					System.out.println("Player 2 win the war");
					player2.addDeck(faceDown);
					player2.addDeck(discardPile);
					player2.addDeck(tempFaceup);
					System.out.println("Player 2 deck after winning war: " + player2);

					discardPile.clear();
					faceDown.clear();
					tempFaceup.clear();
					sameCard = false;
				} else {
					tempFaceup.addDeck(discardPile);
					discardPile.clear();
					System.out.println("Another round of war because 2 players play the same card");

				}
		}
	}
}
