/* A class to create Hand objects and get to know them

  Starter code from Computer Science 111, Boston University

  Modified by Laura K. Gross, COMP 152, Bridgewater State University

  Completed by: [student name], [student email]
          date: [date of completion]
 */
package bsu.comp152;

public class Hand {
    /* Constants for types of hands
     * The numbers used for the hand types increase
     * with the value of the hand type.
     * For example, four-of-a-kind is the highest-valued
     * hand type that we support, and it has the highest
     * numeric value.
     */
    private static final int HIGH_CARD = 0;
    private static final int PAIR = 1;
    private static final int TWO_PAIRS = 2;
    private static final int THREE_OF_A_KIND = 3;
    private static final int FLUSH = 4;
    private static final int FOUR_OF_A_KIND = 5;

    // The instance fields for a Hand object
    // The Card objects in the Hand object are stored in array called cards.
    // Declare the array of Card objects.
    private Card[] cards;
    // The number of cards in the hand is called numCards.
    // Declare it as an integer.
    private int numCards;

    /**
     * A constructor that takes a single integer parameter specifying the maximum number
     * of cards that the hand holds
     */
    public Hand(int maxCards){
        /* Create an array that is capable of storing the specified number of cards, and
         * assign it to the field cards:
         */
        cards = new Card[maxCards];
        // Initialize the numCards field to reflect that the hand is initially empty:
        numCards = 0;
    }

    /** A method that returns the number of cards that are currently in the hand
     *
     * @return
     */
    public int getNumCards(){
        return numCards;
    }

    /**
     * A method that takes a Card object as a parameter and adds it to the Hand
     * @param newCard
     */
    public void addCard(Card newCard){
        // To do:
        // If the parameter is null, the method should throw an IllegalArgumentException.
        // To do:
        // If the array is full, the method should throw an IllegalStateException.
        /* Put the new card in the next available position in the array --
         * filling the array from left to right:
         */
        cards[numCards] = newCard;
        // Make any other appropriate change to the state of the Hand object:
        numCards++;  // or numCards = numCards + 1; or numCards += 1;
    }

    /**
     * A method to compute and return the sum of the values of the cards
     * in the cards array
     */
    public int getTotalValue(){
        int totalValue = 0;
        // If the the Hand is not empty, the loop iterates 0 times.
        for (int i = 0; i < numCards; i++) {
        /* Don't loop through element-by-element with:
         * for (Card c : cards)
         * . Belated thank you, Talia!!
         * That loop would make c = cards[i] = null for i >= numCards!
         * Ex: cards = {2D, AD, KS, 10C, 10H, null, null, null, null,
         * null, null, null, null, null, null}
         */
            totalValue = totalValue + cards[i].getValue();
        }
        return totalValue;
    }

    /**
     * A method to returns a String representation of the Hand object of the form
     * "[card0, card1, ..., cardn]", where card0, card1, etc. are the abbreviations of the cards in the hand
     * @return
     */
    public String toString(){
        if (numCards == 0){
            return "[]";
        }
        // If the method hasn't returned yet, there is at least one card in the Hand.
        String str = "[" + cards[0].getAbbrev();
        for (int i = 1; i < numCards; i++) {
            str = str + ", " + cards[i].getAbbrev();
        }
        return str + "]";
    }

    /**
     * A method to take an index i and play the card at that position in the cards array
     * @param i
     * @return
     */
    public Card playCard(int i){
        /* To do:
         * If the index specified by the parameter is invalid or
         * if there is no card at the specified position in the array,
         * throw an IllegalArgumentException.
         */
        Card playedCard = cards[i];
        /* Shift over any cards that come after the removed card in the array
         * so as to fill in the "gap" created by the removed card.
         */
        for (int j = i; j < numCards-1; j++) {
            cards[j] = cards[j + 1];
        }
        // Make any other change needed to the state of the Hand object:
        numCards -= 1; // Decrement the number of cards in the Hand.
        return playedCard;
    }
}
