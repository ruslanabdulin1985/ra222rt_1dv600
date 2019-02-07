import java.util.Random;

/**
 * 
 */

/**
 * @author user
 *
 */
public class DataBase {

	// the base of words
	private static String[] words = {"invasion", "sattisfaction", "decision", "reabilitation"};
	
	// for settings
	//private static String[] settings = {};
	
	
	public static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; 
	
	
	// getters
	public static String getRandomWord() {
		Random rnd = new Random();
		return words[rnd.nextInt(words.length)];
		//
	}


	public static String getAlphabet(int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i<=end ; i++) {
			sb.append(alphabet[i]);
		}
		return sb.toString();
	}
	
}
