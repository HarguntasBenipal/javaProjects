/*
Name: Harguntas Singh Benipal
Date: October 13, 2022
Description: This program is a phonebook mini-application that does multiple tasks. It does 3 things: Ask the user to enter a number into the phonebook, call someone and exit. To being with, the program asks
the user how many numbers they want the phonebook to contain. Then it fills all those locations with "empty". The user then has to choose from the 3 options listed above. If they choose to enter a number, they will
be asked the location, name of the person and the number. If the location you enter is not within the given range of locations, the program will bring you back to the 3 options screen. If it is within the locations, the
name and number will be stored in a 2D array. If you choose to call, the program will first display all your names and the phone numbers of the locations. Then it will ask you who you would like to call. If the name 
does not exist, the program will bring you back to the 3 options screen. If it does exist, it will call the number. The exit option will exit the program. The user interface is a JOptionPane. 
*/

import javax.swing.JOptionPane; //Imports file that allows you to use JOptionPane

public class phoneBook //Name of the program
{
   
  public static void main(String[] args) //Main method
  {   

    JOptionPane.showMessageDialog(null, "\nHello, this is a phonebook program that stores and calls your numbers!");
    int numbers = Integer.parseInt(JOptionPane.showInputDialog("How many numbers do you want your phonebook to contain?")); //Asks user how many numbers 
    
    String [][] dial = new String [numbers][2]; //Makes the numbers the length of array. 2 columns (One for name, other for phone number)

    for(int row=0; row<dial.length; row++) //For loop that fills the 2D array with "empty"
    {
       for (int col=0; col<dial[row].length; col++)
       {
           dial[row][col]="Empty";
       }
    }
  

    do
    {  //Do while loop
    
     char whatOperation = askUser(); //Runs the askUser method and the value that is returned becomes whatOperation
     
     switch (whatOperation) //whatOperation is used in switch statement
     {
         case '1':
          enterNumber(dial); //Runs the enterNumber method (dial array passes parameters) 
          break;
         
         case '2':
          dialNumber(dial); //Runs the dialNumber method (dial array passes parameters) 
          break;
         
         case '3':
          JOptionPane.showMessageDialog(null, "\nThank you for using the program!");
          System.exit(0); //Exits the program if user chooses to
       
         default:
          JOptionPane.showMessageDialog(null,"\nYou did not select any of the options."); //If the user does not select any of the options
     }
    
    }while(true); //Loops forever so program keeps asking what to do. Can exit however using case 3.
    
  }//End of main method
  
  
  public static char askUser() //askUser method
  {
    String askUserOptions = JOptionPane.showInputDialog("\nWhat would you like to do:\n\n1. Enter a number\n2. Dial a number\n3. Exit");
    char askWhatToDo = askUserOptions.charAt(0);  //Takes the number that was typed and converts into char so it can be used in switch statement
    return askWhatToDo;  //Returns askWhatToDo to main
  }
  
 
  public static void enterNumber(String [][] dial) //enterNumber method
  {
    int location = Integer.parseInt(JOptionPane.showInputDialog("Which location do you want to store your number at? (1-"+dial.length+")")); //Asks user what location they want to store numer at
     
    if (location<1 || location>dial.length) //Checks if the inputted location is not within the range of number locations. If so, it outputs the statement.
    {
        JOptionPane.showMessageDialog(null, "You did not select within the range of number locations.");
    }
    
    else //If the inputted location is within the range. Executes the statements below.
    {
        String enterName = JOptionPane.showInputDialog("Enter the name of the person at location "+location); //Asks name of person
        Long phoneNumber = Long.parseLong(JOptionPane.showInputDialog("Enter the #"+(location)+" phone number (Ex: 123456789)")); //Asks phone number in long type
        String phoneNumberString = Long.toString(phoneNumber); //Converts the long to a string so it can be stored in the 2d array alongside the name
        dial [location-1][0]=enterName; //The first column is name of person. It is location-1 because for example, for the user it's 1-9 while in array it's 0-8
        dial [location-1][1] = phoneNumberString; //Second column is phone number
        JOptionPane.showMessageDialog(null, "Your phone numbers:\n"+java.util.Arrays.deepToString(dial)); //Outputs everything inside the array. All the names and phone numbers. 
    }
    
   }
  
  
  public static void dialNumber(String [][] dial) //dialNumber method
  {
    String dialName = JOptionPane.showInputDialog("Your phone numbers:\n"+java.util.Arrays.deepToString(dial)+"\n\nWho would you like to dial?"); //Shows the names and phone numbers. Asks user who they want to dial
  
    for (int i=0;i<dial.length;i++) //for loop that checks if the name inputted exists in the array
    {
      
        if (dialName.equals(dial [i][0])) //If it does exist, then it calls the person and phone number
        {
            JOptionPane.showMessageDialog(null, "Calling: "+dial[i][0]+"\nDialing number: "+dial[i][1]);
            return; //Returns to main method 
        }
        
    }
    
     JOptionPane.showMessageDialog(null, "This name is not stored in any location in the phonebook. There is also no number stored in that location."); //If the name does not exist, then the statement is outputted
  }
  
  
} //End of program
     
    
    
 
