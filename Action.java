import java.util.*;
import java.io.*;

public class Action {
	
	private Room location;
	private String suspect;
	private String room;
	private String weapon;
	private boolean endGame = false;

	public Action() {

	}

	public Room getLocation() {
		return location;
	}

	public void setLocation(Room l) {
		GameState.setLocation(l);
		location = l;
	}

	public void grabWeapon(String s, Weapon w) {
		Inventory.add(s,w);
	}

	public void makeAGuess() {
		Room location = GameState.getCurrentLocation();
		String room = location.toString(location);
		ValidInput.resetSuspectValidAsGuess();
		ValidInput.resetWeaponValidAsGuess();
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Please input the name of the person who you suspect is the murderer.");
		while (ValidInput.suspectValidAsGuess() == false) {
			suspect = sc1.nextLine();
			ValidInput.isSuspectValidAsGuess(suspect);
		}
		System.out.println("Please input the weapon that you think this person used. You may only guess a weapon that is in your inventory.");
		while (ValidInput.weaponValidAsGuess() == false || Inventory.containsWeapon(weapon) == false) {
			weapon = sc2.nextLine().toLowerCase();
			if (!(Inventory.containsWeapon(weapon))) {
				ValidInput.isWeaponValidAsGuess(weapon);
				if (ValidInput.weaponValidAsGuess() == true) {
					ErrorMessage.weaponGuess(weapon);
					ErrorMessage.skipLine();
				}
			} else {
				ValidInput.isWeaponValidAsGuess(weapon);
			}
		}
		System.out.println("By default, you must guess that the murder took place at your current location, which is the " + room + ".");
		MakeGuess.analyzeGuess(suspect, weapon, room);
	}

	public void finalGuess() {
		ValidInput.resetSuspectValidAsGuess();
		ValidInput.resetWeaponValidAsGuess();
		ValidInput.resetRoomValidAsGuess();
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Please input the name of the person you are accusing of murder.");
		while (ValidInput.suspectValidAsGuess() == false) {
			suspect = sc1.nextLine();
			ValidInput.isSuspectValidAsGuess(suspect);
		}
		System.out.println("Please input the name of the weapon you believe that person used in the murder.");
		while (ValidInput.weaponValidAsGuess() == false) {
			weapon = sc2.nextLine().toLowerCase();
			ValidInput.isWeaponValidAsGuess(weapon);
		}
		System.out.println("Please input the name of the room you believe the murder occured in.");
		while (ValidInput.roomValidAsGuess() == false) {
			room = sc3.nextLine().toLowerCase();
			ValidInput.isRoomValidAsGuess(room);
		}
		MakeGuess.isGuessCorrect(suspect, weapon, room);
		MakeGuess.crimeSolved();
	}

	public void quitGame(String s) {
		if (s.equals("quit")) {
			endGame = true;
		} else {
			endGame = false;
		}
	}

	public boolean endGame() {
		return endGame;
	}
}