import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.lang.Character;
import java.lang.String;

/**
 * 
 */

/**
 * @author user
 *
 */
public class Hangman {
	private String wordToGuess;
	
	private ArrayList<Character> triedLetters;
	private ArrayList<Character> guessedLetters; 
	private String systemMessage;
	
	
	//private boolean gameIsGoOn;
	private int hangmanStatus;
//	private int wasLasCharacterGuest;
	private Player player;

	private String status;

	 
	
	public Hangman() { // constructor
		this.wordToGuess = DataBase.getRandomWord();
		this.triedLetters = new ArrayList<Character>();
		this.systemMessage = "";
		this.status = "startGame";

		this.guessedLetters = new ArrayList<Character>();

		this.hangmanStatus = 0;
//		this.wasLasCharacterGuest =0;
		
		this.player = null;
		
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setDefaultHangman(Player player) {
		
		this.systemMessage = "";
		this.wordToGuess = DataBase.getRandomWord();
		this.triedLetters = new ArrayList<Character>();
		
		this.status = "startGame";

		this.guessedLetters = new ArrayList<Character>();

		this.hangmanStatus = 0;
//		this.wasLasCharacterGuest =0;
		
		this.player = player;
	}
	
	
	public String getSystemMessage() {
		return this.systemMessage;
	}
	
	public String getWordToGuess() {
		return wordToGuess;
	}
	
	public void setWordToGuess(String word) {
		this.wordToGuess = word;
	}
	
	
	public boolean isGameGoOn() {
		if (this.hangmanStatus>=12 || this.AmIWon())  //must be an error - toFIX !
			return false;
		else
			return true;	
	}
	
	public int GetHangmanStatus(){
		return this.hangmanStatus;
	}
	
	public void SetHangmanStatus(int currentStatus) {
		this.hangmanStatus = currentStatus;
	}
	
	
	public String drawDashes() { // drawing dashes
		String dashes = "";
		boolean coincidens = false;
		for (int i = 0; i<this.wordToGuess.length(); i++) {
			coincidens = false;
			for (int j = 0; j<this.guessedLetters.size(); j++)
				
				if (this.wordToGuess.charAt(i)!=(Character)guessedLetters.get(j))
					continue;
				else
					coincidens =true;
			
			if (coincidens)
				dashes = dashes + " " + wordToGuess.charAt(i) + " ";
			else
				dashes += " _ ";
		}
		return dashes;
					
	}
	
	
	public void addToGuessed(char a) {
		this.guessedLetters.add(a);
	}
	
	public boolean isThereAletter(char a) {
		boolean coincidens = false;
		for (int i = 0; i<this.wordToGuess.length();i++) {
			if (this.wordToGuess.charAt(i) == a) {
				coincidens = true;
				break;
			}
		}
		return coincidens;
	}
	
	public ArrayList<Character> getTriedLetters(){
		return triedLetters;
	}
	
	
	
	public String getCurrentAlphabet() {
		StringBuilder sb = new StringBuilder();
		boolean coincidens = false;
		for (char n: DataBase.alphabet) {
			coincidens = false;
			for (char m: this.triedLetters) {
				if (n!=m) {
					continue;
				}
				
				else
				{
					coincidens = true;
				}
			}
			
			if (coincidens) {
				sb.append("-");
				sb.append(n);
				sb.append("-");
				sb.append(" ");
			}
			else {
				sb.append("|");
				sb.append(n);
				sb.append("|");
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	
	
	public boolean AmIWon() {
		boolean win = true;
		for(int i=0; i<this.wordToGuess.length(); i++)
			if (this.guessedLetters.contains(this.wordToGuess.charAt(i)))
				continue;
			else {
				win = false;
				break;
			}
		return win;
	}

	public void addToTried(char letter) {
		this.triedLetters.add(letter);
	}

	public String getStatus() {
		if (this.status != "" && this.status != "GameIsClosed")
			return this.status;
		else return "GameIsClosed";
	}

	public void change(String input) {  //main function in the game
		// responsible for every change within the game
		
		this.systemMessage = "";
		
		
		
		switch(this.status) {
		case "startGame":
			if (input.matches("n"))
				this.status = "NewPlayer";
			if (input.matches("e"))
				this.status = "ExistingPlayer";
			break;
	
		case "NewPlayer":
			try {
			Player newPlayer = new Player(input);
			DataBase.AddPlayer(newPlayer);
			this.status = "MainMenu";
			this.player = newPlayer;
			}
			
			catch(RuntimeException e) {
				this.systemMessage = e.getMessage();
			}
			
			
			break;
			
		
		case "ExistingPlayer":
			// hasn't been fully implemented 
			ArrayList<Player> listOfPlayers =  DataBase.getPlayers();
			
			try {
			this.player = listOfPlayers.get(Integer.valueOf(input)-1);
			this.status = "MainMenu";
			}
			catch (Exception e){
				this.systemMessage += "Error! There is no such a player";
			}
					
			break;
			
		case "MainMenu":
			// hasn't been fully implemented 
			if (input.matches("p"))
				this.status = "GameMustGoOn";
			
			if (input.matches("l")) {
				if (Save.isSaveExists(this)) {
					try {
						Save.loadGame(this);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						this.systemMessage = e.getMessage();
					}
				}
				else {
					this.status = "MainMenu";
					this.systemMessage = "Couldn't find your game";
				}
				break;
			}
			
			if (input.matches("h"))
				this.status = "Higscores";
			
			if (input.matches("q"))
				this.status = "exit";
			
			break;
			
//		case "LoadGame":
//			if (Save.isSaveExists(this)) {
//				System.out.println("it exists !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//				try {
//					Save.loadGame(this);
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					this.systemMessage = e.getMessage();
//				}
//			}
//			else {
//				this.status = "MainMenu";
//				this.systemMessage = "Couldn't find your game";
//			}
//			break;
			
		case "Higscores":
			this.status = "MainMenu";
			
			if (input.matches("m"))
				this.status = "MainMenu";
			
			if (input.matches("q"))
				this.status = "exit";
			
			break;
			
		case "GameMustGoOn":
			
			
			if (this.GetHangmanStatus()<12 && !input.matches("exit")) {
				if (this.isThereAletter(input.charAt(0))) { //contunue gamming process
			
					this.addToGuessed(input.charAt(0));
					this.addToTried(input.charAt(0));
//					this.setLasCharacterGuest(1);
				}
				
				else {
					this.addToTried(input.charAt(0));
					this.SetHangmanStatus(this.GetHangmanStatus()+2);
					if (this.GetHangmanStatus()>=12) {
						this.status = "YouLoose";
						if (this.player.getScore() > this.player.getHighscore()) {
							this.player.setHighScore(this.player.getScore());
							DataBase.addPlayerToFs(this.player);
						}
					}
				}
			}
			else {
				this.status = "YouLoose";
				if (this.player.getScore() > this.player.getHighscore()) {
					this.player.setHighScore(this.player.getScore());
					DataBase.addPlayerToFs(this.player);
				}
			}
				
			
			if (this.AmIWon()) {
				this.status = "YouWin";
				this.player.setScore(this.player.getScore()+(12-this.hangmanStatus));
				if (this.player.getScore() > this.player.getHighscore()) {
						this.player.setHighScore(this.player.getScore());
						DataBase.addPlayerToFs(this.player);
					}
			}
			// hasn't been fully implemented 
				
			break;
				
		case "YouLoose":
			
			if (input.matches("p")) {
				setDefaultHangman(this.player);
				this.status = "GameMustGoOn";
				
			}
			
			if (input.matches("m")) {
				
				setDefaultHangman(this.player);
				this.status = "MainMenu";
			}
			if (input.matches("q"))
				this.status = "exit";
			
			break;	
		
		case "saveGame":
			if (input.matches("y")) {
				Save.saveGame(this);
				this.status = "exitGame";
			}
			if (input.matches("n"))
				this.status = "exitGame";
		
			break;
			
		case "exitGame":
			System.exit(-1);
			break;
			
		case "YouWin":
			
			
			
			if (input.matches("p")) {
				setDefaultHangman(this.player);
				this.status = "GameMustGoOn";
			}

			if (input.matches("m")) {
				setDefaultHangman(this.player);
				this.status = "MainMenu";
			}
			if (input.matches("q"))
				this.status = "exit";
			
			break;	
			
		}

		
		if (input.matches("exit")) {  // if typed exit at any time
			if (isGameGoOn())
				this.status = "saveGame";
			else
				this.status = "exitGame";
//			if (this.triedLetters.size() != 0 && isGameGoOn()) // if there are any tired letters TODO - if there are any earned points
//				this.status = "saveGame";
//			
//			else if(this.player.getScore()>0 && isGameGoOn())
//				this.status = "saveGame";
//			
//			this.status = "exit";
		}
		
//		System.out.println("Current status: "+ this.status);
//		System.out.print("Current Input: ?" + input + "?" );
		
	}

	public Player getPlayer() {
		return this.player;
	}
	
	public ArrayList<Character> getGuessedLetters() {
		return this.guessedLetters;
	}	
	
	public void setStatus (String paramStatus) {
		this.status = paramStatus;
	}	
}
