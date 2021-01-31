package game10000;

import java.util.ArrayList;

public class DiceRoller {
	// dice roll controller
	public ArrayList<Integer> diceHolder = new ArrayList<Integer>();

	public void dieRoll(int numDice) {
		diceHolder.clear();
		for (int i = 0; i < numDice; i++) {
			int dice = (int) (Math.random() * 6) + 1;
			diceHolder.add(dice);
		}
		System.out.println("DICE: " + diceHolder);
	}

}
