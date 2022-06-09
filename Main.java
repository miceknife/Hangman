/*
Main - this is a runner class that runs the Game class

Author - Curtis Furukawa
*/

class Main {
  public static void main(String[] args) {
    GameHandler gh = new GameHandler();
    gh.renderLeaderBoard();
  }

/*  // Unit tests for Utils.java. Call this from main if you want to
  // see examples of the Utils methods
  public static void testUtils () {
    String s = Utils.inputStr ("What's your name? ");
    System.out.println ("Hi " + s);
    
    int n = Utils.inputNum ("What's your age? ");
    System.out.println ("You typed " + n);

    int r = Utils.randInt (1, 100);
    System.out.println ("A random number between 1-100 is " + r);

    String[] strs = {"chocolate", "vanilla", "strawberry"};
    s = Utils.randChoice(strs);
    System.out.println ("A random flavor is: " + s);
  }*/
}