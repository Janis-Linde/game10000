package game10000;

import java.util.Scanner;

public class GameSetup {
	// get the number of players and set their names
	static Players[] playersArr;

	public void playerInfo() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of players: ");
		int numberOfPlayers = scanner.nextInt();
		scanner.nextLine();

		playersArr = new Players[numberOfPlayers];

		for (int i = 0; i < playersArr.length; i++) {

			System.out.println("Player " + (i + 1) + " Enter your name: ");
			String name = scanner.nextLine();

			Players player = new Players(name);
			playersArr[i] = player;
		}
		//scanner.close();
	}

}
