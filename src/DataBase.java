import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */

/**
 * @author user
 *
 */
public class DataBase {
	//Players
	static ArrayList <Player> players = new ArrayList<Player>();

	//Save savegame1 = new Save();
	
	//static Player[] predifindPlayers = {new Player(), new Player ("Ruslan"), new Player ("Vasya Pupkin")};
			
	
	
	
	// the base of words
	private static String[] words = {"invasion"}; //"sattisfaction", "decision", "reabilitation"};
	
	// for settings
	//private static String[] settings = {};
	
	
	public static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; 
	
	
	//public static 
	
	public static boolean fill() {
		
		Player ruslan = new Player ("Ruslan");
		Player vas = new Player ("Vasya Pupkin");
		
		ruslan.setHighScore(50);
		vas.setHighScore(90);
		
		ruslan.setSaveGame(new Save());
		
		players = new ArrayList<Player>();
		players.add(new Player());
		players.add(ruslan);
		players.add(vas);
		
		return true;
		
	}
	
	
	
	public static ArrayList<Player> getPlayers() {
		
		ArrayList <Player> playersToReturn = players;
		return playersToReturn;
		
	}
	
	public static boolean isPlayerUnique(Player player) {
		for (Player n : players)
			if (n.getName().matches(player.getName()))
				return false;
			
		return true;
	}
	
	public static void AddPlayer(Player player) {
		if (isPlayerUnique(player))
			players.add(player);
		
		else
			throw new RuntimeException("ERROR! : player with the same name already exists");
	}
	
	
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
