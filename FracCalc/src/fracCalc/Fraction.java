package fracCalc;
/*
 * @author: Aidan Lee
 * @version 1.9 1/27/2019
 * This is the object class of FracCalc, which contains constructor to 
 * create a Fraction Object, methods to get, set, and calculate fractions
 * and returns it to the client Code. 
 */
//CONSTRUCTOR: From old FracCalc, uses splitting to set instance variables for object
public class Fraction {
	private int whole, num, denom;	
	public Fraction(String operand) {
		if(operand.indexOf("_") != -1){
    		String[] splitByUnderscore = operand.split("_");
    		whole = Integer.parseInt(splitByUnderscore[0]);
    		operand = splitByUnderscore[1];
    	}
    	if(operand.indexOf("/") != -1){
    		String[] splitBySlash = operand.split("/");
    		num = Integer.parseInt(splitBySlash[0]);
    		denom = Integer.parseInt(splitBySlash[1]);
    	} else {
    		whole = Integer.parseInt(operand);		
    		denom =1;//compensates for lack of (0,0,1} return array
    	}
    	convertToImproperFrac();
	}
	//ALT. CONSTRUCTOR: Initializes a Fraction Object without parameters 
	public Fraction() {
		this.whole = 0; 
		this.num = 0;
		this.denom = 1;
	}
	//Gets Instance Whole Number
	public int getWhole() {
		return this.whole;
	}
	//Gets Instance Numerator
	public int getNumr() {
		return this.num;
	}
	//Gets Instance Denominator
	public int getDenom() {
		return this.denom;
	}
	//Sets Parameters to instance variables of Fraction Object
	public void setFraction(int w, int n, int d) {
		this.whole =w;
		this.num = n;
		this.denom = d;
	}
	//Converts instance variables to improper fraction
	public void convertToImproperFrac() {
		if(whole >= 0) {
	    	num = whole*denom+num;
	    }else {
	    	num = whole*denom-num;
	    }
	    whole = 0;//Improper Fraction has no Whole Number
	}
	//Calculates sum, product, quotient, and difference of the two Frac Objects and returns
	//A Fraction answer
	//Note to self: For some reason <FractionOBJ.<whole/num/denom> works without get()??
	public Fraction doMath( Fraction op2, String operator) {
		Fraction returnDoMath = new Fraction();
		int denomFactor = factorOfFraction(denom, op2.getDenom());
		if(operator.equals("+")) {
			num = num * (denomFactor/denom) + op2.num * (denomFactor/op2.getDenom());
			denom = denomFactor;
		} else if(operator.equals("-")) {
			num = num * (denomFactor/denom) - op2.getNumr() * (denomFactor/op2.getDenom());
			denom = denomFactor;
		} else if(operator.equals("*")) {
			num = num * op2.getNumr();
			denom = denom * op2.getDenom();
		} else if(operator.equals("/")) {
			num = num * op2.getDenom();
			denom = denom * op2.getNumr();
		}
		returnDoMath.setFraction(whole, num, denom);
		return returnDoMath;		
	}
	//Reduces improper, converts to mixed number, and returns answer as String
	public String simplifyToAString() {
		if(num == 0)  return "" + 0;
		int gcf = findGCF(num, denom);
		num /= gcf;
		denom /= gcf;
		if(denom < 0) {
			denom *=-1;
			num *=-1;
		}
		if(absoluteValue(num ) > denom && denom !=1) {
			int kWhole = num / denom;
			int kNum = absoluteValue(num % denom);
			return kWhole + "_" + kNum + "/" + denom;
		} else if(denom ==1){
			return "" + num;
		} else {
			return num + "/" + denom;
		}
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