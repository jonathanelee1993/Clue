import java.util.*;
import java.io.*;

public class Inventory {

	private static Map<String,Weapon> weapons = new HashMap<String,Weapon>();

	public Inventory() {
		
	}

	public static void add(String s, Weapon w) {
		weapons.put(s,w);
	}

	public static void remove(String s) {
		weapons.remove(s);
	}

	public static boolean empty() {
		if (weapons.size() == 0) {
			return true;
		}
		return false;
	}

	public static void listWeapons() {
		Set<String> set = weapons.keySet();
		for (String weapon : set) {
			System.out.println(weapon);
		}
	}

	public static boolean containsWeapon(String s) {
		if (weapons.containsKey(s)) {
			return true;
		}
		return false;
	}
}