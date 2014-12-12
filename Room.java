import java.util.*;
import java.io.*;

public class Room {

	private String room;
	private String story;
	private Weapon weapon;
	private Map<String,Room> exits;
	private Map<Room,Weapon> weaponMap;
	private boolean wasVisited;

	public Room(String name) {
		room = name;
		exits = new HashMap<String,Room>();
		weaponMap = new HashMap<Room,Weapon>();
		wasVisited = false;
	}

	public String toString(Room r) {
		return room;
	}

	public void shortDescription(Room r) {
		String s = r.toString(r);
		if (s == "outside") {
			System.out.println("You are now " + s + ".");
		} else {
			System.out.println("You are now in the " + s + ".");
		}
	}

	public Weapon getWeapon(Room r) {
		return weaponMap.get(r);
	}

	public boolean roomEmpty(Room r) {
		if (getWeapon(r) == null) {
			return true;
		}
		return false;
	}

	public void weaponList(Room r) {
		weapon = weaponMap.get(r);
		String w = weapon.toString(weapon);
		System.out.println("In this room you see a " + w + ".");
		System.out.println("");
	}

	public void exits(Room north, Room south, Room west, Room east) {
		if (north != null) {
			exits.put("north",north);
		}
		if (south != null) {
			exits.put("south",south);
		}
		if (west != null) {
			exits.put("west",west);
		}
		if (east != null) {
			exits.put("east",east);
		}
	}

	public void weapons(Room r, Weapon w) {
		if (w != null) {
			weaponMap.put(r,w);
		}
	}

	public void removeWeapon(Room r) {
		weaponMap.remove(r);
	}

	public Room nextRoom(String direction) {
		return (Room)exits.get(direction);
	}

	public boolean hasRoomBeenVisited() {
		return wasVisited;
	}

	public void roomHasBeenVisited() {
		wasVisited = true;
	}

}
