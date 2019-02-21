import java.util.Scanner;

public class HangmanCmd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hangman game = new Hangman(); 
		Scanner sc = new Scanner(System.in);
		
		while(game.getStatus()!="exit") {
			showInterface(game); // Show current interface to user
			
			System.out.print("Type here:");
			

			
		
			game.change(sc.nextLine()); // apply input to the game
			
		}
		sc.close();
	}


	private static void showInterface(Hangman game) {
		
		String status = game.getStatus();
		System.out.println(emptyLines());
		
		switch(status) {
			case "startGame": 
				
				System.out.println(drawHangman(12));
				System.out.println("Welcome to Hangman The Game!\n");
				System.out.println("Enter 'n' for New Player or 'e' for Existing Player" );
				break;
			
			case "NewPlayer":
				System.out.println(drawHangman(12));
				System.out.println("Welcome to Hangman The Game!\n");
				System.out.println("Enter 'n' for New Player or 'e' for Existing Player" );
				
				System.out.println("Sorry... this function hasnt yet implemented..." );
				break;
				
			case "ExistingPlayer":
				System.out.println(drawHangman(12));
				System.out.println("Choose a player by entering corresponding number \n");
				System.out.println("1 Default" );
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
				System.out.println(game.getCurrentAlphabet()+"\n");
				System.out.println(drawDashes(game));
				
				break;
				
			case "LoadGame":
				System.out.println(drawHangman(12));
				System.out.println("Welcome to Hangman The Game, " + game.getPlayer().getName()+"!\n");
				System.out.println("Enter 'p' to Play New Game" );
				System.out.println("Enter 'l' to Load Your Previous Game" );
				System.out.println("Enter 'h' to Look At Highscores" );
				System.out.println("Enter 'q' to Exit Game" );
				System.out.println("Sorry... this function hasnt yet implemented... Try again" );
				break;
				
			case "Higscores":
				System.out.println(drawHangman(12));
				System.out.println("Welcome to Hangman The Game, " + game.getPlayer().getName()+"!\n");
				System.out.println("Enter 'p' to Play New Game" );
				System.out.println("Enter 'l' to Load Your Previous Game" );
				System.out.println("Enter 'h' to Look At Highscores" );
				System.out.println("Enter 'q' to Exit Game" );
				System.out.println("Sorry... this function hasnt yet implemented... Try again" );
				break;
				
			case "exitGame":
				System.out.println("see you!");
				break;
				
			case "YouLoose":
				System.out.println(drawHangman(12));
				System.out.println("Sorry.. You lose. The word was '"+ game.getWordToGuess()+"'");
				System.out.println("Your final score is XXX");
				System.out.println("Do you want to play again ?");
				System.out.println("Enter 'p' to Play New Game" );
				System.out.println("Enter 'h' to Look At Highscores" );
				System.out.println("Enter 'q' to Exit Game" );
				break;	
				
			case "YouWin":
				System.out.println("Congratilations! You Win! The word was '"+ game.getWordToGuess()+"'");
				System.out.println("Your earn XXX points");
				System.out.println("Do you want to play again ?");
				System.out.println("Enter 'p' to Play New Game" );
				System.out.println("Enter 'h' to Look At Highscores" );
				System.out.println("Enter 'q' to Exit Game" );
				break;	
		
				
		}
		
	}
	
	/*
	 * Drawing current state of guessed word with dashes instaed unguessed lettes
	 */
	
	public static String drawDashes(Hangman game) { // drawing dashes
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
					
			
			
		
		//System.out.println(dashes); 
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
	
	/**
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
				line3 = "";
				line4 = "";
				line5 = "";
				line6 = "";
				break;
				
			case 1:
				line1 = "";
				line2 = "";
				line3 = "";
				line4 = "";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 2:
				line1 = "";
				line2 = "";
				line3 = "";
				line4 = "       | ";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
				
			case 3:
				line1 = "";
				line2 = "";
				line3 = "       | ";
				line4 = "       | ";
				line5 = "       | ";
				line6 = "       |_";
				break;
			
			case 4:
				line1 = "";
				line2 = "       | ";
				line3 = "       | ";
				line4 = "       | ";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 5:
				line1 = "     __ ";
				line2 = "       | ";
				line3 = "       | ";
				line4 = "       | ";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 6:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "       | ";
				line4 = "       | ";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 7:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "    o  | ";
				line4 = "       | ";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 8:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "    o  | ";
				line4 = "   /   | ";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 9:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "    o  | ";
				line4 = "   / \\ | ";
				line5 = "       | ";
				line6 = "       |_";
				break;
				
			case 10:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "    o  | ";
				line4 = "   /|\\ | ";
				line5 = "       | ";
				line6 = "       |_";
				break;
			
			case 11:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "    o  | ";
				line4 = "   /|\\ | ";
				line5 = "     \\ | ";
				line6 = "       |_";
				break;
				
			case 12:
				line1 = "     __ ";
				line2 = "    |  | ";
				line3 = "    o  | ";
				line4 = "   /|\\ | ";
				line5 = "    (\\ | ";
				line6 = "       |_";
				break;
		
		}
			
		
		return line1 + "\n" + line2 + "\n" +line3 + "\n" + line4 + "\n" + line5 + "\n" + line6 + "\n";
		}

}
