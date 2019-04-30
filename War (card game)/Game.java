import java.util.LinkedList;

/**Game.java
 * A class that stores information of a game.
 * @author Cassie Lo
 * @author plo@chapman.edu
 */

/** The Game class stores two players, the number of battles, wars and double wars
 * in the game, and provides a function to play a game.
 */

public class Game{
  public static Player m_player1;
  public static Player m_player2;
  private int m_battle;
  private int m_war;
  private int m_dwar;

  /** The default constructor creates a game.
   *	@param none
   */

  public Game(){
    // Create a new deck of cards and randomly split the cards between two players.
    Deck d1 = new Deck();
    LinkedList<Card> d2 = new LinkedList<Card>();
    for(int i = 0; i <26; i++){
      d2.add(d1.deal());
    }
    m_player1 = new Player(1, d1.getDeck());
    m_player2 = new Player(2, d2);
    m_battle = 0;
    m_war = 0;
    m_dwar = 0;
  }

  /** Get the number of battles in the game.
   *	@param none
   *  @return An integer representing the number of battles in the game.
   */

  public int getBattle(){
    return m_battle;
  }

  /** Get the number of wars in the game.
   *	@param none
   *  @return An integer representing the number of wars in the game.
   */

   public int getWar(){
     return m_war;
   }

  /** Get the number of double wars in the game.
   *	@param none
   *  @return An integer representing the number of double wars in the game.
   */

  public int getDwar(){
    return m_dwar;
  }

  /** Play a game.
   *	@param none
   *  @return none
   */

  public void play(){
    while(!Player.hasWon()){
      // The player with the higher-valued card takes both cards.
      if(m_player1.cardvalue(0) > m_player2.cardvalue(0)){
        m_player1.collect(m_player1.flip());
        m_player1.collect(m_player2.flip());
        m_battle++;
      }
      else if(m_player1.cardvalue(0) < m_player2.cardvalue(0)){
        m_player2.collect(m_player2.flip());
        m_player2.collect(m_player1.flip());
        m_battle++;
      }
      // If the values are equal, starts a war.
      else{
        if(Player.war() == 1){
          m_war++;
        }
        else{
          m_dwar++;
        }
      }
    }
  }
}
