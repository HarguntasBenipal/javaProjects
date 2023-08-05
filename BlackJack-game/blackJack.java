/*
Name: Harguntas Singh Benipal
Date: December 12, 2021
Description: Blackjack program that gives 2 random cards to the dealer and user and compares the scores to see who is higher. The user has the option to draw more cards however, if the card total goes over 21, they lose. The user also can place bets. 
*/

import java.util.*; //Imports the a file that allows user interaction

public class blackJack //Name of the program
{
  static Scanner console=new Scanner(System.in); //Creates a new scanner console so it can read console input 
  public static void main (String args[]) //Main Method
  {
    String playAgain=""; //Created a string outside do while loop 
  

      
    do { //Do while loop that runs the code inside at least once and then again if the user wants
      
      //Introduction to program for user 
      System.out.print("\nHello, User!\nPlease input your name:"); 
      String name=console.nextLine();
    
          //Created starting money for user and dealer
      int userMoney = 500;
      int dealerMoney = 500;
    
      //User and Dealer get 2 random cards between 1 and 10. Then 2 cards get added for sum of user and dealer cards.
      int userCard1 = (int) Math.floor(Math.random()*10)+1;
      int userCard2 = (int) Math.floor(Math.random()*10)+1;
    
      int dealerCard1 = (int) Math.floor(Math.random()*10)+1;
      int dealerCard2 = (int) Math.floor(Math.random()*10)+1;
    
      int sumUser= userCard1+userCard2;
      int sumDealer= dealerCard1+dealerCard2;
      
      //Outputs users 2 random cards, their sum and the money amount. Also asks user how much money they want to bet.
      System.out.println("\nGreetings, "+name+"!\nThese are your 2 random drawn cards: "+userCard1+" , "+userCard2+"\nYour total is: "+sumUser+"\n\nMoney Amount: $"+userMoney);
    
      System.out.print("\nHow much money would you like to bet?");
      int moneyAmount=console.nextInt();
      console.nextLine();
    
      //Calls extraCards method. Also, creates a new int for the value that is returned from the method.
      int sumUser3=extraCards(userCard1, userCard2, sumUser);
     
      //Calls compare method.
      compare(sumUser3, sumDealer);
    
      //Calls betMoney method.
      betMoney(sumUser3, sumDealer, userMoney, dealerMoney, moneyAmount);
  
      //Asks if user wants to play again.
      System.out.println("\nWould you like to play again?(Yes or No)");
      playAgain=console.nextLine();   
  }
    while (playAgain.equalsIgnoreCase("yes")); //While condition that runs the code again if answer is yes.
 
    System.out.println("\nThank you for playing Blackjack!");  //Outputs message if user doesn't type yes.
  }
  
  //extraCards method that asks user if they want to draw more cards.
  public static int extraCards(int userCard1, int userCard2, int sumUser)
  {
   System.out.print("\nWould you like to draw another card? (Hit or Stand)");
   String extraCard=console.nextLine();
  
     while (extraCard.equalsIgnoreCase("hit")) //While statement that runs the code inside if user keeps on saying hit.
     {
       int userCardExtra = (int) Math.floor(Math.random()*10)+1; //Draws random card
       sumUser = sumUser+userCardExtra; //Adds random card to sum

       //if else statements. If sum is over 21, you automatically lose. Otherwise, keeps asking.
       if (sumUser>21)
       {
        System.out.println("\nSorry, You lost.");
        break;
       }
       
      else 
      {
       System.out.println("This is your random drawn card: "+userCardExtra+"\nYour total is now: "+sumUser);
       System.out.print("\nWould you like to draw another card? (Hit or Stand)");
       extraCard=console.nextLine();
       }
      
    }
   return sumUser; //returns the final sum back to main
  }
  
  //compare method to compare users and dealers score
  public static void compare(int sumUser3, int sumDealer)
  {
  
    //if else statements that compare user and dealer and output if you won, lost or tie.
    if (sumUser3<=21)
    {
      if (sumUser3>sumDealer)
      {
        System.out.println("\nCongrats, You won!\nYou had a score of "+sumUser3+"\nThe dealer had a score of "+sumDealer);
      }
      
      else if (sumUser3<sumDealer)
      {
         System.out.println("\nSadly, You lost.\nYou had a score of "+sumUser3+"\nThe dealer had a score of "+sumDealer);
      }
      
      else 
      {
        System.out.println("\nThe game was a tie.\nYou had a score of "+sumUser3+"\nThe dealer had a score of "+sumDealer);
      }
    }
    
    else 
    {
      System.out.println("You had a score of "+sumUser3+" which is greater than 21.");
    }
    
  }
  
  //betMoney method that compares user and dealer scores and gives money amount accordingly.
  public static void betMoney(int sumUser3, int sumDealer, int userMoney, int dealerMoney, int moneyAmount)
  {
   
    //if else statements that add or subtract the money amount from the userMoney.
     if (sumUser3>21||sumUser3<sumDealer) 
     {
       dealerMoney = dealerMoney+moneyAmount;
       userMoney = userMoney-moneyAmount;
       System.out.println("\nYour money amount is now: $"+userMoney);
     }
    
     else if (sumUser3==sumDealer)
    {
      userMoney = userMoney;
      System.out.println("\nYour money amount is still: $"+userMoney);
    }
     
     else 
    {
       userMoney = userMoney+moneyAmount;
       dealerMoney = dealerMoney-moneyAmount;
       System.out.println("\nYour money amount is now: $"+userMoney);
    }
    
    
    }
 
} //end of code
