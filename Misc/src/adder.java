
import java.util.*;

public class adder {
	public static void main(String [] args) {

		String str = "look at this value";
		double dub = 65.73225;
		int i = 0;
		char ch = 'c';
		
		
		System.out.println("Line 1");
		System.out.println("Line 2");
		System.out.println("Line 3");
		i = 3;
		System.out.println("Line 4");
		System.out.println("Line 5");
		System.out.println("Line 6");
		i = 5;

		
		int sum = 0, op1 = 0, op2 = 0;
		boolean op1t = false, op2t = false;
		String op1str, op2str;
		Scanner keybd = new Scanner(System.in);		

		
		do {
			if(op1t == false) {	
				try { 
					System.out.println("Please enter the first number:");
					op1str = keybd.nextLine();
					op1t = true;
					op1 = Integer.valueOf(op1str);
			}catch(Exception e) {
					System.out.println("First number was not valid (integers only)");
					op1t = false;
				}
			}

			if(op2t == false) {	
				try { 
					System.out.println("Please enter the second number:");
					op2str = keybd.nextLine();
					op2t = true;
					op2 = Integer.valueOf(op2str);
				}catch(Exception e) {
					System.out.println("Second number was not valid (integers only)");
					op2t = false;
				}
			}
		}while(!(op1t && op2t));
		
		keybd.close();
		sum = op1 + op2;
		System.out.println(op1 + " + " + op2 + " = " + sum);		

		System.out.println("Line 2");
		System.out.println("Line 3");
		i = 3;
		System.out.println("Line 4");
		System.out.println("Line 5");
		

		
	}	
}
