package sys.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initDeck();
    }

    private void initDeck() {
        Rank[] ranks = Rank.values();
        Suit[] suits = Suit.values();

        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public Card getCard(int index) {
        Card card = cards.get(index);
        cards.remove(index);

        return card;
    }

    public int getDeckSize() {
        return cards.size();
    }
}
