/*
Game class - hangman

In this game, one person guesses a random word letter by letter

Author - Curtis Furukawa

Classes needed: Round and GameHandler (Round is the game, GameHandler holds runs of the game into a hashmap that prints at the end)

Variables for round: int numRightGuess, int wrongGuesses, String word, String displayedWord, String guess, ArrayList<String> wrongGuess = new ArrayList<String>(), String[] possibleWords = {"book", "join", "desk", "chair"}

Methods used: play and constructor, and a renderLeaderboard for GameHandler

Change history:
5/12: Created, 5/12 finished
*/

import java.util.ArrayList;

public class Round {
  // Private instance variables to store the guesses and word
  private int numRightGuess;
  private int wrongGuesses;
  private String word;
  private String displayedWord;
  private String guess;
  private ArrayList<String> wrongGuess = new ArrayList<String>();
  private String[] possibleWords = {"book", "join", "desk", "chair"};

  // Constructor, to initialize the instance variable
  public Round () {
    word = Utils.randChoice(possibleWords);
    displayedWord = "";
    for(int i = 0; i<word.length(); i++){
      displayedWord += "*";
     }  
  }

  // Method to let a user play hangman
  public int play () {
    System.out.println ("\nWelcome to Hangman.\nEach guess must be one letter.\nYour score will be calculated by taking the number of correct guesses subtracted by the number of wrong guesses");
    int flag = 0;
    ArrayList<Integer> index = new ArrayList<Integer>();
    guess = Utils.inputStr ("Enter your first guess: ");

  // Allows program to run until either the user quits
   while(flag == 0){
    while(guess.length()>1){
      guess = Utils.inputStr ("One letter at a time please: ");
    }
    if(displayedWord.indexOf(guess) == -1){
      index.clear();
      for(int i = 0; i<word.length(); i++){
        if(word.substring(i, i+1).equals(guess)){
          index.add(i);
          numRightGuess++;
          }
      }
    }
     
    if(index.size() != 0){
      for(int k = 0; k<index.size(); k++){
        displayedWord = displayedWord.substring(0, index.get(k)) + word.substring(index.get(k), index.get(k)+1) + displayedWord.substring(index.get(k)+1);
      }
    }
    else{
      wrongGuesses++;
      wrongGuess.add(guess);
    }
    
    switch(wrongGuesses){
      case 1:
        System.out.println("\nThey've got his head\nWrong letters: " + wrongGuess + "\nCurrent guess: " + displayedWord+ "\n");
        break;
      case 2:
        System.out.println("\nThey've got his body too\nWrong letters: " + wrongGuess + "\nCurrent guess: " + displayedWord+ "\n");
        break;
      case 3:
        System.out.println("\nThey've got his right arm!\nWrong letters " + wrongGuess + "\nCurrent guess: " + displayedWord+ "\n");
        break;
      case 4:
         System.out.println("\nThey've got his left arm!\nWrong letters " + wrongGuess + "\nCurrent guess: " + displayedWord+ "\n");
         break;
       case 5:
         System.out.println("\nThey've got his right leg!\nWrong letters " + wrongGuess + "\nCurrent guess: " + displayedWord+ "\n");
         break;
       case 6:
          System.out.println("\nThey've got his left leg!\nWrong letters " + wrongGuess + "\nCurrent guess: " + displayedWord+ "\n");
          break;
      case 7:
         System.out.println("\nHe is dead.\nWrong letters " + wrongGuess + "\nYou Lose! The word was: " + word + "\nYour score was "+ (numRightGuess - wrongGuesses));
         flag = 1;
         break;
       default:
         System.out.println("\nYour man is doing just fine.\nCurrent guess: " + displayedWord+ "\n");
     }
      if(displayedWord.equals(word)){
        flag = 2;
        System.out.println("\nCongrats! The word was "+ word+ ". You saved the Man!\nYour score was "+ (numRightGuess - wrongGuesses));
        break;
       }
     else if(wrongGuesses == 7){
       break;
     }
     guess = Utils.inputStr ("Enter your next guess: ");
     for(String g: wrongGuess){
       if(g.equals(guess)){
         guess = Utils.inputStr("You've already guessed this letter. Please guess another: ");
       }
     }
    }
    return numRightGuess - wrongGuesses;
  }
}
