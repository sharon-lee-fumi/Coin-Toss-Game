package cointossgame;

/** Name: Sharon
  * Email: sharon.lee.fumi@hotmail.com
  * Assignment: Coin class of Assignment 3
  * 
  * This class is to model Coin Objects.
  * The coins will be used in a coin toss game. 
  * If user wins, it returns the double amount ($100)of the bet amount($50).
  * If user loses, it returns -$50. 
  * 
  */

public class Coin
{
  //fields: betValue is bet amount of user;selection is the choice of user (head/tail)
  private double betValue = 50.0;
  private int selection = 0;

  //default constructor
  public Coin()
  {
  }
  
  //mutator: passes value from GamePlayer
  public void setSelection(int guessNum)
  {
    selection = guessNum;
  }
  
  //accessor
  public int getSlection()
  {
    return selection;
  }

  //A method flip: tosses the coin and returns either a 0 for heads or a 1 for tails 
  public int flip()
  {
    //Math.random() method returns a random floating point number between 0.0 and 1.0
    double number = Math.random();
    if (number > 0.5)
    {
      return 1; //tail
    }
    else
    {
      return 0; //head
    } 
  }

  //A method getPrizeValue:returns two times the initial bet value which is $100 for winner
  //or get result from method getLoss with losing $50 for looser 
  public double getPrizeValue()
  {
    double prizeValue=0.0;    
    //result stores the returned value of flip method
    int result = flip();
    
    //compare the flip result with user's choice and get the prize value
    if(result == selection)
    {
      prizeValue = 2 * betValue;  //win
    }
    else
    {
      prizeValue = getLoss();  //loss
    }
    return prizeValue;
  }
  
  //A method getLoss:lose $50 for looser and return it to method getPrizeValue
  public double getLoss()
  {
    double prizeValue= - betValue;
    return prizeValue;
  }
}