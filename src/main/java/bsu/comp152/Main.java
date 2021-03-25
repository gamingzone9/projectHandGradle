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
package bsu.comp152;

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

        Hand h = new Hand(15);
        h.addCard(c1);
        h.addCard(c2);
        h.addCard(c3);
        h.addCard(c4);
        h.addCard(c5);

        System.out.println("h: " + h);
        System.out.println("Type is " + h.handType());
        System.out.println();
        // System.out.printf("Hand h has %d cards.\n", h.getNumCards());
        // System.out.printf("The total value of h is %d.\n", h.getTotalValue());

        // System.out.println("Play the card in position 1: " + h.playCard(1));
        // System.out.println(h);
        // System.out.println("Play the card in position 2: " + h.playCard(2));
        // h.playCard(2);
        // System.out.println(h);

        Hand h2 = new Hand(15);

        Card card1 = new Card(3, Card.SPADES);
        h2.addCard(card1);
        Card card2 = new Card(4, Card.CLUBS);
        h2.addCard(card2);
        Card card3 = new Card(4, Card.HEARTS);
        h2.addCard(card3);
        Card card5 = new Card(4, Card.SPADES);
        h2.addCard(card5);
        Card card6 = new Card(4, Card.DIAMONDS);
        h2.addCard(card6);

        System.out.println("h2: " + h2);
        // System.out.println(h2.hasThreeOfAKind());
        System.out.println("Type is " + h2.handType());
        System.out.println();

        var h3 = new Hand(15);
        h3.addCard(new Card(2, Card.DIAMONDS));
        h3.addCard(new Card(Card.ACE, Card.DIAMONDS));
        h3.addCard(new Card(Card.KING, Card.SPADES));
        h3.addCard(new Card(10, Card.CLUBS));
        h3.addCard(new Card(7, Card.HEARTS));
        System.out.println("h3: " + h3);
        System.out.println("Type is " + h3.handType());
        System.out.println();

        var h4 = new Hand(15);
        h4.addCard(new Card(2, Card.DIAMONDS));
        h4.addCard(new Card(2, Card.SPADES));
        h4.addCard(new Card(Card.KING, Card.SPADES));
        h4.addCard(new Card(10, Card.CLUBS));
        h4.addCard(new Card(10, Card.HEARTS));
        System.out.println("h4: " + h4);
        System.out.println("Type is " + h4.handType());
        System.out.println();

        Hand h5 = new Hand(15);
        h5.addCard(new Card(2, Card.DIAMONDS));
        h5.addCard(new Card(2, Card.SPADES));
        h5.addCard(new Card(2, Card.HEARTS));
        h5.addCard(new Card(10, Card.CLUBS));
        h5.addCard(new Card(10, Card.HEARTS));
        System.out.println("h5: " + h5);
        System.out.println("Type is " + h5.handType());
        System.out.println();

        Hand h6 = new Hand(15);
        h6.addCard(new Card(2, Card.DIAMONDS));
        h6.addCard(new Card(Card.ACE, Card.DIAMONDS));
        h6.addCard(new Card(Card.KING, Card.DIAMONDS));
        h6.addCard(new Card(10, Card.DIAMONDS));
        h6.addCard(new Card(7, Card.DIAMONDS));
        System.out.println("h6: " + h6);
        System.out.println("Type is " + h6.handType());
        System.out.println();
    }
}