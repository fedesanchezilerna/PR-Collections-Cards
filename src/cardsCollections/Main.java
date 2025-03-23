package cardsCollections;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static CardRank dataEntryCardRank(String text) {
        for (CardRank rank : CardRank.values()) {
            if (rank.name().equalsIgnoreCase(text)) {
                return rank;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER NUM OF DECKS: ");
        byte numDecks = sc.nextByte();
        System.out.print("ENTER NUM OF JOKERS: ");
        byte numJokers = sc.nextByte();

        Deck deck = new Deck(numDecks, numJokers);
        int option;

        do {
            System.out.println("""
                    MENU
                    1. LIST CARD
                    2. SHUFFLE CARDS
                    3. CUT CARD
                    4. NUMBER OF TIMES OF CARD
                    5. DEAL CARDS
                    6. SORT ASCENDING ORDER
                    7. SORT DESCENDING ORDER
                    8. SEARCH CARD
                    9. FIND MIN
                    10. FIND MAX
                    0. QUIT
                    """);

            System.out.print("CHOOSE MENU OPTION: ");
            option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option) {
                case 1 -> {
                    System.out.println("LIST CARDS");
                    deck.listCards();
                }
                case 2 -> {
                    deck.shuffle();
                    System.out.println("SHUFFLE CARDS");
                    deck.listCards();
                }
                case 3 -> {
                    deck.cut();
                    System.out.println("CUT CARDS");
                    deck.listCards();
                }
                case 4 -> {
                    System.out.print("ENTER SUIT 1.JOKER 2.CLUBS 3.DIAMONDS 4.HEARTS 5.SPADES: ");
                    int suitInput = sc.nextInt();
                    Suit suit = Suit.values()[suitInput - 1];
                    System.out.print("ENTER CARD [JOKER, TWO, ..., ACE]: ");
                    String rankInput = sc.next().toUpperCase();
                    CardRank rank = dataEntryCardRank(rankInput);
                    System.out.println("NUMBER OF TIMES: " + deck.numberOfTimes(suit, rank));
                }
                case 5 -> {
                    System.out.print("ENTER NUM OF CARDS TO DEAL: ");
                    byte num = sc.nextByte();
                    List<Card> dealt = deck.dealCards(num);
                    if (dealt != null) {
                        for (Card c : dealt) System.out.print(c + " ");
                        System.out.println();
                        deck.listCards();
                    }
                }
                case 6 -> {
                    deck.sortAscendingOrder();
                    System.out.println("SORT ASCENDING ORDER");
                    deck.listCards();
                }
                case 7 -> {
                    deck.sortDescendingOrder();
                    System.out.println("SORT DESCENDING ORDER");
                    deck.listCards();
                }
                case 8 -> {
                    System.out.print("ENTER SUIT 1.JOKER 2.CLUBS 3.DIAMONDS 4.HEARTS 5.SPADES: ");
                    int suitInput = sc.nextInt();
                    Suit suit = Suit.values()[suitInput - 1];
                    System.out.print("ENTER CARD: ");
                    String rankInput = sc.next().toUpperCase();
                    CardRank rank = dataEntryCardRank(rankInput);
                    System.out.println("FIRST POSITION: " + deck.searchCard(suit, rank));
                }
                case 9 -> System.out.println("MIN: " + deck.findMin());
                case 10 -> System.out.println("MAX: " + deck.findMax());
            }
        } while (option != 0);
    }
}
