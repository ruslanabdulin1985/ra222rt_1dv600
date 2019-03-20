import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// static class to make save/load possible
public class Save {
	
	
	// save all the data into corresponding file
	public static void saveGame(Hangman game) {
		HashMap<String, String> svg = new  HashMap<String, String>();
		svg.put("playerName", game.getPlayer().getName());
		svg.put("wordToGuess", game.getWordToGuess());
		svg.put("hangmanStatus", String.valueOf(game.GetHangmanStatus()));
		svg.put("guessedLetters", game.getGuessedLetters().toString().replaceAll(", ", "; "));
		svg.put("triedLetters", game.getTriedLetters().toString().replaceAll(", ", "; "));
		svg.put("highScore", String.valueOf(game.getPlayer().getHighscore()));
		svg.put("status", "GameMustGoOn");
		
		File saveFile = new File("saves\\" + game.getPlayer().getName() + ".sav");
		
		try {
			BufferedWriter writer;
			System.out.println(saveFile.getPath());
			writer = new BufferedWriter(new FileWriter(saveFile.getPath()));
			writer.write(svg.toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// checks if the save file exists
	public static boolean isSaveExists(Hangman game) {
		
		
		File savesFolder = new File("saves\\"); //looking in saves folder
		
		for(File n: savesFolder.listFiles()) {
			if (n.getName().matches(game.getPlayer().getName() + ".sav"))
				return true;
		}
		return false;
	}
	
	// load previous game from correspondig file
	public static void loadGame(Hangman game) throws FileNotFoundException {
		File dataFile = new File("saves\\"+game.getPlayer().getName()+".sav");
		Scanner sc = new Scanner(dataFile);
		String data = sc.nextLine(); //take the data from file
		sc.close();
		
		HashMap<String, String> svg = parse(data);
		ArrayList<Character> triedLetters = parseCharArr(svg.get("triedLetters"));
		for (char n: triedLetters)
			game.addToTried(n);
		
		ArrayList<Character> guessedLetters = parseCharArr(svg.get("guessedLetters"));
		for (char n: guessedLetters)
			game.addToGuessed(n);
		
		game.setWordToGuess(svg.get("wordToGuess"));
		game.SetHangmanStatus(Integer.valueOf(svg.get("hangmanStatus")));	
		game.setStatus(svg.get("status"));
	}
	
	// parse string into char array
	public static ArrayList<Character> parseCharArr (String data){
		
		data = data.substring(1, data.length()-1);
		ArrayList<Character> charArrList = new ArrayList<Character>();
		String[] chars = data.split("; ");
		for (String n : chars)
			if (n.length()>0)
				charArrList.add(n.charAt(0));
			
		return charArrList;	
	}
	
	//Parse string into set
	public static HashMap<String, String> parse(String data){
			
			HashMap<String, String> jo2 = new HashMap<String, String>();
//			System.out.println(data);
			data = data.substring(1, data.length()-1);
//			System.out.println(data);
			String[] pairs = data.split(", ");
//			System.out.println(Arrays.toString(pairs));
		for(String m: pairs) {
				System.out.println(m);
				String[] pair = m.split("=");
				jo2.put(pair[0], pair[1]);
						
			}
			
			return jo2;
	}
	
}
