import java.util.Scanner;

/**
 * 
 */

/**
 * @author user
 *
 */
public class HangmanMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		Hangman testGame = new Hangman(); //(player, difficulty, player, topic)
		testGame.drawDashes();
		
		Scanner sc = new Scanner(System.in);
		
		char letter;
		while(testGame.isGameGoOn()) {
			System.out.print("test");
			testGame.renewInterface();
			
			
			letter = sc.nextLine().charAt(0);
			if (testGame.isThereAletter(letter)) {
				testGame.addToGuessed(letter);
				testGame.addToTried(letter);
				testGame.setLasCharacterGuest(1);
			}
			
			else {
				testGame.addToTried(letter);
				testGame.SetHangmanStatus(testGame.GetHangmanStatus()+3);
				testGame.setLasCharacterGuest(2);
				//
			}
			testGame.renewInterface();
			
			//break;
			
		
		}
		//System.out.print("The length" +DataBase.alphabet.length);
		sc.close();
	}

}
