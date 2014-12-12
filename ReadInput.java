import java.util.*;
import java.io.*;

public class ReadInput {

	private static String command;

	public ReadInput(String c) {
		command = c;
	}

	public static String processInput(String command) {
		String[] words = parseCommand(command);
		for (String word : words) {
			word = word.toLowerCase();
		}
		Action action = determineAction(words);
		return command;
	}

	public static String[] parseCommand(String command) {
		return command.split(" ");
	}

	public static Action determineAction(String[] words) {
		Action action = new Action(); 
		if (words[0].equals("go")) {
			try {
				String x = words[1];
				ValidInput.isDirectionValid(x);
				if (ValidInput.directionValid() == true) {
					Room room = GameState.getCurrentLocation().nextRoom(words[1]);
					if (room == null) {
						ErrorMessage.noDoor();
						ErrorMessage.skipLine();
					} else {
						action.setLocation(room);
						room.shortDescription(room);
						if (room.hasRoomBeenVisited() == false) {
							ErrorMessage.skipLine();
							String story = room.toString(room);
							String description = ReadStory.addText(story);
							System.out.println(description);
							room.roomHasBeenVisited();
						} else if (room.hasRoomBeenVisited() == true) {
							ErrorMessage.skipLine();
						}
						if (room.getWeapon(room) != null) {
							room.weaponList(room);
						}
					}
				} 
			} catch (Exception ex) {
				ErrorMessage.inputProper();
				ErrorMessage.inputValidList("'north', 'south', 'west', 'east'");
				ErrorMessage.skipLine();
			}
		}
		else if (words[0].equals("take")) {
			try {
				String x = words[1];
				ValidInput.isWeaponValid(x);
				if (ValidInput.weaponValid() == true) {
					Room location = GameState.getCurrentLocation();
					Weapon weapon = location.getWeapon(location);
					if (weapon == null || !(weapon.toString(weapon).equals(x))) {
						System.out.println("There is no " + x + " in this room.");
						ErrorMessage.skipLine();
					} else {
						location.removeWeapon(location);
						String string = weapon.toString(weapon);
						action.grabWeapon(string, weapon);
						weapon.pickedUp(weapon);
						System.out.println("The " + x + " is now in your inventory.");
						ErrorMessage.skipLine();
					}
				} 
			} catch (Exception ex) {
				ErrorMessage.inputProper();
				ErrorMessage.inputValidList("'candlestick', 'knife', 'leadpipe', 'revolver', 'rope', 'wrench'");
				ErrorMessage.skipLine();
			}
		}
		else if (words[0].equals("examine")) {
			//Weapon weapon = Inventory.getWeapon();
			try {
				String x = words[1];
				ValidInput.isWeaponValid(x);
				if (ValidInput.weaponValid() == true) {
					if (Inventory.containsWeapon(x)) {
						String description = ReadStory.addText(x);
						System.out.println(description);
					} else {
						ErrorMessage.weaponExamine(x);
						ErrorMessage.skipLine();
					}
				} 
			} catch (Exception ex) {
				ErrorMessage.inputProper();
				ErrorMessage.inputValidList("'candlestick', 'knife', 'leadpipe', 'revolver', 'rope', 'wrench'");
				ErrorMessage.skipLine();
			}	
		}
		else if (words[0].equals("look")) {
			//Room location = GameState.getCurrentLocation();
			try {
				String x = words[1];
				ErrorMessage.noInput("'look'");
				ErrorMessage.skipLine();
			} catch (Exception ex) {
				Room room = GameState.getCurrentLocation();
				room.shortDescription(room);
				ErrorMessage.skipLine();
				String string = room.toString(room);
				String description = ReadStory.addText(string);
				System.out.println(description);
				if (room.getWeapon(room) != null) {
					room.weaponList(room);
				}
			}
		}
		else if (words[0].equals("read")) {
			try {
				String x = words[1];
				ValidInput.isMapValid(x);
				if (ValidInput.mapValid() == true) {
					String description = ReadStory.addText(x);
					System.out.println(description);
				} 
			} catch (Exception ex) {
				ErrorMessage.inputProper();
				ErrorMessage.inputValidList("'map'");
				ErrorMessage.skipLine();
			}
		}
		else if (words[0].equals("guess")) {
			try {
				String x = words[1];
				ErrorMessage.noInput("'guess'");
				ErrorMessage.skipLine();
			} catch (Exception ex) {
				Room location = GameState.getCurrentLocation();
				String string = location.toString(location);
				if (string.equals("outside") || string.equals("corridor")) {
					ErrorMessage.makeGuess();
					ErrorMessage.exploreMansion();
					ErrorMessage.skipLine();
				} else {
					if (Inventory.empty()) {
						ErrorMessage.needWeapon();
						ErrorMessage.exploreMansion();
						ErrorMessage.skipLine();
					} else {
						action.makeAGuess();
					}
				}
			}
		}
		else if (words[0].equals("solve")) {
			try {
				String x = words[1];
				ErrorMessage.noInput("'solve'");
				ErrorMessage.skipLine();
			} catch (Exception ex) {
				action.finalGuess();
			}
		} else if (words[0].equals("help")) {
			try {
				String x = words[1];
				ErrorMessage.noInput("'help'");
				ErrorMessage.skipLine();
			} catch (Exception ex) {
				String x = words[0];
				String description = ReadStory.addText(x);
				System.out.println(description);
			}
		} else if (words[0].equals("inventory")) {
			try {
				String x = words[1];
				ErrorMessage.noInput("'inventory'");
				ErrorMessage.skipLine();
			} catch (Exception ex) {
				if (Inventory.empty() == true) {
					System.out.println("Your inventory is empty.");
					ErrorMessage.skipLine();
				} else {
					System.out.println("These are the items that are in your inventory: ");
					Inventory.listWeapons();
					ErrorMessage.skipLine();
				}
			}
		} else if (words[0].equals("quit")) {
			try {
				String x = words[1];
				ErrorMessage.noInput("'quit'");
				ErrorMessage.skipLine();
			} catch (Exception ex) {
				action.quitGame(words[0]);
			}
		} 
		else {
			ErrorMessage.invalidCommand();
			ErrorMessage.commandInput();
			ErrorMessage.skipLine();
		}
		return action;
	}
}