import java.util.ArrayList;

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
	
	public Hangman() { // constructor
		//wordToGuess = "alfa";
		wordToGuess = DataBase.getRandomWord();
		triedLetters = new ArrayList<Character>();
		//triedLetters[0] = 'b';
		guessedLetters = new ArrayList<Character>();
		//guessedLetters.add('a');
		//gameIsGoOn = true;
		hangmanStatus = 0;
		wasLasCharacterGuest =0;
		
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
				if (this.wordToGuess.charAt(i)!=guessedLetters.get(j))
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
	
	
	
	
	public void renewInterface() {
		for(int i = 0; i<4; i++)
			System.out.println(" ");
		
		System.out.println(DrawHangmanImage.draw2(hangmanStatus));
		
		if(this.AmIWon()) {
			System.out.println(" ");
			System.out.print("You Win");
			System.out.println(" ");
		}
		
		if(this.isGameGoOn()) {
			System.out.println(" ");
			System.out.println(this.getCurrentAlphabet());
			System.out.println(" ");
		}
		
		System.out.println(this.drawDashes());
		System.out.println(" ");
		
		if (wasLasCharacterGuest == 0)
			System.out.println("");
		else if (wasLasCharacterGuest == 1)
			System.out.println("correct !");
		else 
			System.out.println("wrong !");
		
		if(this.isGameGoOn())
			System.out.print("Enter a letter: ");
		else
			if (!this.AmIWon())
				System.out.print("You Loose");
		
		
		//System.out.println(DataBase.getAlphabet(13, 25));
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
	
}
