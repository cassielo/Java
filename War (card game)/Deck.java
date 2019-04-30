import java.util.LinkedList;
import java.util.Random;

/**Deck.java
 * A class that stores information about a deck of cards.
 * @author Cassie Lo
 * @author plo@chapman.edu
 */

/** The Deck class stores a deck of cards in a LinkedList, and provides a
 * function to removes a random card from the deck.
 */

public class Deck{
  private LinkedList<Card> m_deck;

  /** The default constructor creates a deck of cards.
   *	@param none
   */

  public Deck(){
    String[] s_rank = {"clubs", "diamonds", "hearts", "spades"};
    m_deck = new LinkedList<Card>();
    for(int i = 2; i <= 14; i++){
      for(String s: s_rank){
        m_deck.add(new Card(i,s));
      }
    }
  }

  /** Get the cards in the deck.
   *	@param none
   *  @return A linked list representing the cards in the deck
   */

  public LinkedList<Card> getDeck(){
    return m_deck;
  }

  /** Removes a random card from the deck.
   *	@param none
   *  @return An object representing the card removed from the deck
   */

  public Card deal(){
    Random rand = new Random();
    int index = rand.nextInt(m_deck.size());
    return m_deck.remove(index);
  }
}
