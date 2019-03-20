import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

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
	private static String[] words = {"mountain", "country", "ocean", "wealth", "religion", "history", "photograph"};
	
	// for settings
	//private static String[] settings = {};
	
	
	public static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; 
	
	
	//public static 
	
	public static boolean fill() {
		
		Player ruslan = new Player ("Ruslan");
		Player vas = new Player ("Vasya Pupkin");
		
		ruslan.setHighScore(50);
		vas.setHighScore(90);
		
		players = playersFromFS();
//		players = 
//		players = new ArrayList<Player>();
//		players.add(new Player());
//		players.add(ruslan);
//		players.add(vas);
		
		return true;
		
	}
	
	
	// Get list of existing players
	public static ArrayList<Player> getPlayers() {
		
		return players;
	}
	
	// downloading players from file system
	
	public static ArrayList<Player> playersFromFS() {
		ArrayList <Player> playersToReturn = players;
	
		File playersFolder = new File("players\\"); //looking in players folder
		String playerName = "name";
		Player playerToAdd = new Player("Default");
		playersToReturn.add(playerToAdd);
		Scanner sc = null;
		for (File n: playersFolder.listFiles()) {
			
			playerName = n.getPath().substring(playersFolder.getPath().length()+1, n.getPath().length()-4);
			
			try {
				sc = new Scanner(n);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			playerToAdd = new Player(playerName);
			playerToAdd.setHighScore(sc.nextInt());	
			
			playersToReturn.add(playerToAdd);
		}
		sc.close();
		return playersToReturn;	
	}
	
	public static boolean isPlayerUnique(Player player) {
		for (Player n : players)
			if (n.getName().matches(player.getName()))
				return false;
			
		return true;
	}
	
	public static void AddPlayer(Player player) {
		if (isPlayerUnique(player)) {
			players.add(player);
			addPlayerToFs(player);
		}
		else
			throw new RuntimeException("ERROR! : player with the same name already exists");
	}
	
	
	// getters
	public static String getRandomWord() { 
		Random rnd = new Random();
		return words[rnd.nextInt(words.length)];
		//
	}
	
	//saving player in local file system in players folder
	public static void addPlayerToFs(Player player) { 
		File playerFile = new File("players\\" + player.getName() +  ".dat"); 
		try {
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter(playerFile.getPath()));
			writer.write(String.valueOf(player.getHighscore()));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Alphabet of available words
	public static String getAlphabet(int start, int end) { 
		StringBuilder sb = new StringBuilder();
		for (int i = start; i<=end ; i++) {
			sb.append(alphabet[i]);
		}
		return sb.toString();
	}
	
}
