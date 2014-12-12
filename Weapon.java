import java.util.*;
import java.io.*;

public class Weapon {

	private String weapon;
	private Room location;
	private boolean wasPickedUp;

	public Weapon(String name) {
		weapon = name;
	}

	public String toString(Weapon w) {
		return weapon;
	}

	public Room getWeaponLocation() {
		return location;
	}

	public void pickedUp(Weapon w) {
		wasPickedUp = true;
	}

	public boolean inInventory() {
		if (wasPickedUp == true) {
			return true;
		}
		return false;
	}
}