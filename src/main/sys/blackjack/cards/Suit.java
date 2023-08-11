package sys.blackjack.cards;

public enum Suit {
    CLUBS('\u2663'),
    DIAMONDS('\u2666'),
    HEARTS('\u2665'),
    SPADES('\u2660');

    private char symbol;

    Suit(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }
}
