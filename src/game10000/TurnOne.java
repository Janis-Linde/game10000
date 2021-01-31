package game10000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class TurnOne {
	DiceRoller diceRoller = new DiceRoller();
	Scanner scanner = new Scanner(System.in);

	public Boolean endOfTurn = false;
	private int rollOrNot;

	
	public void doTurn(){
		System.out.println("***Press 1 to roll***");
		rollOrNot = scanner.nextInt();
		scanner.nextLine();
		
		if (rollOrNot == 1){
			startTurn();
		} else {
			endTurn();
		}
		
	}
		
	// default number of dice
	private int defaultNumDice = 5;
	private int numDice = defaultNumDice;
	
	public void startTurn(){
		while (true) {
			boolean endOfTurn = true;
			diceRoller.dieRoll(numDice);
			keepDice();
			System.out.println("***Press 1 to roll, 0 to end turn.***");
			rollOrNot = scanner.nextInt();
			scanner.nextLine();
			if (rollOrNot != 1) {
				endOfTurn = true;
				numDice = defaultNumDice;
			} else {
				endOfTurn = false;
			}
			if (endOfTurn) {
				break;
			}
		}
	}
	
	public void endTurn(){
		endOfTurn = true;
		rollOrNot = 0;
	}
	
	// keep selected dice and calculate temporary points

	private ArrayList<Integer> keptDiceHolder = new ArrayList<Integer>();
	private ArrayList<Integer> diceHolderToInt = new ArrayList<Integer>();
	public int tempPoints = 0;
	private ArrayList<Integer> testListFor5dice = new ArrayList<Integer>();
	
	
	private int keepDice(){
		System.out.println("Select dice to keep, separated by comma: ");
		String diceToKeep = scanner.nextLine();
		String[] dieKept = diceToKeep.split(",");
		int numberOfDieKept = dieKept.length;
		
		// set the number of dice to roll next time
		if (numDice - numberOfDieKept > 0){
			numDice = numDice - numberOfDieKept;
		} else {
			numDice = defaultNumDice;
		}
		
		// put kept dice numbers into ArrayList
		diceHolderToInt.clear();
		for (int i = 0; i < dieKept.length; i++) {
			diceHolderToInt.add(Integer.parseInt(dieKept[i]));
		}
		
		// if no dice are kept, end turn, else put selected dice in ArrayList
		keptDiceHolder.clear();
		if (diceHolderToInt.get(0)== 0){
			endTurn();
		} else {	
			for (int i = 0; i < dieKept.length; i++) {
				keptDiceHolder.add(diceRoller.diceHolder.get(diceHolderToInt.get(i) - 1));
			}
		}
		Collections.sort(keptDiceHolder);
		System.out.println("TEMP: kept die " + keptDiceHolder);

		
		// ------------------- Temporary point counter -----------------------
		
		// 1 die kept
		if (dieKept.length == 1) {
			
			if (keptDiceHolder.isEmpty()){
				tempPoints = 0;
				
			} else if (keptDiceHolder.get(0) == 1) {
				tempPoints = tempPoints + 100;

			} else if (keptDiceHolder.get(0) == 5) {
				tempPoints = tempPoints + 50;

			} else {
				tempPoints = 0;
			}
		
		// 2 dice kept
		} else if (dieKept.length == 2) {
			if (keptDiceHolder.get(0) == 1 && keptDiceHolder.get(1) == 1) {
				tempPoints = tempPoints + 200;

			} else if (keptDiceHolder.get(0) == 1 && keptDiceHolder.get(1) == 5) {
				tempPoints = tempPoints + 150;

			} else if (keptDiceHolder.get(0) == 5 && keptDiceHolder.get(1) == 5) {
				tempPoints = tempPoints + 100;

			} else {
				tempPoints = 0;
			}
			
		// 3 dice kept	
		} else if (dieKept.length == 3) {
			if (keptDiceHolder.get(0) == keptDiceHolder.get(1)
					&& keptDiceHolder.get(1) == keptDiceHolder.get(2)) {
				if (keptDiceHolder.get(0) == 1) {
					tempPoints = tempPoints + 300;

				} else {
					tempPoints = tempPoints + (keptDiceHolder.get(0) * 100);

				}

			} else if (keptDiceHolder.get(0) == 1 && keptDiceHolder.get(1) == 1
					&& keptDiceHolder.get(2) == 5) {
				tempPoints = tempPoints + 250;

			} else if (keptDiceHolder.get(0) == 1 && keptDiceHolder.get(1) == 5
					&& keptDiceHolder.get(2) == 5) {
				tempPoints = tempPoints + 200;

			} else {
				tempPoints = 0;
			}
			
		// 4 dice kept	
		} else if (dieKept.length == 4) {
			if (keptDiceHolder.get(0) == keptDiceHolder.get(1)
					&& keptDiceHolder.get(1) == keptDiceHolder.get(2)
					&& keptDiceHolder.get(2) == keptDiceHolder.get(3)) {
				tempPoints = tempPoints + 1000;

			} else if (keptDiceHolder.get(1) == keptDiceHolder.get(2)
					&& keptDiceHolder.get(3) == keptDiceHolder.get(2)
					&& keptDiceHolder.get(0) == 1) {
				tempPoints = tempPoints + (keptDiceHolder.get(1) * 100) + 100;

			}

			else if (keptDiceHolder.get(0) == keptDiceHolder.get(1)
					&& keptDiceHolder.get(1) == keptDiceHolder.get(2)
					&& keptDiceHolder.get(3) == 5) {
				tempPoints = tempPoints + (keptDiceHolder.get(0) * 100) + 50;

			} else if (keptDiceHolder.get(1) == keptDiceHolder.get(2)
					&& keptDiceHolder.get(2) == keptDiceHolder.get(3)
					&& keptDiceHolder.get(0) == 5) {
				tempPoints = tempPoints + (keptDiceHolder.get(1) * 100) + 50;

			} else if (keptDiceHolder.get(0) == keptDiceHolder.get(1)
					&& keptDiceHolder.get(2) == keptDiceHolder.get(3)) {
				tempPoints = tempPoints + 300;

			} else {
				tempPoints = 0;
			}
		}

		// 5 dice kept
		else if (dieKept.length == 5) {
			// sequence 1 - 5
			for (int i = 0; i < 5; i++) {
				testListFor5dice.add((i + 1));
			}
			if (keptDiceHolder.equals(testListFor5dice)) {
				tempPoints = tempPoints + 2500;
			
			// 4 equal
			} else if (keptDiceHolder.get(0) == keptDiceHolder.get(1)
					&& keptDiceHolder.get(1) == keptDiceHolder.get(2)
					&& keptDiceHolder.get(2) == keptDiceHolder.get(3)
					&& keptDiceHolder.get(4) == 5) {
				tempPoints = tempPoints + 1050;

			} else if (keptDiceHolder.get(1) == keptDiceHolder.get(2)
					&& keptDiceHolder.get(2) == keptDiceHolder.get(3)
					&& keptDiceHolder.get(3) == keptDiceHolder.get(4)
					&& keptDiceHolder.get(0) == 1) {
				tempPoints = tempPoints + 1100;

			} else if (keptDiceHolder.get(1) == keptDiceHolder.get(2)
					&& keptDiceHolder.get(2) == keptDiceHolder.get(3)
					&& keptDiceHolder.get(3) == keptDiceHolder.get(4)
					&& keptDiceHolder.get(0) == 5) {
				tempPoints = tempPoints + 1050;

			}
			// 3 equal
			else if (keptDiceHolder.get(0) == keptDiceHolder.get(1)
					&& keptDiceHolder.get(1) == keptDiceHolder.get(2)
					&& keptDiceHolder.get(3) == 5 && keptDiceHolder.get(4) == 5) {
				tempPoints = tempPoints + (keptDiceHolder.get(0) * 100) + 100;

			} else if (keptDiceHolder.get(1) == keptDiceHolder.get(2)
					&& keptDiceHolder.get(2) == keptDiceHolder.get(3)
					&& keptDiceHolder.get(0) == 1 && keptDiceHolder.get(4) == 5) {
				tempPoints = tempPoints + (keptDiceHolder.get(1) * 100) + 150;

			} else if (keptDiceHolder.get(2) == keptDiceHolder.get(3)
					&& keptDiceHolder.get(3) == keptDiceHolder.get(4)
					&& keptDiceHolder.get(0) == 1 && keptDiceHolder.get(1) == 1) {
				tempPoints = tempPoints + (keptDiceHolder.get(2) * 100) + 200;

			} else if (keptDiceHolder.get(2) == keptDiceHolder.get(3)
					&& keptDiceHolder.get(3) == keptDiceHolder.get(4)
					&& keptDiceHolder.get(0) == 1 && keptDiceHolder.get(1) == 5) {
				tempPoints = tempPoints + (keptDiceHolder.get(2) * 100) + 150;

			} else if (keptDiceHolder.get(2) == keptDiceHolder.get(3)
					&& keptDiceHolder.get(3) == keptDiceHolder.get(4)
					&& keptDiceHolder.get(0) == 5 && keptDiceHolder.get(1) == 5) {
				tempPoints = tempPoints + (keptDiceHolder.get(2) * 100) + 100;

			} else {
				tempPoints = 0;
			}
		}
		System.out.println("TEMP: Your temporary points: " + tempPoints);
		keptDiceHolder.clear();
		diceHolderToInt.clear();
		return tempPoints;
	}
	
}
