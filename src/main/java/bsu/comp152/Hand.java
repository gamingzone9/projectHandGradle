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
    public Hand(int maxCards) {
        /* Create an array that is capable of storing the specified number of cards, and
         * assign it to the field cards:
         */
        cards = new Card[maxCards];
        // Initialize the numCards field to reflect that the hand is initially empty:
        numCards = 0;
    }

    /**
     * A method that returns the number of cards that are currently in the hand
     *
     * @return
     */
    public int getNumCards() {
        return numCards;
    }

    /**
     * A method that takes a Card object as a parameter and adds it to the Hand
     *
     * @param newCard
     */
    public void addCard(Card newCard) {
        if (newCard == null) {
            throw new IllegalArgumentException("You can't add a null card.");
        }
        if (numCards == cards.length) {
            throw new IllegalStateException("You can't add a card to a full array.");
        }
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
    public int getTotalValue() {
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
     * A method to take an index i and return the card at that position in the cards array
     * @param i
     * @return
     */
    public Card getCard(int i){
        /*
         * If the index is invalid or if there is no card at the specified position in the array,
         * throw an IllegalArgumentException.
         */
        if ((i < 0) || (i >= numCards)){
            throw new IllegalArgumentException("Index specified by the parameter is invalid.");
        }
        if (cards[i] == null){
            throw new IllegalArgumentException("There is no card at the specified position in the array.");
        }
        return cards[i];
    }

    /**
     * A method to returns a String representation of the Hand object of the form
     * "[card0, card1, ..., cardn]", where card0, card1, etc. are the abbreviations of the cards in the hand
     *
     * @return
     */
    public String toString() {
        if (numCards == 0) {
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
     *
     * @param i
     * @return
     */
    public Card playCard(int i) {
        /*
         * If the index specified by the parameter is invalid or
         * if there is no card at the specified position in the array,
         * throw an IllegalArgumentException.
         */
        if ((i < 0) || (i >= numCards)) {
            throw new IllegalArgumentException("Index specified by the parameter is invalid.");
        }
        if (cards[i] == null) {
            throw new IllegalArgumentException("There is no card at the specified position in the array.");
        }
        Card playedCard = cards[i];
        /* Shift over any cards that come after the removed card in the array
         * so as to fill in the "gap" created by the removed card.
         */
        for (int j = i; j < numCards - 1; j++) {
            cards[j] = cards[j + 1];
        }
        // Make any other change needed to the state of the Hand object:
        cards[numCards - 1] = null; // The card at i = numCards - 1 was moved to the left.
        numCards -= 1; // Decrement the number of cards in the Hand.
        return playedCard;
    }

    /**
     * A method to take a parameter specifying a rank and return
     * the number of cards in the Hand with that rank.
     */
    public int numCardsOfRank(int rk){
        int count = 0;
        for (int i = 0; i < numCards; i++){
            // If the ith card has the target rank rk, then increment count.
            if (cards[i].getRank() == rk){
                count++;
            };
        }
        return count;
    }

    /**
     * A method to return true if the Hand includes four cards with the same rank and false if it does not
     * @return
     */
    public boolean hasFourOfAKind() {
        // Call the numCardsOfRank method on all the ranks 1--13.
        for (int rank = 1; rank <= 13; rank++) {
            // If the number of cards of the rank is >= 4, return true.
            if (numCardsOfRank(rank) >= 4){
                return true;
            }
        }
        // If we haven't returned true for any of the ranks, then
        // return false.
        return false;
    }

    /** A method to return whether all of the cards in the Hand have the same suit
     *
     * @return
     */
    public boolean hasFlush(){
        // An empty hand has no flush.
        if (numCards == 0){
            return false;
        }
        /* If there is a flush, figure out what suit it is by
         * looking at the leftmost card.
         */
        int targetSuit = cards[0].getSuit();
        // Loop through all the cards in the hand.
        for (int i = 1; i < numCards; i++)
            // If the suit differs from the suit of the zeroth card, return false.
            if (cards[i].getSuit() != targetSuit){
                return false;
            }
        // If you haven't returned by now, return true.
        return true;
    }

    /**
     * A method to return true if the Hand includes at least three cards with the same rank and false if it does not
     * @return
     */
    public boolean hasThreeOfAKind(){
        // Loop through the ranks 1--13, inclusive.
        for (int rank = 1; rank < 14; rank++) {
            // For each rank, see if the numCards of given rank is at least 2 (greater than 1). If it is, return true.
            // Find the number of cards of the rank. Do this by calling numCards of rank on rank.
            if (numCardsOfRank(rank) > 2){
                return true;
            }
        }
        // If I haven't returned yet, then return false.
        return false;
    }

    /**
     * A method to return true if the Hand includes at least two separate pairs of cards with the same rank
     * and false if it does not.
     */
    public boolean isTwoPairs(){
        // Initialize the number of pairs to 0.
        int numPairs = 0;
        // Loop through the ranks 1--13, inclusive.
        for (int rank = 1; rank < 14; rank++) {
            // For each rank, see if the numCards of given rank is at least 2 (greater than 1).
            // If it is, increment the number of pairs.
            // Find the number of cards of the rank. Do this by calling numCards of rank on rank.
            if (numCardsOfRank(rank) > 1){
                numPairs++;
            }
            if (numPairs > 1){
                return true;
            }
        }
        // If I haven't returned yet, then return false.
        return false;
    }

    /** A method that returns true if the Hand includes at least one pair of cards with the same rank,
     * and false if it does not
     */
    public boolean hasPair(){
        // Loop through the ranks 1--13, inclusive.
        for (int rank = 1; rank < 14; rank++) {
            // For each rank, see if the numCards of given rank is at least 2 (greater than 1). If it is, return true.
            // Find the number of cards of the rank. Do this by calling numCards of rank on rank.
            if (numCardsOfRank(rank) > 1){
                return true;
            }
        }
        // If I haven't returned yet, then return false.
        return false;
    }

    public Card highCard(){
        // Consider the leftmost card.
        Card card = cards[0];
        // Store its value.
        int cardValue = card.getValue();
        // The leftmost card is the highest seen so far.
        Card highestCard = card;
        // The largest value seen so far is the value of the leftmost card.
        int largestValue = cardValue;
        for (int i = 1; i < numCards; i++) {
            card = cards[i]; // Consider the next card.
            cardValue = card.getValue();
            if (cardValue > largestValue) {
                largestValue = cardValue;
                highestCard = card;
            }
        }
        return highestCard;
    }
}