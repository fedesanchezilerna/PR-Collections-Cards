package cardsCollections;

public class Card implements Comparable<Card> {

    private Suit suit;
    private CardRank cardRank;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";

    public Card(Suit suit, CardRank cardRank) {
        this.suit = suit;
        this.cardRank = cardRank;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    private String convertSuit() {
        return switch (suit) {
            case CLUBS -> "\u2663";       // ♣
            case DIAMONDS_ -> "\u2666";   // ♦
            case HEARTS_ -> "\u2665";     // ♥
            case SPADES -> "\u2660";      // ♠
            default -> "JOKER";
        };
    }

    @Override
    public String toString() {
        String color = (suit == Suit.HEARTS_ || suit == Suit.DIAMONDS_) ? ANSI_RED : ANSI_BLACK;
        if (suit == Suit.JOKER) {
            return cardRank.getValue() + "JOKER";
        }
        return color + cardRankToString() + convertSuit() + ANSI_RESET;
    }

    private String cardRankToString() {
        return switch (cardRank) {
            case JOKER -> "0";
            case J -> "J";
            case Q -> "Q";
            case K -> "K";
            case ACE -> "A";
            default -> String.valueOf(cardRank.getValue());
        };
    }

    @Override
    public int compareTo(Card other) {
        if (this.suit.ordinal() != other.suit.ordinal()) {
            return Integer.compare(this.suit.ordinal(), other.suit.ordinal());
        }
        return Integer.compare(this.cardRank.ordinal(), other.cardRank.ordinal());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card card)) return false;
        return suit == card.suit && cardRank == card.cardRank;
    }

    @Override
    public int hashCode() {
        return suit.hashCode() * 31 + cardRank.hashCode();
    }
}
