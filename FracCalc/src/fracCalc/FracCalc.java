package fracCalc;
/*
 * @author: Aidan Lee
 * @version 1.9 1/27/2019
 * This is the client code that takes in input and creates instances of fraction
 * class to calculate fractions(+,-,*,/) and returns the result.
 */
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
       String operator = splitBySpace[1];
       
       Fraction operand1 = new Fraction(splitBySpace[0]);
       Fraction operand2 = new Fraction(splitBySpace[2]);
       
       Fraction answer = operand1.doMath(operand2, operator);
       return answer.simplifyToAString();
    }


    
}
