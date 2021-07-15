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
		// These variables keep track of the number of wins/ties/losses
		// from the human player's perspective 
		int numWins = 0, numTies = 0, numLosses = 0, roundCount = 0, result = 0;
		
		Scanner keybd = new Scanner(System.in);
		boolean keepPlaying = true; 
				
		while(keepPlaying) {
			numWins = 0;
			numLosses = 0;
			numTies = 0;
			
			roundCount = getNumRounds(keybd);
			for(int i = 0; i < roundCount; i++) {
				int userCh = getUserChoice(keybd);
				int compCh = getCompChoice();

				System.out.println("This match: your " + printStr(userCh) + " versus the computer's " + printStr(compCh));
				result = getWinner(userCh, compCh);
				switch(result) {
				case -1: 
					numLosses++;
					System.out.println("The computer won this round!\n");								
					break;
				case 0:
					numTies++;
					System.out.println("No one won this round, it was a tie!\n");													
					break;					
				case 1: 
					numWins++;
					System.out.println("You won this round! \n");								
					break;
				}
			}	
				
			System.out.println("\n\nAfter this mighty and difficult competition, the results are: ");
			System.out.println("Wins: " + numWins + "\t\tTies: " + numTies + "\t\tLosses: " + numLosses);
			System.out.println("Which means the winner is: " + getOverallWinner(numWins, numLosses));
			
			keepPlaying = promptRematch(keybd);
		}
		System.out.print("Goodbye!");
	}

	public static int getUserChoice(Scanner keybd) {
		// System.out.println("Up for a round of rock, paper, scissors?");
		System.out.println("Select your choice, where 1 = Rock, 2 = Paper, 3 = Scissors");
		
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

	public static int getWinner(int userCh, int compCh) {
		switch(userCh) {
		case 1:
			switch(compCh) {
			case 1: 	
				return 0;
			case 2: 
				return -1;
			case 3: 
				return 1;
			}
			break;
		case 2:
			switch(compCh) {
			case 1: 
				return 1;
			case 2: 
				return 0;				
			case 3: 
				return -1;					
		}

			break;
			
		case 3:
			switch(compCh) {
			case 1: 
				return -1;					
			case 2: 
				return 1;
			case 3: 
				return 0;				
		}
			
			break;
			}
		return 0;
	}	

	public static String getOverallWinner(int numWins, int numLosses) {
		if(numWins == numLosses) {
			return "no one. It was a tie!";
		} else if (numWins > numLosses) {
			return "you! Congratulations!";
		} else {
			return "the computer. Unlucky :(";
		}		
	}
	
	public static boolean promptRematch(Scanner keybd) {
		boolean invalidResponse = true, haveRematch = false;
		String response;
		while(invalidResponse) {
			keybd.nextLine();
			System.out.println("Would you like to play another game? Please enter \"Yes\" or \"No\"");
			response = keybd.nextLine();

			if(response.toLowerCase().equals("yes")) {
				invalidResponse = false;
				haveRematch = true;				
			}
			else if (response.toLowerCase().equals("no")) {
				invalidResponse = false;
				haveRematch = false;
			}						
		}
		return haveRematch;
	}

	public static int getNumRounds(Scanner keybd) {
		int numRounds = 0;
		boolean invalidResponse = true; 
		String str;
		
		while(invalidResponse) {
			System.out.println("How many rounds would you like to play?");	
			str = keybd.nextLine();
			try {
				numRounds = Integer.valueOf(str);				
			}catch(Exception e) {
				System.out.println("Your answer must be an integer");
				continue;
			}
			if(numRounds >= 1 && numRounds <= 10) {
				invalidResponse = false;
			} else {
				System.out.println("Your answer must be between 1 and 10 (inclusive)");
			}
		}		
		return numRounds;
	}
}


