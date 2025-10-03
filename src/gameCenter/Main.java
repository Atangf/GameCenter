package gameCenter;

import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static int choice = 0;
	
	
	public static void main(String[] args) {
		centerWelcome();
	}
	
	public static void centerWelcome() {
		System.out.println("WELCOME TO GAME CENTER!\n");
		System.out.println("Type 1 for 'Rock Paper Scissors'.\n-Classic game! Choose rock, paper, or scissors to beat the computer.\n");
		System.out.println("Type 2 for 'Simon Game'.\n-Memory challenge! Repeat the sequence of colors Simon tells you.\n");
		System.out.println("Type 3 for 'TicTacToe'\n-Two-player game! Take turns placing X or O. First to 3 in a row wins.\n");
		
		check();
	}
	
	
	public static void check() {
        boolean valid = false;

        while (!valid) {
            if (scan.hasNextInt()) {
                choice = scan.nextInt();

                if (choice == 1) {
                    RockPaperScissors.playUntilNoTie();
                    valid = true;
                } else if (choice == 2) {
                    SimonGame.playGame();
                    valid = true;
                } else if (choice == 3) {
                    TicTacToe.playGame();
                    valid = true;
                } else {
                    System.out.println("Error: number must be 1, 2, or 3.");
                }
            } else {
                System.out.println("Error: please enter a number.");
                scan.next(); 
            }
        }
    }

}
