import java.util.*;
import java.io.*;

public class Clue {

	public Clue() {
		createGame();
	}

	public static void main(String[] args) {
		Clue clue = new Clue();
		System.out.println("Hello there! Thank you for playing this Clue Text Adventure. Your game will begin now:");
		String intro = "intro";
		String description = ReadStory.addText(intro);
		System.out.println(description);
		System.out.println("Input 'help' for a complete guide of the game rules and how to use the game commands.");
		System.out.println("");
		Scanner input = new Scanner(System.in);
		String command = "";
		while (!(command.toLowerCase().equals("quit")) && GameState.gameContinue() == true) {
			command = input.nextLine();
			command = command.toLowerCase();
			String printout = ReadInput.processInput(command);
		}
		System.out.println("Thank you for playing Clue.");
	}

	public void createGame() {
		Room outside = new Room("outside");
		Room corridor = new Room("corridor");
		Room kitchen = new Room("kitchen");
		Room ballroom = new Room("ballroom");
		Room conservatory = new Room("conservatory");
		Room billiardroom = new Room("billiardroom");
		Room library = new Room("library");
		Room study = new Room("study");
		Room lounge = new Room("lounge");
		Room hall = new Room("hall");
		Room diningroom = new Room("diningroom");

		Weapon candlestick = new Weapon("candlestick");
		Weapon knife = new Weapon("knife");
		Weapon leadpipe = new Weapon("leadpipe");
		Weapon revolver = new Weapon("revolver");
		Weapon rope = new Weapon("rope");
		Weapon wrench = new Weapon("wrench");

		outside.exits(corridor, null, null, null);
		corridor.exits(hall, outside, null, null);
		kitchen.exits(null, billiardroom, null, ballroom);
		ballroom.exits(null, library, kitchen, conservatory);
		conservatory.exits(null, study, ballroom, null);
		billiardroom.exits(kitchen, lounge, null, library);
		library.exits(ballroom, hall, billiardroom, study);
		study.exits(conservatory, diningroom, library, null);
		lounge.exits(billiardroom, null, null, hall);
		hall.exits(library, corridor, lounge, diningroom);
		diningroom.exits(study, null, hall, null);

		Set<Room> rooms = new HashSet<Room>();
		rooms.add(kitchen);
		rooms.add(ballroom);
		rooms.add(conservatory);
		rooms.add(billiardroom);
		rooms.add(library);
		rooms.add(study);
		rooms.add(lounge);
		rooms.add(hall);
		rooms.add(diningroom);

		Set<Weapon> weapons = new HashSet<Weapon>();
		weapons.add(candlestick);
		weapons.add(knife);
		weapons.add(leadpipe);
		weapons.add(revolver);
		weapons.add(rope);
		weapons.add(wrench);

		Random rand = new Random();
		Set<Integer> set = new HashSet<Integer>();
		while (set.size() < 6) {
		    set.add(rand.nextInt(9));
		}
		Integer[] nums = set.toArray(new Integer[0]);

		int i = 0;
		for (Weapon weapon : weapons) {
			int num = nums[i];
			if (num == 0) {
				kitchen.weapons(kitchen, weapon);
			} else if (num == 1) {
				ballroom.weapons(ballroom, weapon);
			} else if (num == 2) {
				conservatory.weapons(conservatory, weapon);
			} else if (num == 3) {
				billiardroom.weapons(billiardroom, weapon);
			} else if (num == 4) {
				library.weapons(library, weapon);
			} else if (num == 5) {
				study.weapons(study, weapon);
			} else if (num == 6) {
				lounge.weapons(lounge, weapon);
			} else if (num == 7) {
				hall.weapons(hall, weapon);
			} else if (num == 8) {
				diningroom.weapons(diningroom, weapon);
			}
			i++;
		}

		GameState.setLocation(outside);
	}
}