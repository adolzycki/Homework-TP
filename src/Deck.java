import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private int size;
    ArrayList<Card> deck = null;

    Deck(int size) throws Exception {

        if(size != 24 && size != 32 && size != 52)
            throw new Exception("Wrong size");
        this.size = size;
        deckInit();
    }
    Deck(Deck another) {
        this.size = another.size;
        this.deck = new ArrayList<>(another.deck);

    }

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

    String getCard() {
        return deck.get(deck.size()-1).toString();
    }

     void shuffle() {
        Collections.shuffle(deck);
    }

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
