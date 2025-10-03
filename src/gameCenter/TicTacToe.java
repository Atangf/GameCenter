package gameCenter;

import java.util.Scanner; 

public class TicTacToe {
	
	static String [] board = {"1","2", "3", "4", "5", "6", "7" ,"8", "9"};
	static int place = 0;
	static Scanner scan = new Scanner(System.in);
	static String turn = "";
	static int count = 3;
	static String line = "";
	static String result = checkWinner();
	static String choice = "";
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe!");
		printBoard();
		playGame();
	}

	public static void printBoard() {
		System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }
	
	public static void playGame() {		
		for (int a = 0; a < 9; a++) {
				if ((count % 2) == 0) {
					turn = "0";
					count++;
				}
				else {
					turn = "X";
					count++;
				}
				result = checkWinner();
				if (result.equals("WX")) {
				    System.out.println("X wins!");
				    pause();
				    endChoice();
				    break;
				} else if (result.equals("W0")) {
				    System.out.println("O wins!");
				    pause();
				    endChoice();
				    break;
				} else if (result.equals("T")) {
			        System.out.println("It's a tie!");
			        pause();
			        endChoice();
			        break;
				}
				
		System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
		choosePlace(); 
		}
	}
	
	public static void choosePlace() {
	    boolean valid = false;

	    while (!valid) {
	        if (scan.hasNextInt()) {
	            place = scan.nextInt();
	            scan.nextLine(); 

	            if (place >= 1 && place <= 9) {
	                if (!board[place - 1].equals("X") && !board[place - 1].equals("0")) {
	                    board[place - 1] = turn;
	                    valid = true;
	                } else {
	                    System.out.println("Error: spot already taken, try again.");
	                }
	            } else {
	                System.out.println("Error: number must be between 1 and 9.");
	            }

	        } else {
	            System.out.println("Error: please enter a number.");
	            scan.next(); 
	        }
	    }

	    printBoard();
	}
	
	public static String checkWinner() {
	    for (int a = 0; a < 8; a++) {
	        switch (a) {
	            case 0: line = board[0] + board[1] + board[2]; break;
	            case 1: line = board[3] + board[4] + board[5]; break;
	            case 2: line = board[6] + board[7] + board[8]; break;
	            case 3: line = board[0] + board[3] + board[6]; break;
	            case 4: line = board[1] + board[4] + board[7]; break;
	            case 5: line = board[2] + board[5] + board[8]; break;
	            case 6: line = board[0] + board[4] + board[8]; break;
	            case 7: line = board[2] + board[4] + board[6]; break;
	        }

	        if (line.equals("XXX")) {
	            return "WX";
	        } else if (line.equals("OOO")) {
	            return "W0";
	        }
	    }
	       
	    boolean tie = true;
	    for (int i = 0; i < 9; i++) {
	       if (board[i].equals(String.valueOf(i+1))) {
	          tie = false; 
	          break;
	            }
	        }
	    
	    if (tie) {
	        return "T"; 
	    }
	        
	   return "N"; 
	}
	
	private static void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public static void endChoice() { 
	    boolean valid = false;
	    while (!valid) {
	        System.out.println("Would you like to continue playing? (Please input Y or N):");
	        choice = scan.nextLine().trim().toUpperCase();

	        if (choice.equals("Y")) {
	            resetBoard();
	            playGame();
	            valid = true;
	        } else if (choice.equals("N")) {
	            menu();
	            valid = true;
	        } else {
	            System.out.println("Error. Incorrect input, try again.");
	        }
	    }
	}
            
	public static void menu() {
	    System.out.println("Thanks you for Playing!\nPress enter to go back to menu");
	    scan.nextLine(); 
	    Main.centerWelcome();
	}

	public static void resetBoard() {
	    for (int i = 0; i < 9; i++) {
	        board[i] = String.valueOf(i + 1);
	    }
	    count = 3; 
	}
	
}
