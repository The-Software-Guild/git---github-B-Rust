// Ben Rust's Rock Paper Scissors 
// Made some modifications from the actual prompt
	// can change back to the basic prompt

package com.mthree.javabasics;
import java.util.Scanner;
import java.lang.Math;
// This is going to run a loop asking the user to play 
// Rock, Paper, Scissors until they choose to quit 
// Each game will take in their input, and randomly generate a 
// choice, and then will output the winner. 
public class RockPaperScissors {
	
	public static void main(String [] args) {
		Scanner keybd = new Scanner(System.in);
		boolean keepPlaying = true; 
				
		while(keepPlaying) {
			int userCh = getUserChoice(keybd);
			int compCh = getCompChoice();

			if(userCh == 4) {
				System.out.println("Thanks for playing!");
				return;
			}
			
			System.out.println("This match: your " + printStr(userCh) + " versus the computer's " + printStr(compCh));
			System.out.println("The winner is " + getWinner(userCh, compCh) + "\n");			
		}
	}

	public static int getUserChoice(Scanner keybd) {
		System.out.println("Up for a round of rock, paper, scissors?");
		System.out.println("Select your choice, where 1 = Rock, 2 = Paper, 3 = Scissors, and 4 = Quit");
		
		return keybd.nextInt();
	}	
	
	public static int getCompChoice() {
		return (int)(Math.random()*1000%3) + 1;
	}	
	
	public static String printStr(int i) {
		switch(i){
		case 1: 
			return "rock";
		case 2:
			return "paper";			
		default: 
			return "scissors";			
		}		
	}

	public static String getWinner(int userCh, int compCh) {
		switch(userCh) {
		case 1:
			switch(compCh) {
			case 1: 	
				return "no one, it was a tie!";
			case 2: 
				return "the computer!";					
			case 3: 
				return "you!";
			}
			break;
		case 2:
			switch(compCh) {
			case 1: 
				return "you!";
			case 2: 
				return "no one, it was a tie!";				
			case 3: 
				return "the computer!";					
		}

			break;
			
		case 3:
			switch(compCh) {
			case 1: 
				return "the computer!";					
			case 2: 
				return "you!";
			case 3: 
				return "no one, it was a tie!";				
		}
			
			break;
			}
		return "Unknown!!!!!";
	}	
}
