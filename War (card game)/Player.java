import java.util.LinkedList;

/**Player.java
 * A class that stores information about a player.
 * @author Cassie Lo
 * @author plo@chapman.edu
 */

/** The Player class stores a number (1 or 2) of player and owned cards, and
 * provides functions to filp a card from the top, collect a card to the bottom,
 * calculate the owned cards' size and get a specific card's value as well as
 * public methods to check if a player owned all 52 cards and handles the siuation
 * of war when breaking ties.
 */

public class Player{
  private int m_player;
  private LinkedList<Card> m_cards;

  /** The default constructor creates a player.
   *	@param none
   */

  public Player(){
    m_player = 1;
    m_cards = new LinkedList<Card>();
  }

  /** Create a player with given player number and owned cards.
   *	@param player The player number
   *	@param cards A LinkedList of the owned cards
   */

  public Player(int player, LinkedList<Card> cards){
    m_player = player;
    m_cards = cards;
  }

  /** Get the owned cards of the player.
   *	@param none
   *  @return A LinkedList representing the owned cards
   */

  public LinkedList<Card> getCards(){
    return m_cards;
  }

  /** Get the card size of the player.
   *	@param none
   *  @return A integer representing the card size of the player
   */

  public int cardsize(){
    return m_cards.size();
  }

  /** Get a specific card's value with given card index.
   *	@param index The index of the card value to be gotten
   *  @return An integer representing the card value
   */

  public int cardvalue(int index){
    return m_cards.get(index).getValue();
  }

  /** Removes and returns the card at the front of the list.
   *	@param none
   *  @return An object representing the card removed from the front of the list
   */

  public Card flip(){
    return m_cards.remove(0);
  }


  /** Adds a card to the list of owned cards.
   *	@param c An Object representing the card to be collected.
   *  @return none
   */

  public void collect(Card c){
    m_cards.add(c);
  }

  /** Checks if a player wins the game.
   *	@param none
   *  @return true if a player wins the game and false otherwise
   */

  public static boolean hasWon(){
    if(Game.m_player1.cardsize()==52||Game.m_player2.cardsize()==52){
      return true;
    }
    else{
      return false;
    }
  }

  /** Handles the situation of war when breaking ties.
   *	@param none
   *  @return An integer representing the number of comparison in the war
   */

  public static int war(){
    // temp collects all the cards to be added to the winner in the end of the war.
    LinkedList<Card> temp = new LinkedList<Card>();
    // index1 and index2 indicates the indexes of the face-up cards in the war.
    // comp indicates the comparison in the war.
    int index1, index2, comp = 0;
    while(true){
      index1 = 4;
      index2 = 4;
      comp++;
      // if a player runs out of cards in a war, he may play the last card in his deck
      // as his face-up card.
      if(Game.m_player1.cardsize() < 5){
        index1 = Game.m_player1.cardsize()-1;
      }
      if(Game.m_player2.cardsize() < 5){
        index2 = Game.m_player2.cardsize()-1;
      }
      // get the value of the face-up cards
      int a = Game.m_player1.cardvalue(index1);
      int b = Game.m_player2.cardvalue(index2);
      // if there's another tie, add all cards in front of the face-up card to the temp
      // and let the war process repeated.
      if(a == b){
        if(index1 != 0){
          for(int i = 0; i < index1; i++){
            temp.add(Game.m_player1.flip());
          }
        }
        if(index2 != 0){
          for(int i = 0; i < index2; i++){
            temp.add(Game.m_player2.flip());
          }
        }
      }
      // otherwise the higher-valued card collects all of the cards on the table and ends the war.
      else{
        for(int i = 0; i <= index1; i++){
          temp.add(Game.m_player1.flip());
        }
        for(int i = 0; i <= index2; i++){
          temp.add(Game.m_player2.flip());
        }
        if(a > b){
          Game.m_player1.m_cards.addAll(temp);
        }
        else{
          Game.m_player2.m_cards.addAll(temp);
        }
        break;
      }
    }
    return comp;
  }
}
