import java.util.ArrayList;
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
	//private boolean gameIsGoOn;
	private int hangmanStatus;
	private int wasLasCharacterGuest;
	private Player player;

	private String status;

	 
	
	public Hangman() { // constructor
		//wordToGuess = "alfa";
		wordToGuess = DataBase.getRandomWord();
		triedLetters = new ArrayList<Character>();
		
		status = "startGame";
		//triedLetters[0] = 'b';
		guessedLetters = new ArrayList<Character>();
		//guessedLetters.add('a');
		//gameIsGoOn = true;
		hangmanStatus = 0;
		wasLasCharacterGuest =0;
		
		player = null;
		
	}
	
	public void setDefaultHangman(Player player) {
		wordToGuess = DataBase.getRandomWord();
		triedLetters = new ArrayList<Character>();
		
		status = "startGame";
		//triedLetters[0] = 'b';
		guessedLetters = new ArrayList<Character>();
		//guessedLetters.add('a');
		//gameIsGoOn = true;
		hangmanStatus = 0;
		wasLasCharacterGuest =0;
		
		this.player = player;
	}
	
	
	public String getWordToGuess() {
		return wordToGuess;
	}
	
	public boolean isGameGoOn() {
		if (this.hangmanStatus>=12 || this.AmIWon())
			return false;
		else
			return true;	
	}
	
	public void setLasCharacterGuest(int n) {
		wasLasCharacterGuest = n;
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
					
			
			
		
		//System.out.println(dashes); 
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
		return this.status;
	}

	public void change(String input) {
		
		switch(this.status) {
		case "startGame":
			if (input.matches("n"))
				this.status = "NewPlayer";
			if (input.matches("e"))
				this.status = "ExistingPlayer";
			break;
	
		case "NewPlayer":
			this.status = "startGame";
			change(input);
			// hasn't been implemented
			break;
		
		case "ExistingPlayer":
			// hasn't been fully implemented 
			this.player = new Player();
			this.status = "MainMenu";
			break;
			
		case "MainMenu":
			// hasn't been fully implemented 
			if (input.matches("p"))
				this.status = "GameMustGoOn";
			
			if (input.matches("l"))
				this.status = "LoadGame";
			
			if (input.matches("h"))
				this.status = "Higscores";
			
			if (input.matches("q"))
				this.status = "exit";
			
			break;
			
		case "LoadGame":
			this.status = "MainMenu";
			change(input);
			// hasn't been implemented
			break;
			
		case "Higscores":
			this.status = "MainMenu";
			change(input);
			// hasn't been implemented
			break;
			
		case "GameMustGoOn":
			if (this.GetHangmanStatus()<12) {
				if (this.isThereAletter(input.charAt(0))) {
					this.addToGuessed(input.charAt(0));
					this.addToTried(input.charAt(0));
					this.setLasCharacterGuest(1);
				}
				
				else {
					this.addToTried(input.charAt(0));
					this.SetHangmanStatus(this.GetHangmanStatus()+2);
					this.setLasCharacterGuest(2);
					//
				}
			}
			else
				this.status = "YouLoose";
			// hasn't been fully implemented 
				
				
			
			if (this.AmIWon())
				this.status = "YouWin";
			// hasn't been fully implemented 
				
			break;
			
			
			
		case "YouLoose":
			if (input.matches("p"))
				this.status = "GameMustGoOn";

			if (input.matches("h"))
				this.status = "Higscores";
			
			if (input.matches("q"))
				this.status = "exit";
			
			break;	
			
		case "YouWin":
			if (input.matches("p"))
				this.setDefaultHangman(this.player);
				this.status = "GameMustGoOn";
				

			if (input.matches("h"))
				this.status = "Higscores";
			
			if (input.matches("q"))
				this.status = "exit";
			
			break;	
			
		}
		
		
			
		
		
		
		System.out.println("Current status: "+ this.status);
		System.out.print("Current Input: ?" + input + "?" );
		
	}

	public Player getPlayer() {
		return this.player;
	}

	public ArrayList<Character> getGuessedLetters() {
		// TODO Auto-generated method stub
		return this.guessedLetters;
	}	
	
}
