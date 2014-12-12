public class CrimeScene { 
	private static final int murderer = (int)(Math.random()*6);
	private static final int room = (int)(Math.random()*9);
	private static final int weapon = (int)(Math.random()*6);

	public CrimeScene() {

	}

	public static String getMurdererAsString() {
		if (murderer == 0) {
			return "Miss Scarlet";
		}
		else if (murderer == 1) {
			return "Colonel Mustard";
		}
		else if (murderer == 2) {
			return "Mrs. White";
		}
		else if (murderer == 3) {
			return "Reverend Green";
		}
		else if (murderer == 4) {
			return "Mrs. Peacock";
		}
		else {
			return "Professor Plum";
		}
	}

	public static String getRoomAsString() {
		if (room == 0) {
			return "kitchen";
		}
		else if (room == 1) {
			return "ballroom";
		}
		else if (room == 2) {
			return "conservatory";
		}
		else if (room == 3) {
			return "billiardroom";
		}
		else if (room == 4) {
			return "library";
		}
		else if (room == 5) {
			return "study";
		}
		else if (room == 6) {
			return "hall";
		}
		else if (room == 7) {
			return "lounge";
		}
		else {
			return "diningroom";
		}
	}

	public static String getWeaponAsString() {
		if (weapon == 0) {
			return "candlestick";
		}
		else if (weapon == 1) {
			return "knife";
		}
		else if (weapon == 2) {
			return "leadpipe";
		}
		else if (weapon == 3) {
			return "revolver";
		}
		else if (weapon == 4) {
			return "rope";
		}
		else {
			return "wrench";
		}
	}

	public static String printAsString() {
		return getMurdererAsString() + " in the " + getRoomAsString() + " using the " + getWeaponAsString();
	}
}