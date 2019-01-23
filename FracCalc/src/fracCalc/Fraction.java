package fracCalc;
import java.util.*;

public class Fraction {
	
	private int whole;
	private int num;
	private int denom;
	
	public Fraction(String operand) {
		
		if(operand.indexOf("_") != -1){
    		String[] splitByUnderscore = operand.split("_");
    		whole = Integer.parseInt(splitByUnderscore[0]);
    	}
    	if(operand.indexOf("/") != -1){
    		String[] splitBySlash = operand.split("/");
    		num = Integer.parseInt(splitBySlash[0]);
    		denom = Integer.parseInt(splitBySlash[1]);
    	} else {
    		whole = Integer.parseInt(operand);
    	}
		
	}
	
	public Fraction() {
		whole = 0; 
		num = 0;
		denom = 0;
	}
	
	

}
