import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Assaingment3Tests {


	
	
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































