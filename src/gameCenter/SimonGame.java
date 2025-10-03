package gameCenter;

import java.util.Random;
import java.util.Scanner;

public class SimonGame {

	 static Scanner scan = new Scanner(System.in);
	    static Random ran = new Random();

	    static String pick = "";
	    static String compChoice = "";
	    static String storeAnswer = "";
	    static String user = "";
	    static int score = 0;
	    static int sleep = 1000;
	    static int gamesPlayed = 1;
	    static String enter = "";

	    public static void main(String[] args) {
	        System.out.println("Welcome to SimonGame!");
	        playGame();
	        welcome();
	    }

	    public static void welcome() {
	        while (true) {
	            System.out.println("Do you want to play again? Type yes or no");
	            pick = scan.nextLine();

	            if (pick.equals("yes")) {
	                score = 0;
	                sleep = 1000;
	                playGame();
	                gamesPlayed++;
	                break;
	            } else if (pick.equals("no")) {
	                System.out.println("Thanks for playing!");
	                System.out.println("You have played " + gamesPlayed + " games.\nPress enter to go back to menu");
	                pick = scan.nextLine();
	                	if (pick.equals(enter)){
	                		Main.centerWelcome();
	                	  }
	                	} else {
	                		System.out.println("Error. Incorrect input try again.");
	                		welcome();
	                		break;         
	              }
	                System.out.println("Incorrect input. Try Again.");
	            }
	        }

	    public static void clearScreen() {
	        for (int i = 0; i < 100; i++) {
	            System.out.println();
	        }
	    }

	    public static void checkScore(){
			try {
				if (user.equals(storeAnswer)) {
					score++;
					System.out.println("correct!");
					System.out.println("Score: " + score);
					Thread.sleep(1000);
					clearScreen();
				}
				else {
					score--;
					System.out.println("Wrong!");
					System.out.println("Score: " + score);
					Thread.sleep(1000);
					clearScreen();
			}
		}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	    public static void playGame() {
	        String[] colors = {"blue", "green", "yellow", "red"};

	        while (score > -3 && score < 5) {
	            storeAnswer = "";
	            int count = 0;

	            System.out.println("Simon says: ");
	            try {
	                while (count < 3) {
	                    int num = ran.nextInt(4);
	                    compChoice = colors[num] + " ";
	                    System.out.print(compChoice);
	                    storeAnswer += compChoice;

	                    Thread.sleep(sleep);
	                    count++;
	                }
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            clearScreen();
	            System.out.println("\nYour turn!");
	            user = scan.nextLine() + " ";

	            checkScore();

	            if (score > 0 && score < 5) {
	                sleep = Math.max(250, sleep - 250);
	                System.out.println("next level");
	            }
	            if (score > 5) {
	            	sleep = Math.max(0, sleep - 50);
	            	System.out.println("next level");
	            }
	        }

	        if (score <= -3) {
	            System.out.println("You lost!");
	            welcome();
	        } else if (score >= 5) {
	            System.out.println("You won!");
	            welcome();
	        }
	    }

}
