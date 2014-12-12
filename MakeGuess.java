import java.util.*;
import java.io.*;

public class MakeGuess {
	
	private static String suspect;
	private static String weapon;
	private static String room;
	private static boolean accusation = false;
	private static boolean guessMade = false;

	public MakeGuess() {

	}

	public static void analyzeGuess(String s, String w, String r) {
		suspect = CrimeScene.getMurdererAsString();
		room = CrimeScene.getRoomAsString();
		weapon = CrimeScene.getWeaponAsString();
		if (!(s.equals(suspect)) || !(r.equals(room)) || !(w.equals(weapon))) {
			if (!(s.equals(suspect)) && r.equals(room) && w.equals(weapon)) {
				suspect(s);
			} else if (!(r.equals(room)) && s.equals(suspect) && w.equals(weapon)) {
				room(r);
			} else if (!(w.equals(weapon)) && r.equals(room) && s.equals(suspect)) {
				weapon(w);
			} else if (!(s.equals(suspect)) && !(r.equals(room)) && w.equals(weapon)) {
				int num = (int)(Math.random()*6);
				if (num == 0 || num == 1 || num == 2) {
					suspect(s);
				} else if (num == 3 || num == 4 || num == 5) {
					room(r);
				}
			} else if (!(s.equals(suspect)) && !(w.equals(weapon)) && r.equals(room)) {
				int num = (int)(Math.random()*6);
				if (num == 0 || num == 1 || num == 2) {
					suspect(s);
				} else if (num == 3 || num == 4 || num == 5) {
					weapon(w);
				}
			} else if (!(r.equals(room)) && !(w.equals(weapon)) && s.equals(suspect)) {
				int num = (int)(Math.random()*6);
				if (num == 0 || num == 1 || num ==2) {
					room(r);
				} else if (num == 3 || num == 4 || num == 5) {
					weapon(w);
				}
			} else if (!(s.equals(suspect)) && !(r.equals(room)) && !(w.equals(weapon))) {
				int num = (int)(Math.random()*6);
				if (num == 0 || num == 1) {
					suspect(s);
				} else if (num == 2 || num == 3) {
					room(r);
				} else if (num == 4 || num == 5) {
					weapon(w);
				}
			}
		} else if (s.equals(suspect) && r.equals(room) && w.equals(weapon)) {
			System.out.println("Your intuition tells you that you may now know exactly what happened on the night of the murder...");
			System.out.println("");
		}
	}

	public static void suspect(String s) {
		String suspect = s;
		System.out.println("You have deduced that " + suspect + " is not the murderer.");
		System.out.println("");
	}

	public static void weapon(String w) {
		String weapon = w;
		System.out.println("You have deduced that the " + weapon + " was not used in the crime.");
		System.out.println("");
	}

	public static void room(String r) {
		String room = r;
		System.out.println("You have deduced that the murder did not occur in the " + room + ".");
		System.out.println("");
	}

	public static void isGuessCorrect(String suspect, String weapon, String room) {
		if (suspect.equals(CrimeScene.getMurdererAsString()) && room.equals(CrimeScene.getRoomAsString()) 
		&& weapon.equals(CrimeScene.getWeaponAsString())) {
			accusation = true;
			accusationCorrect();
		} else {
			accusation = false;
			accusationCorrect();
		}
	}

	public static boolean accusationCorrect() {
		if (accusation == true) {
			return true;
		} 
		return false;
	}

	public static boolean guessMade() {
		if (guessMade == true) {
			return true;
		}
		return false;
	}

	public static void crimeSolved() {
		if (accusationCorrect() == true) {
			System.out.println("Your guess was correct! Congratulations, you solved the mystery!");
			System.out.println("The correct answer was: " + CrimeScene.printAsString());
			System.out.println("");
			guessMade = true;
			guessMade();
			GameState.gameContinue();
		}
		else if (accusationCorrect() == false) {
			System.out.println("I'm very sorry, but your guess was incorrect.");
			System.out.println("The correct answer was: " + CrimeScene.printAsString());
			System.out.println("");
			guessMade = true;
			guessMade();
			GameState.gameContinue();
		} 
	}
}