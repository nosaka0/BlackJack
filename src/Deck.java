import java.util.ArrayList;
import java.util.Random;

/**
 * Deck of playing Card objects.
 */
public class Deck {
	private ArrayList<Card> deck = new ArrayList<>();

	/**
	 * Constructor for Deck. Populates deck with a number of cards
	 * @param freshDeck whether to reset suit/ranks to create a fresh deck
	 * @param numberOfCards number of cards to populate
	 */
	Deck(boolean freshDeck, int numberOfCards){
		if(freshDeck) {
			Card.resetSuitIndex();  //if freshDeck is true, then reset suit index of cards
		}
		populate(numberOfCards);
	}

	/**
	 * Getter for deck
	 * @return returns ArrayList of type Card
	 */
	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void add(Card card){
		deck.add(card);
	}

	public void add(ArrayList<Card> cards){
		deck.addAll(cards);
		this.shuffle(); //ensure it's shuffled after adding card
	}

	public Card deal(){
		Card c = deck.get(0);
		deck.remove(c);
		deck.subList(0,0).clear();
		return c;
	}

	public ArrayList<Card> deal(int numberOfCards){
		ArrayList<Card> cardsToDeal = new ArrayList<>();

		for(int i = 0; i < numberOfCards; i++){
			cardsToDeal.add(deck.get(0));
			deck.remove(deck.get(0));
			deck.subList(0,0).clear();
		}

		return cardsToDeal;
	}

	public void populate(int numberOfCards){
		for(int i = 0; i < numberOfCards; i++){
			deck.add(new Card(i));
		}
	}

	public void shuffle(){
		Random rand = new Random(System.currentTimeMillis());
		int a,b;
		int shuffleLimit = deck.size() * deck.size();

		for(int i = 0; i < shuffleLimit; i++){
			a = rand.nextInt(deck.size());
			b = rand.nextInt(deck.size());

			swap(a,b);
		}
	}

	public void swap(int a, int b){
		Card temp = deck.get(a);
		deck.set(a,deck.get(b));
		deck.set(b, temp);
	}


	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		for(Card c : deck){
			str.append(c.toString()).append("  ");
		}
		return str.toString();
	}
}
