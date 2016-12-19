package cointossgame;
import java.util.Scanner;

/** Name: Sharon
  * Email: sharon.lee.fumi@hotmail.com
  * Assignment: GamePlayer class of Assignment 3
  * 
  * This program is to keep playing Coin Toss Game.
  * The user enters choose heads, tails or quit. 
  * If you win, you add $100 to your total 
  * and if you lose, you lose $50 from the total.
  */

public class GamePlayer
{
  public static void main(String[] args)
  {
    int guessNum = 0;
    double total = 0.0;  //total amount
    int round = 0;  //count rounds
    Scanner input = new Scanner(System.in);
    //create a new Coin named sharon
    Coin sharon = new Coin();
    
    //while loop is used to keep playing
    //if user enter quit(-1) then the game will be end
    while (guessNum != -1)
    {    
      //Prtint a message to prompt the user to choose heads, tails or quit
      System.out.println("To play, first enter your guess as heads, tails or quit");     
      String guess = input.nextLine();
      guessNum = getUserInput(guess);
      
      if (guessNum == -1)
      {
        break;
      }
      else
      {
        //Pass the guessNum in to coin class
        sharon.setSelection(guessNum);
        
        //get the result of returing from Coin class
        double prizeValue = sharon.getPrizeValue();
        //format the prizeValue to two decimal places by using String.format()
        String formatedPrize = String.format("%.2f",prizeValue);
        
        //print message to tell user the result
        if (prizeValue > 0)
        {
          System.out.println("You won! Your prize amount is $" + formatedPrize);
        }
        else
        {
          System.out.println("You lost...please play again");
        }
        
        //keep track of both the user’s running total and the number of rounds
        total = total + prizeValue;
        String formatedTotal = String.format("%.2f",total);
        round++;
        System.out.println("Your running total after round " + round + " is $" + formatedTotal);
      }
    }
    //user enter quit then print message to tell user the final result of the game 
    String message = quit(round,total);
    System.out.println(message);
  } 
  
  //A method getUserInput: take in either the String heads, tails, or quit 
  //and return 0 for heads, 1 for tails and -1 for quit 
  public static int getUserInput(String guess)
  {
    int num = 0;
    switch(guess)
    {
      case "heads": num = 0;
      break;
      case "tails": num = 1;
      break;
      case "quit": num = -1;
      break;
      default: System.out.println("Please input valid choice");     
    }
    return num;
  }
  
  //A method quit(): when user enter quit, print total winnings and total number of rounds played
  public static String quit(int round, double total)
  {
    String message;
    if (total >= 0)
    {
      String formatedTotal = String.format("%.2f",total);
      message = "Thank you for playing " + round + " round(s). Your total was: $" +  formatedTotal;
    }
    else
    {
      String formatedTotal = String.format("%.2f",-total);
      message = "Thank you for playing " + round + " round(s). You owe the game: $" +  formatedTotal;
    }
    return message;
  }
}