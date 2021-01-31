package game10000;


public class TurnLogic {
	TurnOne turnOne = new TurnOne ();
		
	// provide continuous turns until victory and add points to players
	public void takeTurns() {
		
		while (true) {
			boolean done = true;
			for (int i = 0; i < GameSetup.playersArr.length; i++) {
				System.out.println(GameSetup.playersArr[i].getPlayerName() +" turn");			
				turnOne.tempPoints = 0;
				turnOne.doTurn();
				int points = GameSetup.playersArr[i].getPoints();
				GameSetup.playersArr[i].setPoints(points + turnOne.tempPoints);
				System.out.println("TOTAL POINTS: " + GameSetup.playersArr[i].getPoints());
				int winPoints = GameSetup.playersArr[i].getPoints();
				if (winPoints < 10000){
					done = false;
				} else {
					done = true;
					System.out.println(GameSetup.playersArr[i].getPlayerName() + " you won!");
				}
			}
			if (done){
				break;
			}
		}
	}
}
