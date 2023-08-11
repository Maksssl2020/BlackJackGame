package sys.blackjack.cards;

public class Card {
    private final Rank cardRank;
    private final Suit cardSuit;

    public Card(Rank cardRank, Suit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int getValue() {
        return this.cardRank.getValue();
    }

    public String getCardRank() {
        return this.cardRank.toString();
    }

    @Override
    public String toString() {
        StringBuilder cardBuilder = new StringBuilder();
        cardBuilder
                .append(this.cardRank.toString())
                .append(" ")
                .append(this.cardSuit.getSymbol());

        return cardBuilder.toString();
    }
}
