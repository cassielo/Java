/**Simulation.java
 * A class that stores information about a simulation.
 * @author Cassie Lo
 * @author plo@chapman.edu
 */

/** The Simulation class stores the number of games to simulate, and the statistics of the
 *  simulation and plays the specified number of games, computes the aggregate statistics
 *  from all games and prints statistics to the screen in a nicely-formatted manner.
 */

public class Simulation{
  private int m_games;
  private double aveb = 0;
  private double avew = 0;
  private double avedw = 0;
  private int maxb = 0;
  private int minb = 1000;
  private int maxw = 0;
  private int minw = 1000;

  /** The default constructor of a one game simulation.
   *	@param none
   */

  public Simulation(){
    m_games = 1;
  }

  /** Create a simulation with given nunber of games.
   *	@param n An integer representing the number of games to simulate
   */

  public Simulation(int n){
    m_games = n;
  }

  /** Plays the specified number of games.
   *	@param none
   *  @return none
   */

  public void simulate(){
    for(int i = 0; i < m_games; i++){
      Game g = new Game();
      g.play();
      aveb += g.getBattle();
      avew += g.getWar();
      avedw += g.getDwar();
      if(g.getBattle() > maxb){
        maxb = g.getBattle();
      }
      if(g.getBattle() < minb){
        minb = g.getBattle();
      }
      if(g.getWar() > maxw){
        maxw = g.getWar();
      }
      if(g.getWar() < minw){
        minw = g.getWar();
      }
    }
  }

  /** Computes the aggregate statistics from all games.
   *	@param none
   *  @return none
   */

  public void calculate(){
    aveb = aveb/m_games;
    avew = avew/m_games;
    avedw = avedw/m_games;
  }

  /** Prints the statistics to the screen in a nicely-formatted manner
   *	@param none
   *  @return none
   */

  public void report(){
    System.out.println("Average number of battles per game: " + aveb);
    System.out.println("Average number of wars per game: " + avew);
    System.out.println("Average number of double wars per game: " + avedw);
    System.out.println("Max number of battles in a game: " + maxb);
    System.out.println("Min number of battles in a game: " + minb);
    System.out.println("Max number of wars in a game: " + maxw);
    System.out.println("Min number of wars in a game: " + minw);
  }

  /** The main method. Runs the War program.
   *	@param args The commend line arguments
   *  @return none
   */

  public static void main(String[] args){
    Simulation s = new Simulation(Integer.parseInt(args[0]));
    s.simulate();
    s.calculate();
    s.report();
  }
}
