// Ben Rust 
// Classes and Objects simple calculator project 

import java.util.Scanner;

public class App {
	public static void main(String [] args) {

		int [] arr;
		Scanner keybd = new Scanner(System.in);

		while(true) {
			displayMenu();
			arr = getChoices(keybd);
			if(arr[1] == 5) {
				break;
			}	
			SimpleCalculator calc = new SimpleCalculator(arr);
			calc.performOp();
		}
		keybd.close();
		return;
	}

	public static void displayMenu() {
		
		
	}

	public static int [] getChoices(Scanner keybd) {
		int [] arr = new int[3];
		System.out.println("Please select the action you want to perform: ");
		System.out.println("1 - Addition; 2 - Subtraction; 3 - Multiplication; 4 - Division; 5 - Quit");
		int choice = Integer.valueOf(keybd.nextLine());
		if(choice == 5) {
			System.out.println("Goodbye!");
			arr[1] = 5;
			return arr;
		}
		arr[1] = choice;
		System.out.println("Please enter the two operands (numbers) you want to use in the order you want to use them");

		// Should these handle doubles as well as ints? 
		arr[0] = keybd.nextInt();
		arr[2] = keybd.nextInt();
		keybd.nextLine();
		return arr;
	}
	
	
	
}

class SimpleCalculator{
	int firstOp = 0, action = 0, secondOp = 0, result = 0;
	String actionStr;
	
	
	SimpleCalculator(int [] arr){
		firstOp = arr[0];
		action = arr[1];
		secondOp = arr[2];	
	}

	public void performOp() {
		switch(this.action) {
		case 1:
			result = firstOp + secondOp;
			actionStr = "+";
			break;
			
		case 2:
			result = firstOp - secondOp;			
			actionStr = "-";
			break;
			
		case 3:
			result = firstOp * secondOp;			
			actionStr = "*";
			break;
			
		case 4: 
			result = firstOp / secondOp;			
			actionStr = "/";
			break;				
		}
		System.out.println(firstOp + " " + actionStr + " " + secondOp + " = " + result + "\n");
	}
	
}


