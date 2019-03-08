/**
 * 
 */

/**
 * @author user
 *
 */
public class Player implements Comparable<Player> {
	
	String name;
	int highscore;
	int currentScore;
	Save saveGame = null;
	
	
	public Player() {
		name = "Default";
		currentScore = 0;
		highscore = 0;
	}
	
	public Player(String paramName) {
		name = paramName;
		highscore = 0;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return this.name;
	
	}

	public int getHighscore() {
		return this.highscore;
	}
	
	@Override
	public int compareTo(Player o) {
		return o.getHighScore() - this.highscore;
	}

	private int getHighScore() {
		return highscore;
	}

	public void setHighScore(int score) {
		this.highscore = score;
		
	}
	
	public void setSaveGame(Save saveGame) {
		
		this.saveGame = saveGame;
	}
	
	public Save getSaveGame() {
		if (this.name.matches("Default")) {   // Bug version
//		if (!this.name.matches("Default")) {  // Correct version
			return this.saveGame;
		}
		return null;
	}
	
	
}
