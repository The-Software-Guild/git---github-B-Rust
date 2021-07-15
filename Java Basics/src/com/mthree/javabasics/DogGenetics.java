// Ben Rust 
// mthree's Java Basics: Dog Genetics project

package com.mthree.javabasics;
import java.lang.Math;
import java.util.Scanner;

public class DogGenetics {
	public static void main(String [] args) {

		Scanner keybd = new Scanner(System.in);
		System.out.println("What is your dog's name?");
		String name = keybd.nextLine();
		System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.\n");
		System.out.println(name + " is: \n");
		printDog();
		System.out.print("\nWow, that's quite the dog!");
		keybd.close();
	}

	public static void printDog() {
		int undistributed = 95;
		int result = 0;
		String [] breeds = {"St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};
		for(int i = 0; i < 5; i++) {
			result = getPercent(undistributed);
			if(i == 4) {
				result = undistributed;
			}			
			System.out.println((result + 1) + "% " + breeds[i]);
			undistributed -= result; 
		}	
	}
	
	public static int getPercent(int undistributed) {
		if(undistributed == 0) {
			return 0;
		}
		return (int)(Math.random() * 1000) % undistributed + 1; 		
	}
	
}
