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

	public void setScore(int score) {
		this.currentScore = score;
	}
	
	public int getScore() {
		return this.currentScore;
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
	
}
