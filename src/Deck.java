import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private int size;
    ArrayList<Card> deck = null;

    /**
     * Main constructor
     * @param size size of deck
     * @throws Exception when wrong size
     */
    Deck(int size) throws Exception {

        if(size != 24 && size != 32 && size != 52)
            throw new Exception("Wrong size");
        this.size = size;
        deckInit();
    }

    /**
     * Constructor
     * @param another construct deck based on another one
     */
    Deck(Deck another) {
        this.size = another.size;
        this.deck = new ArrayList<>(another.deck);

    }

    /**
     * Make deck
     */
    private void deckInit() {

        int i = 0;
        int j = 14;
        deck = new ArrayList<>();
        while(i < size) {
            deck.add(new Card(j,"Clubs"));
            deck.add(new Card(j,"Hearts"));
            deck.add(new Card(j,"Diamonds"));
            deck.add(new Card(j,"Spades"));
            j--;
            i+=4;
        }
    }

    /**
     * Get card
     * @return one card from deck
     */
    String getCard() {
        return deck.get(deck.size()-1).toString();
    }

    /**
     * Shuffle deck
     */
    void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Sort deck
     */
    void sort() {
        Collections.sort(deck);
    }

    public static void main(String[] args) {

        try {
            Deck deck = new Deck(52);
            deck.shuffle();
            System.out.println(deck.getCard());
            deck.sort();
            System.out.println(deck.getCard());
        }
        catch (Exception ignored) {

        }
    }
}
