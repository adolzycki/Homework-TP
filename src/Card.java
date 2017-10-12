public class Card implements Comparable<Card> {

    private String name;
    private String suit;
    private int value;

    /**
     * Make new card
     * @param value value of card
     * @param suit color
     */
    Card(int value,String suit) {
        this.value = value;
        this.suit = suit;

        switch(value) {
            case 2: name = "Two";
            break;
            case 3: name = "Three";
                break;
            case 4: name = "Four";
                break;
            case 5: name = "Five";
                break;
            case 6: name = "Six";
                break;
            case 7: name = "Seven";
                break;
            case 8: name = "Eight";
                break;
            case 9: name = "Nine";
                break;
            case 10: name = "Ten";
                break;
            case 11: name = "Jack";
                break;
            case 12: name = "Queen";
                break;
            case 13: name = "King";
                break;
            case 14: name = "Ace";
                break;
        }
    }

    /**
     * Card to string
     * @return Card in string
     */
    @Override
    public String toString() {
        return name + " of " + suit;
    }

    /**
     * Compare cards
     * @param card another card
     * @return -1 or 1
     */
    @Override
    public int compareTo(Card card) {
        return Integer.compare(this.value, card.value);
    }
}
