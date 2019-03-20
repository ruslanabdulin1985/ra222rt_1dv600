
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HangmanCmd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DataBase.fill(); // filling database with predefined data
		
		Hangman game = new Hangman(); 
		Scanner sc = new Scanner(System.in);
		
		while(game.getStatus()!="exit") {
			showInterface(game); // Show current interface to user
			if (game.getSystemMessage().matches(""))

				
			if (!game.getStatus().matches("exitGame"))  //
				System.out.println("Type here:");
			
			String userInput = sc.nextLine();

			if (!game.getStatus().matches("NewPlayer")) 
				userInput = userInput.toLowerCase();	// all the input to lower case
			
			game.change(userInput); // apply input to the game

		}
		sc.close();
	}

	// main function which decides what the interface to show to user
	// based on game.status
	private static void showInterface(Hangman game) { 
		
		String status = game.getStatus();
		System.out.println(emptyLines());
		if (!game.getSystemMessage().matches("")){
			System.out.println("------------------------------------------------");
			System.out.println(game.getSystemMessage());  // System message to show if something is wrong
			System.out.println("------------------------------------------------");
		}
		
		switch(status) {
			case "startGame": 
				
				System.out.println(drawHangman(12));
				System.out.println("Welcome to Hangman The Game!");
				System.out.println("To exit game -> type exit\n");
				System.out.println("Enter 'n' for New Player or 'e' for Existing Player" );
				break;
			
			case "NewPlayer":
				System.out.println(drawHangman(12));
				System.out.println("Welcome to Hangman The Game!");
				System.out.println("To exit game -> type exit\n");
				System.out.println("Enter Your Name" );
				
				break;
				
			case "ExistingPlayer":
				System.out.println(drawHangman(12));
				System.out.println("Choose a player by typing a corresponding number \n");
				
				ArrayList<Player> listOfPlayers =  DataBase.getPlayers();
				
				for (int i = 0; i<listOfPlayers.size();i++)
					System.out.printf("%s - %s \n", i+1, listOfPlayers.get(i));

				break;
				
			case "MainMenu":
				System.out.println(drawHangman(12));
				System.out.println("Welcome to Hangman The Game, " + game.getPlayer().getName()+"!\n");
				System.out.println("Enter 'p' to Play New Game" );
				System.out.println("Enter 'l' to Load Your Previous Game" );
				System.out.println("Enter 'h' to Look At Highscores" );
				System.out.println("Enter 'q' to Exit Game" );
				
				break;
				
			case "GameMustGoOn":
				System.out.println(drawHangman(game.GetHangmanStatus()));
				System.out.println(game.getCurrentAlphabet());
				System.out.println("To exit game -> type exit\n");
				System.out.println(drawDashes(game));
				
				break;
				
			case "LoadGame":
				System.out.println("Loading... press any button to continue");
				
				break;
				
			case "Higscores":
				
				System.out.println("TABLE OF HIGHSCORES\n");
				
				System.out.println("------------------------------------------------");
				System.out.println("   name  --  result");
				System.out.println("------------------------------------------------");
				ArrayList<Player> allPlayers = DataBase.getPlayers();
				Collections.sort(allPlayers);
				
				for (Player n : allPlayers)
					if (n.getName().matches(game.getPlayer().getName()))
						System.out.printf("%s -- %s                <--- You are here\n", n.getName(), n.getHighscore());
				
					else
						System.out.printf("%s -- %s\n", n.getName(), n.getHighscore());
				
				System.out.println("------------------------------------------------\n");
				
				System.out.println("Enter 'm' to ruturn to Main Menu" );
				System.out.println("Enter 'q' to Exit Game" );
				break;
			
			case "saveGame":
				System.out.println("Do you want to save your game ? y/n");
				break;
				
			case "exitGame":
				System.out.println("Come back and play again! See You ?");
				break;
				
			case "YouLoose":
				System.out.println(drawHangman(12));
				System.out.println("Sorry.. You lose. The word was '"+ game.getWordToGuess()+"'");
				System.out.println("Your final score is " + game.getPlayer().getHighscore());
				System.out.println("Do you want to play again ?");
				System.out.println("Enter 'p' to Play New Game" );
				System.out.println("Enter 'm' to return to Main Menu" );
				System.out.println("Enter 'q' to Exit Game" );
				break;	
				
			case "YouWin":
				System.out.println("Congratulations! You Win! The word was '"+ game.getWordToGuess()+"'");
				System.out.printf("You earned %s points. Total: %s \n", 12 - game.GetHangmanStatus(), game.getPlayer().getScore());
				System.out.println("Do you want to play again ?");
				System.out.println("Enter 'p' to Play New Game" );
				System.out.println("Enter 'm' to return to Main Menu" );
				System.out.println("Enter 'q' to Exit Game" );
				break;	
		}
		
	}
	
	/*
	 * Drawing current state of guessed word with dashes instaed unguessed lettes
	 */
	
	public static String drawDashes(Hangman game) { // drawing dashes representing the word to guess
		String dashes = "";
		boolean coincidens = false;
		for (int i = 0; i<game.getWordToGuess().length(); i++) {
			coincidens = false;
			for (int j = 0; j<game.getGuessedLetters().size(); j++)
				
				if (game.getWordToGuess().charAt(i)!=(Character)game.getGuessedLetters().get(j))
					continue;
				else
					coincidens =true;
			
			if (coincidens)
				dashes = dashes + " " + game.getWordToGuess().charAt(i) + " ";
			else
				dashes += " _ ";
		}
		return dashes;
	}
	
	
	/*
	 * drawing empty lines
	 */
	private static String emptyLines() {
		String out = "";
		for (int i = 0 ; i<10 ; i++)
			out += "\n";
		return out;
	}
	
	/*
	 * drawing hangman 
	 * 
	 * @param hangmanStatus - status of hangman from 0 to 12. 12 - completed picture
	 */
	private static String drawHangman(int hangmanStatus) {
		String line1 ="";
		String line2="";
		String line3="";
		String line4="";
		String line5="";
		String line6="";
		
		switch (hangmanStatus) {
			case 0:
				line1 = "";
				line2 = "";
				line3 = "          Hangman:  ";
				line4 = "            0%";
				line5 = "";
				line6 = "";
				break;
				
			case 1:
				line1 = "";
				line2 = "";
				line3 = "          Hangman: ";
				line4 = "            10%";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 2:
				line1 = "";
				line2 = "";
				line3 = "          Hangman: ";
				line4 = "       |    20%";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
				
			case 3:
				line1 = "";
				line2 = "";
				line3 = "       |  Hangman: ";
				line4 = "       | 	 25%";
				line5 = "       | ";
				line6 = "       |_";
				break;
			
			case 4:
				line1 = "";
				line2 = "       | ";
				line3 = "       |  Hangman: ";
				line4 = "       |    30%";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 5:
				line1 = "     __ ";
				line2 = "       | ";
				line3 = "       |  Hangman: ";
				line4 = "       |    40%";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 6:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "       |  Hangman: ";
				line4 = "       |    50% ";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 7:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "    o  |  Hangman: ";
				line4 = "       |    60% ";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 8:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "    o  |  Hangman: ";
				line4 = "   /   |    70% ";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 9:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "    o  |  Hangman: ";
				line4 = "   / \\ |   75% ";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 10:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "    o  |  Hangman: ";
				line4 = "   /|\\ |   80% ";
				line5 = "       | ";
				line6 = "       |_";
				break;
			
			case 11:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "    o  |  Hangman: ";
				line4 = "   /|\\ |   90% ";
				line5 = "     \\ | ";
				line6 = "       |_";
				break;
				
			case 12:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "    o  |  ";
				line4 = "   /|\\ | ";
				line5 = "    (\\ | ";
				line6 = "       |_";
				break;
		
		}
			
		
		return line1 + "\n" + line2 + "\n" +line3 + "\n" + line4 + "\n" + line5 + "\n" + line6 + "\n";
		}

}
