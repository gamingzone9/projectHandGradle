package bsu.comp152;
/*
 *
 * A sample driver program for testing the Hand class
 *
 * Starter code by Laura K. Gross, COMP 152, Bridgewater State University
 *
 * Completed by: [student name], [student email]
 *         date: [date of completion]
 *
 * You may modify this code for testing purposes.  I will not grade it.
 */
public class Main {

    public static void main(String[] args) {

        // Test the Card class.

        // Create a Card object with reference variable c1.
        Card c1 = new Card(2, Card.DIAMONDS);
        // Create a Card object with reference variable c2.
        Card c2 = new Card(Card.ACE, Card.DIAMONDS);
        Card c3 = new Card(Card.KING, Card.SPADES);
        Card c4 = new Card(10, Card.CLUBS);
        // In place of inline initialization, we can split up the declaration and assignment.
        Card c5;
        c5 = new Card(10, Card.HEARTS);

        System.out.println(Card.ACE);
        System.out.println(c1.getRank());
        System.out.println(c1.getSuit());
        System.out.println(c1.getValue());
        System.out.println();
        System.out.println(c1);
        System.out.println(c1.getAbbrev());
        System.out.println(c2);
        System.out.println(c2.getAbbrev());
        System.out.println(c3);
        System.out.println(c3.getAbbrev());

        Hand h = new Hand(15);
        System.out.printf("Hand h has %d cards.\n", h.getNumCards());
        System.out.println(h);
        System.out.printf("The total value of h is %d.\n", h.getTotalValue());
        h.addCard(c1);
        System.out.println(h);
        System.out.printf("The total value of h is %d.\n", h.getTotalValue());
        h.addCard(c2);
        System.out.println(h);
        System.out.printf("The total value of h is %d.\n", h.getTotalValue());
        h.addCard(c3);
        System.out.println(h);
        System.out.printf("The total value of h is %d.\n", h.getTotalValue());
        h.addCard(c4);
        System.out.println(h);
        System.out.printf("The total value of h is %d.\n", h.getTotalValue());
        h.addCard(c5);
        System.out.println(h);
        System.out.printf("The total value of h is %d.\n", h.getTotalValue());

        System.out.println("Play the card in position 1: " + h.playCard(1));
        System.out.println(h);
        System.out.println("Play the card in position 2: " + h.playCard(2));
        h.playCard(2);
        System.out.println(h);

        Hand h2 = new Hand(15);
        Card card1 = new Card(3, Card.SPADES);
        h2.addCard(card1);
        Card card2 = new Card(4, Card.CLUBS);
        h2.addCard(card2);
        Card card3 = new Card(4, Card.HEARTS);
        h2.addCard(card3);
        System.out.println(h2);
        System.out.println(h2.highCard());
    }
}