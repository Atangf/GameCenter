package gameCenter;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	
static Scanner scan = new Scanner(System.in);
static Random ran = new Random();
static int num = 0;
	  
	  public static void main(String[] args) {
			playUntilNoTie();
		}


	    public static boolean playOneRound() {
	        String[] pick = {"rock", "paper", "scissors"};

	        System.out.println("Please enter your input (rock, paper, or scissors):");
	        String input = scan.nextLine().toLowerCase().trim();
	        System.out.println("User: " + input);

	        num = ran.nextInt(3);
	        String comp = pick[num];
	        System.out.println("Computer: " + comp);

	        if (input.equals(comp)) {
	            System.out.println("It's a tie!");
	            return true; 
	        }

	        if (
	            (input.equals("rock") && comp.equals("scissors")) ||
	            (input.equals("paper") && comp.equals("rock")) ||
	            (input.equals("scissors") && comp.equals("paper"))
	        ) {
	            System.out.println("You won!");
	            pause();
	        } else {
	            System.out.println("You lost...");
	            pause();
	        } 
	        return false;
	       
		}

	    public static void playUntilNoTie() {
	        boolean tie;
	        do {
	        	num = ran.nextInt(3);
	            tie = playOneRound();
	        } while (tie);
	        choice();
	        
	    }
	    
	    private static void pause() {
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	        
	    public static void choice() {     
	        System.out.println("Would you like to continue playing? (Please input Y or N):");
            String choose = scan.nextLine(); 
         
            while (choose.equals("Y")) {
	            playUntilNoTie();
	            System.out.println("Would you like to continue playing? (Please input Y or N):");
	            choose = scan.nextLine();
	        }
            
            if (choose.equals("N")) {
            System.out.println("Thanks you for Playing!\nPress enter to go back to menu");
            choose = scan.nextLine();
            String space = "";
            if (choose.equals(space)){
            	Main.centerWelcome();
            	}
            } else {
            	System.out.println("Error. Incorrect input try again.");
            	choice();
            }
            
	        
	    }
	    
}

