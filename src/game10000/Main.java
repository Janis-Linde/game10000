package game10000;


public class Main {

	public static void main(String[] args) {
		GameSetup gs = new GameSetup();
		TurnLogic tl = new TurnLogic();
		
		gs.playerInfo();
		tl.takeTurns();
				
	}
}
