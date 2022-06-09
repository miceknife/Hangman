/*
Game class - hangman

In this game, one person guesses a random word letter by letter

Author - Curtis Furukawa

Change history:
5/12: Created
*/

import java.util.HashMap;


public class GameHandler {
  // Private instance variables to store the facts and score
  private HashMap<String, Integer> players = new HashMap<String, Integer>();
  

  // Constructor, to initialize the instance variable
  public GameHandler () {
    int roundFlag = 0;
    while(roundFlag == 0){
      Round g = new Round();
      String name = Utils.inputStr ("What's your name? ");
      players.put(name, g.play());
      
      roundFlag = Utils.inputNum("Type \"0\" to play again \nType anything else to quit: ");
      //System.out.println("inside");
    }
    //System.out.println("outside");
  }

  public void renderLeaderBoard() {
    for(String n: players.keySet()) {
      String key = n.toString();
      String value = players.get(n).toString();
      System.out.println(key + " " + value);
    }
  }
}
