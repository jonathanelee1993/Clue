import java.util.*;
import java.io.*;

public class GameState {

	private static Room location;
	private static Weapon weapon;
	private static Action action = new Action();
	private static Inventory inventory = new Inventory();


	public GameState() {

	}

	public static void setLocation(Room r) {
		location = r;
	}

	public static Room getCurrentLocation() {
		return location;
	}

	public static Inventory getInventory() {
		return inventory;
	}

	public static Weapon getWeapon() {
		return weapon;
	}

	public static Weapon weaponOwned(Weapon w) {
		weapon = w;
		return weapon;
	}

	public static boolean gameContinue() {
		if (MakeGuess.guessMade() == true || action.endGame() == true) {
			return false;
		} 
		return true;
	}
}