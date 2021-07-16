// Ben Rust 
// mthree's Java Basics: Dog Genetics project

package com.mthree.javabasics;
import java.util.Scanner;

public class HealthyHearts {
	public static void main(String [] args) {
		Scanner keybd = new Scanner(System.in);
		int age = 0;
		String input; 
		System.out.print("What is your age?");
		input =  keybd.nextLine();
		// Can put error checking here if need be 
		age = Integer.valueOf(input);
		System.out.println("Your maximum heart rate should be " + (220-age) + " beats per minute");
		System.out.println("Your target HR Zone is " + (int)((220-age)*.5) + " - " + (int)((220-age)*.85) + " beats per minute");		
		keybd.close();
	}
	
	
}
