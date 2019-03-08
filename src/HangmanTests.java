import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class HangmanTests {
	
	
	
	Hangman game = new Hangman();
	
	
	@BeforeAll
	static void fillDataBase() {
	assertTrue(DataBase.fill());
	}
	
	// Class Hangman
	
	@Test
	void testDrawDashes() {

		assertEquals(" _  _  _  _  _  _  _  _ ", game.drawDashes());
		
		game.addToGuessed('i');
		game.addToGuessed('n');
		
		assertEquals(" i  n  _  _  _  i  _  n ", game.drawDashes());
	}
	
	@Test
	void getCurrentAlphabetTest() {
		game.addToTried('a');
		game.addToTried('g');
		game.addToTried('l');
		
		String correct = "-a- |b| |c| |d| |e| |f| -g- |h| |i| |j| |k| -l- |m| |n| |o| |p| |q| |r| |s| |t| |u| |v| |w| |x| |y| |z| ";
		String actual = game.getCurrentAlphabet();
				
		assertEquals(correct, actual);
	}
	
	
	@Test
	void AmIWonTest() {
		game.addToGuessed('i');
		game.addToGuessed('n');
		game.addToGuessed('v');
		game.addToGuessed('a');
		game.addToGuessed('s');
		game.addToGuessed('o');
		
		game.addToTried('i');
		game.addToTried('n');
		game.addToTried('v');
		game.addToTried('a');
		game.addToTried('s');
		game.addToTried('o');
		
		boolean actual = game.AmIWon();
		assertTrue(actual);
	}
	
	@Test
	void getPlayerTest() {
		Player correct = new Player("vasya");
		game.setDefaultHangman(correct);
		
		Player actual = game.getPlayer(); 
		
		assertEquals(correct, actual);
	}
	
	@Test
	void getGuessedLettersTest() {
		game.addToGuessed('i');
		game.addToGuessed('n');
		game.addToGuessed('v');
		game.addToGuessed('a');
		game.addToGuessed('s');
		game.addToGuessed('o');
		
		String correct = "[i, n, v, a, s, o]";
		String actual = game.getGuessedLetters().toString();
//		System.out.println(actual);
		assertEquals(correct, actual);
		
	}
	
	
	@Test
	void getWordToGuessTest( ) {
		String actual = game.getWordToGuess();
		String correct = "invasion"; 
		assertEquals(correct, actual);
	}
	
	@Test
	void isGameGoOnTest() {
		Boolean actual = game.isGameGoOn();
		assertTrue(actual);
		
		game.SetHangmanStatus(13);
		actual = game.isGameGoOn();
		assertFalse(actual);
		
		game.SetHangmanStatus(1);
		game.addToGuessed('i');
		game.addToGuessed('n');
		game.addToGuessed('v');
		game.addToGuessed('a');
		game.addToGuessed('s');
		game.addToGuessed('o');
		
		game.addToTried('i');
		game.addToTried('n');
		game.addToTried('v');
		game.addToTried('a');
		game.addToTried('s');
		game.addToTried('o');
		
		actual = game.isGameGoOn();
		assertFalse(actual);
		
		game.SetHangmanStatus(13);
		actual = game.isGameGoOn();
		
		assertFalse(actual);
	}

	@Test
	void setDefaultHangmanTest() {
		
		game.SetHangmanStatus(4);
		game.setStatus("Load Game");
		
		game.setDefaultHangman(new Player());
		
		assertEquals(0, game.GetHangmanStatus());
		assertEquals("startGame", game.getStatus());
	}
	
	@Test
	void getSystemMessage() {
		assertEquals("", game.getSystemMessage());
	}
	
	@Test
	void getStatusAllTheOthesTest() {
		
		
		game.setStatus("NewPlayer");
		game.change("Groll");
		
		assertEquals("Groll", game.getPlayer().getName());
		
		assertEquals("MainMenu", game.getStatus());
		
		game.setStatus("NewPlayer");
		game.change("Groll");
		
		assertEquals("ERROR! : player with the same name already exists", game.getSystemMessage());
	

		game.setStatus("ExistingPlayer");
		game.change("1");
		assertEquals("Default", game.getPlayer().getName());
		
		game.setStatus("ExistingPlayer");
		game.change("77");
		assertEquals("Error! There is no such a player", game.getSystemMessage());
		
		
		game.setStatus("MainMenu");
		game.change("p");
		assertEquals("GameMustGoOn", game.getStatus());
		
		game.setStatus("MainMenu");
		game.change("l");
		assertEquals("MainMenu", game.getStatus());
		assertEquals("ERROR! : this function hasn't yet implemented", game.getSystemMessage());
		
		game.change("h");
		assertEquals("Higscores", game.getStatus());
		
		game.setStatus("MainMenu");
		game.change("q");
		assertEquals("exit", game.getStatus());
		
		game.setStatus("Higscores");
		game.change("f");
		assertEquals("MainMenu", game.getStatus());
		
		game.setStatus("Higscores");
		game.change("m");
		assertEquals("MainMenu", game.getStatus());
		
		game.setStatus("Higscores");
		game.change("q");
		assertEquals("exit", game.getStatus());
		
		game.setStatus("GameMustGoOn");
		game.SetHangmanStatus(13);
		game.change("s");
		assertEquals("YouLoose", game.getStatus());
		
		game.setStatus("GameMustGoOn");
		game.SetHangmanStatus(2);
		game.change("t");
		assertEquals(4, game.GetHangmanStatus());
		
		game.setStatus("GameMustGoOn");
		game.SetHangmanStatus(2);
		game.change("i");
		assertTrue(game.getGuessedLetters().contains('i'));
		
		game.setStatus("GameMustGoOn");
		game.addToGuessed('i');
		game.addToGuessed('n');
		game.addToGuessed('v');
		game.addToGuessed('a');
		game.addToGuessed('s');
		game.addToGuessed('o');
		game.addToTried('i');
		game.addToTried('n');
		game.addToTried('v');
		game.addToTried('a');
		game.addToTried('s');
		game.addToTried('o');
		game.change("i");
		assertEquals("YouWin", game.getStatus());
		
		game = new Hangman();
		game.setStatus("YouLoose");
		game.change("h");
		assertEquals("Higscores", game.getStatus());
		
		game = new Hangman();
		game.setStatus("YouLoose");
		game.change("q");
		assertEquals("exit", game.getStatus());
		
		game = new Hangman();
		game.setStatus("YouLoose");
		game.change("p");
		assertEquals("GameMustGoOn", game.getStatus());
		
		game = new Hangman();
		game.setDefaultHangman(new Player("Strike"));
		game.setStatus("YouWin");
		game.change("p");
		assertEquals("GameMustGoOn", game.getStatus());
		
		game.setStatus("YouWin");
		game.change("q");
		assertEquals("exit", game.getStatus());
		
		game.setStatus("YouWin");
		game.change("h");
		assertEquals("Higscores", game.getStatus());
		
		game = new Hangman();
		game.setStatus("startGame");
		game.change("n");
		assertEquals("NewPlayer", game.getStatus());
		
		game = new Hangman();
		game.setStatus("startGame");
		game.change("e");
		assertEquals("ExistingPlayer", game.getStatus());
	
	}
	
	
	// Player class
	
	@Test
	void toStringPlayerTest() {
		Player groll = new Player("Groll");
		String expected = "Groll";
		String actual = groll.toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void HighscorePlayerTest() {
		Player groll = new Player("Groll");
		int expected = 0;
		int actual = groll.getHighscore();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void comparingPlayersTest() {
		Player groll = new Player("Groll");
		Player crell = new Player("Crell");
		
		assertEquals(0, groll.compareTo(crell));
	}
	
	@Test
	void playerGetSaveGameTest() {
		Player groll = new Player("Groll");
		Save actual = groll.getSaveGame();
		Save expected = null;
		
		Player def = new Player("Default");
		actual = def.getSaveGame();
		assertEquals(expected, actual);
		
	}
	
	// Save Class
	
	@Test
	void DataTest() {
		Save someSave = new Save("someData");
		
		String actual = someSave.getData();
		String expected = "someData";
		
		assertEquals(expected, actual);
		
	}
	
	//DataBase Class
	@Test
	void DBgetAlphabetTest() {
		String actual = DataBase.getAlphabet(0, 25);
		String expected = "abcdefghijklmnopqrstuvwxyz";
		
		assertEquals(expected, actual);
	}
	

	@Test
	void getStatusTest1() {
		// Function getStatus from class Hangman.java under the test
		
		//setup and test-input-output definitions
		Hangman game = new Hangman();  // creating a new game Hangman
		game.change("n"); // imitating correct user output
		
		// expected result
		String correctResult = "NewPlayer";  
		
		//running the method that we are testing, this is called "exercise the sut"
		String actual = game.getStatus(); 
		
		 //compare the actual result with the expected value and report (done by framework)
		assertEquals(correctResult, actual);
	}
	
	@Test
	void getStatusTest2() {
		// Function getStatus from class Hangman.java under the test
		
		//setup and test-input-output definitions
		Hangman game = new Hangman();  // creating a new game Hangman
		game.setStatus("ExistingPlayer");   //Setting status directly
		
		// expected result
		String correctResult = "ExistingPlayer";  
		
		//running the method that we are testing, this is called "exercise the sut"
		String actual = game.getStatus(); 
		
		 //compare the actual result with the expected value and report (done by framework)
		assertEquals(correctResult, actual);
	}
	
	@Test
	void isThereALetterTest1() {
		// Function getStatus from class Hangman.java under the test

		//setup and test-input-output definitions
		Hangman game = new Hangman();  // creating a new game Hangman
		
		//running the method that we are testing, this is called "exercise the sut"
		boolean actual = game.isThereAletter('i');
		
		assertTrue(actual);
	}
	
	@Test
	void isThereALetterTest2() {
		// Function getStatus from class Hangman.java under the test

		//setup and test-input-output definitions
		Hangman game = new Hangman();  // creating a new game Hangman
		
		//running the method that we are testing, this is called "exercise the sut"
		boolean actual = game.isThereAletter('f');
		
		//compare the actual result with the expected value and report (done by framework)
		assertFalse(actual);
	}
	
	@Test
	void GetSaveTest() { // Test to find a bug
		
		//Function GetSave from class Player.java under the test
		
		//setup and test-input-output definitions
		Player newPlayer = new Player("John");
		Save newPlayerSave = new Save();
		newPlayer.setSaveGame(newPlayerSave);
		
		//expected result
		Save correctResult = newPlayerSave;
		
		//running the method that we are testing, this is called "exercise the sut"
		Save actual = newPlayer.getSaveGame();
		
		//compare the actual result with the expected value and report (done by framework)
		assertEquals(correctResult, actual);
	}
	

}
