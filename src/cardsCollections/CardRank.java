package cardsCollections;

public enum CardRank {
    JOKER(0),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    J(11),
    Q(12),
    K(13),
    ACE(14);

    private final int value;

    CardRank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

