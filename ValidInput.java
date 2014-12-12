import java.util.*;
import java.io.*;

public class ValidInput {
	
	private static String suspect;
	private static String room;
	private static String weapon;
	private static String direction;
	private static String map;
	private static boolean suspectValidAsGuess;
	private static boolean suspectValid;
	private static boolean roomValidAsGuess;
	private static boolean roomValid;
	private static boolean weaponValidAsGuess;
	private static boolean weaponValid;
	private static boolean directionValid;
	private static boolean mapValid;

	public ValidInput() {

	}

	public static void isSuspectValidAsGuess(String s) {
		suspect = s;
		if (suspect.equals("Miss Scarlet") || suspect.equals("Colonel Mustard") || suspect.equals("Mrs. White")
		|| suspect.equals("Reverend Green") || suspect.equals("Mrs. Peacock") || suspect.equals("Professor Plum")) {
			suspectValidAsGuess = true;
		} else {
			ErrorMessage.inputInvalid();
			ErrorMessage.inputProper();
			ErrorMessage.inputValidList("'Miss Scarlet', 'Colonel Mustard', 'Mrs. White', 'Reverend Green', 'Mrs. Peacock', 'Professor Plum'");
			ErrorMessage.skipLine();
			suspectValidAsGuess = false;
		}
	}

	public static void isSuspectValid(String s) {
		suspect = s;
		if (suspect.equals("Miss Scarlet") || suspect.equals("Colonel Mustard") || suspect.equals("Mrs. White")
		|| suspect.equals("Reverend Green") || suspect.equals("Mrs. Peacock") || suspect.equals("Professor Plum")) {
			suspectValid = true;
		} else {
			ErrorMessage.inputInvalid();
			ErrorMessage.inputProper();
			ErrorMessage.inputValidList("'Miss Scarlet', 'Colonel Mustard', 'Mrs. White', 'Reverend Green', 'Mrs. Peacock', 'Professor Plum'");
			ErrorMessage.skipLine();
			suspectValid = false;
		}
	}

	public static void isRoomValidAsGuess(String r) {
		room = r;
		if (room.equals("kitchen") || room.equals("ballroom") || room.equals("conservatory")
		|| room.equals("billiardroom") || room.equals("library") || room.equals("study") 
		|| room.equals("hall") || room.equals("lounge") || room.equals("diningroom")) {
			roomValidAsGuess = true;
		} else {
			ErrorMessage.inputInvalid();
			ErrorMessage.inputProper();
			ErrorMessage.inputValidList("'kitchen', 'ballroom', 'conservatory', 'billiardroom', 'library', 'study', 'lounge', 'hall', 'diningroom'");
			ErrorMessage.skipLine();
			roomValidAsGuess = false;
		}
	}

	public static void isRoomValid(String r) {
		room = r;
		if (room.equals("kitchen") || room.equals("ballroom") || room.equals("conservatory")
		|| room.equals("billiardroom") || room.equals("library") || room.equals("study") 
		|| room.equals("hall") || room.equals("lounge") || room.equals("diningroom") 
		|| room.equals("outside") || room.equals("corridor")) {
			roomValid = true;
		} else {
			ErrorMessage.inputInvalid();
			ErrorMessage.inputProper();
			ErrorMessage.inputValidList("'outside', 'corridor', 'kitchen', 'ballroom', 'conservatory', 'billiardroom', 'library', 'study', 'lounge', 'hall', 'diningroom'");
			ErrorMessage.skipLine();
			roomValid = false;
		}
	}

	public static void isWeaponValidAsGuess(String w) {
		weapon = w;
		if (weapon.equals("candlestick") || weapon.equals("knife") || weapon.equals("leadpipe") 
		|| weapon.equals("revolver") || weapon.equals("rope") || weapon.equals("wrench")) {
			weaponValidAsGuess = true;
		} else {
			ErrorMessage.inputInvalid();
			ErrorMessage.inputProper();
			ErrorMessage.inputValidList("'candlestick', 'knife', 'leadpipe', 'revolver', 'rope', 'wrench'");
			ErrorMessage.skipLine();
			weaponValidAsGuess = false;
		}
	}

	public static void isWeaponValid(String w) {
		weapon = w;
		if (weapon.equals("candlestick") || weapon.equals("knife") || weapon.equals("leadpipe") 
		|| weapon.equals("revolver") || weapon.equals("rope") || weapon.equals("wrench")) {
			weaponValid = true;
		} else {
			ErrorMessage.inputInvalid();
			ErrorMessage.inputProper();
			ErrorMessage.inputValidList("'candlestick', 'knife', 'leadpipe', 'revolver', 'rope', 'wrench'");
			ErrorMessage.skipLine();
			weaponValid = false;
		}
	}

	public static void isDirectionValid(String d) {
		direction = d;
		if (direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")) {
			directionValid = true;
		} else {
			ErrorMessage.inputInvalid();
			ErrorMessage.inputProper();
			ErrorMessage.inputValidList("'north', 'south', 'west', 'east'");
			ErrorMessage.skipLine();
			directionValid = false;
		}
	}

	public static void isMapValid(String m) {
		map = m;
		if (map.equals("map")) {
			mapValid = true;
		} else {
			ErrorMessage.inputInvalid();
			ErrorMessage.inputProper();
			ErrorMessage.inputValidList("'map'");
			ErrorMessage.skipLine();
			mapValid = false;
		}
	}

	public static boolean suspectValidAsGuess() {
		return suspectValidAsGuess;
	}

	public static boolean suspectValid() {
		return suspectValid;
	}

	public static boolean roomValidAsGuess() {
		return roomValidAsGuess;
	}

	public static boolean roomValid() {
		return roomValid;
	}

	public static boolean weaponValidAsGuess() {
		return weaponValidAsGuess;
	}

	public static boolean weaponValid() {
		return weaponValid;
	}

	public static boolean directionValid() {
		return directionValid;
	}

	public static boolean mapValid() {
		return mapValid;
	}

	public static void resetSuspectValidAsGuess() {
		suspectValidAsGuess = false;
	}

	public static void resetSuspectValid() {
		suspectValid = false;
	}

	public static void resetRoomValidAsGuess() {
		roomValidAsGuess = false;
	}

	public static void resetRoomValid() {
		roomValid = false;
	}

	public static void resetWeaponValidAsGuess() {
		weaponValidAsGuess = false;
	}

	public static void resetWeaponValid() {
		weaponValid = false;
	}

	public static void resetDirectionValid() {
		directionValid = false;
	}

	public static void resetMapValid() {
		mapValid = false;
	}
}