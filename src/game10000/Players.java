package game10000;


public class Players {
	private String playerName;
	private int points;
	
	Players(String playerName){
		this.playerName = playerName;
		points = 0;
	}
	

	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public String getPlayerName() {
		return playerName;
	}


	public String toString() {
		return "Players [playerName=" + playerName + ", points=" + points + "]";
	}
	
}
