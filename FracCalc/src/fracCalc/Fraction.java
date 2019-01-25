package fracCalc;
import java.util.*;

public class Fraction {
	
	private int whole, num, denom, sign;
	private String fracStr;
	
	public Fraction(String operand) {
		this.fracStr = operand;
		int[] returnIntFrac = {0,0,1};
		if(operand.indexOf("_") != -1){
    		String[] splitByUnderscore = operand.split("_");
    		returnIntFrac[0] = Integer.parseInt(splitByUnderscore[0]);
    		this.whole = Integer.parseInt(splitByUnderscore[1]);
    	}
    	if(operand.indexOf("/") != -1){
    		String[] splitBySlash = operand.split("/");
    		this.num = Integer.parseInt(splitBySlash[0]);
    		this.denom = Integer.parseInt(splitBySlash[1]);
    	} else {
    		this.whole = Integer.parseInt(operand);		
    	}	
    	convertToImproperFrac();
    	setSign();
	}
	
	public Fraction() {
		this.whole = 0; 
		this.num = 0;
		this.denom = 1;
		sign = 1;
	}
	
	public int getWhole() {
		return this.whole;
	}
	
	public int getNumerator() {
		return this.num;
	}
	
	public int getDenom() {
		return this.denom;
	}
	
	public int getSign() {
		return this.sign;
	}
	
	private void setSign() {
		if(this.whole < 0) {
			this.sign = -1;
		} else {
			this.sign = 1;
		}	
	}
	
	public void convertToImproperFrac() {
		this.num = this.whole * absoluteValue(this.denom * this.num);
		this.whole = 0;
	}
	
	public Fraction doMath(Fraction op1, Fraction op2, String operator) {
		Fraction returnDoMath = new Fraction();
		int denomFactor = factorOfFraction(op1.denom, op2.denom);
		op1.num = op1.num * (denomFactor/op1.denom);
		op2.num = op2.num * (denomFactor/op2.denom);
		if(operator.equals("+")) {
			returnDoMath.num = op1.num + op2.num;
		} else if(operator.equals("-")) {
			returnDoMath.num = op1.num - op2.num;
		} else if(operator.equals("*")) {
			returnDoMath.num = op1.num * op2.num;
			returnDoMath.denom = op2.denom * op2.denom;
		} else if(operator.equals("/")) {
			returnDoMath.num = op1.num * op2.denom;
			returnDoMath.denom = op1.denom * op2.num;
		} else {
			throw new IllegalArgumentException("Illegal Operator. Try Again");
		}
		return returnDoMath;

	}
	
	public void convertToMixedNum() {
		
	}
	
	public static int factorOfFraction(int input1, int input2) { //Multiplies denominators together
	    return input1 * input2;
	}
	
	public static int absoluteValue(int input) {//Calculate absolute value
    	if(input < 0) {
    		return input * -1;
    	} else {
    		return input;
    	}
    }
    public static int findGCF(int input1, int input2) {//Calculates GCF for inputted values - from calculate library
    		input1 = absoluteValue(input1);
    		input2 = absoluteValue(input2);
    		int answer = 1;	//declares inital value for  as 1 b/c 1 is always a gcf
    		for(int i =1; i<=input1; i++) {//test for gcf for integers up to value of input1
    			if(isDivisibleBy(input2, i) && isDivisibleBy(input1, i)) {//returns i into answer the highest value both inputs are divisible by
    					answer = i;
    			}
    		}
    		return answer;
    }
    
    public static boolean isDivisibleBy(int dividend, int divisor) {//checks if two values are divisible, required by method findGCF
		if(divisor == 0) {
			throw new IllegalArgumentException("Cannot divide by zero!");
		}
		if(dividend % divisor == 0) { //is Divisible
			return true;
		} else {
			return false; //is not Divisible
		}
	}

}
