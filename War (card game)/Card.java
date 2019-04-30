/**Card.java
 * A class that stores information about a card.
 * @author Cassie Lo
 * @author plo@chapman.edu
 */

/** The Card class stores the suit of a card and the value in both integer and
 * string form, and provides functions to convert the value from integer to
 * string.
 */

public class Card{
  private int m_value;
  private String m_suit;
  private String m_strvalue;

  /** The default constructor creates an empty card.
   *	@param none
   */

  public Card(){
    m_value = 0;
    m_suit = "";
    m_strvalue = "";
  }

  /** Create a card with given value and suit.
   *	@param value A integer representing the card value
   *	@param suit A String representing the card suit
   */

  public Card(int value, String suit){
    m_value = value;
    m_suit = suit;
    m_strvalue = ValuetoStr();
  }

  /** Get the card value.
   *	@param none
   *  @return An integer representing the value of the card
   */

  public int getValue(){
    return m_value;
  }

  /** Get the card suit.
   *	@param none
   *  @return A string representing the suit of the card
   */

  public String getSuit(){
    return m_suit;
  }

  /** Convert the integer card value to a string value.
   *	@param none
   *  @return A string representing the value of the card
   */

  public String ValuetoStr(){
    if(m_value <= 10){
      return Integer.toString(m_value);
    }
    else if(m_value == 11){
      return "J";
    }
    else if(m_value == 12){
      return "Q";
    }
    else if(m_value == 13){
      return "K";
    }
    else{
      return "A";
    }
  }

  /** Returns a pretty-printed string representation of the card.
   *	@param none
   *	@return A string representation of the Card object.
   */

  public String toString(){
    return (m_suit + m_strvalue + "\n");
  }
}
