package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
    	Scanner userInput = new Scanner(System.in); //New Scanner declared
		String input = userInput.nextLine(); //Get input
		
		while(!input.toLowerCase().equals("quit")) { //while quit is not typed, loop gives input to produce Answer
			System.out.println(produceAnswer(input)); //produce Answer + prints out result 
			input = userInput.nextLine();
    	}
    	userInput.close(); //closes Scanner to conserve memory when user is finished

    }
    public static String produceAnswer(String input)
    { 
       String[] splitBySpace = input.split(" ");
       String operand = splitBySpace[1];
       
       Fraction operand1 = new Fraction(splitBySpace[0]);
       Fraction operand2 = new Fraction(splitBySpace[2]);
       
        
        return "";
    }


    
}
