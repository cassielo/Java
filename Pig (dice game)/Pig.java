import java.util.Scanner;
import java.util.Random;

/**Pig.java
 * A pig game program.
 * @author Cassie Lo
 * @author plo@chapman.edu
 */

/** The Pig class allows user to play pig game with the computer. In each user's
 * turn, the user decides to input "r" for roll again or "h" for hold. The first
 * player to reach 100 or more points wins.
 */

public class Pig{
  public static void main(String[] arg){
    //Set up the total number of the user and the computer.
    int user = 0, computer = 0;
    // "u" is the user's turn and "c" is the computer's turn.
    String turn = "u";
    while(user < 100 && computer < 100){
      int score, userturn, compturn;
      //User's turn
      while(turn.equals("u")){
        userturn=0;
        System.out.println("It's your turn!-------------------\n");
        System.out.println("Your score: "+user);
        System.out.println("The computer's score: "+computer+"\n");
        while(true){
          //Randomly roll a six-sided die
          Random rand = new Random();
          score = rand.nextInt(6)+1;
          System.out.println("You roll: "+score);
          if(score==1){
            turn = "c";
            break;
          }
          userturn += score;
          System.out.println("Roll again or hold? (r/h)");
          Scanner Kb = new Scanner(System.in);
          String rh = Kb.nextLine();
          if(rh.equals("h")){
            user += userturn;
            turn = "c";
            break;
          }
        }
      }
      //The computer's turn
      while(turn.equals("c")){
        compturn=0;
        System.out.println("It's the computer's turn!----------\n");
        while(true){
          //Randomly roll a six-sided die
          Random rand = new Random();
          score = rand.nextInt(6)+1;
          if(score==1){
            turn = "u";
            break;
          }
          compturn += score;
          //The computer will hold once it earns 20 or more points
          if(compturn>=20){
            computer += compturn;
            System.out.println("The computer holds.\n");
            turn = "u";
            break;
          }
        }
      }
      // The first to reach 100 or more points win, and the game stops.
      if(user >= 100){
        System.out.println("You Win!");
      }
      if(computer >= 100){
        System.out.println("The computer wins!");
      }
    }
  }
}
