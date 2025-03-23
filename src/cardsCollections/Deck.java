package cardsCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> cards;
    private byte numDecks;
    private byte numJokers;

    public Deck(byte numDecks, byte numJokers) {
        this.numDecks = numDecks;
        this.numJokers = numJokers;
        this.cards = new ArrayList<>();
        for (int i = 0; i < numDecks; i++) {
            addDeckCards();
        }
        for (int i = 0; i < numJokers; i++) {
            addJoker();
        }
    }

    public void addDeckCards() {
        for (Suit suit : Suit.values()) {
            if (suit == Suit.JOKER) continue;
            for (CardRank rank : CardRank.values()) {
                if (rank != CardRank.JOKER) {
                    cards.add(new Card(suit, rank));
                }
            }
        }
    }

    public void addJoker() {
        cards.add(new Card(Suit.JOKER, CardRank.JOKER));
    }

    private void shuffleCards() {
        Collections.shuffle(cards);
    }

    private void cutCards() {
        Random rand = new Random();
        int cutIndex = rand.nextInt(cards.size() - 1) + 1;
        List<Card> top = new ArrayList<>(cards.subList(0, cutIndex));
        List<Card> bottom = new ArrayList<>(cards.subList(cutIndex, cards.size()));
        cards.clear();
        cards.addAll(bottom);
        cards.addAll(top);
    }

    public List<Card> dealCards(byte num) {
        if (cards.size() < num) {
            System.out.println("NO ENOUGH CARDS");
            return null;
        }
        List<Card> dealt = new ArrayList<>(cards.subList(0, num));
        cards.subList(0, num).clear();
        return dealt;
    }

    public int numberOfTimes(Suit suit, CardRank cardRank) {
        return Collections.frequency(cards, new Card(suit, cardRank));
    }

    public void sortAscendingOrder() {
        Collections.sort(cards);
    }

    public void sortDescendingOrder() {
        cards.sort(Collections.reverseOrder());
    }

    public Card findMin() {
        return Collections.min(cards);
    }

    public Card findMax() {
        return Collections.max(cards);
    }

    public int searchCard(Suit suit, CardRank cardRank) {
        List<Card> sorted = new ArrayList<>(cards);
        Collections.sort(sorted);
        return sorted.indexOf(new Card(suit, cardRank));
    }

    public void listCards() {
        for (Card card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    public void shuffle() {
        shuffleCards();
    }

    public void cut() {
        cutCards();
    }

    public List<Card> getCards() {
        return cards;
    }
}
