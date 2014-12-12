import java.util.*;
import java.io.*;

public class ErrorMessage {
	
	public ErrorMessage() {

	}

	public static void skipLine() {
		System.out.println("");
	}

	public static void noDoor() {
		System.out.println("There is no door in this direction. Please try going another direction.");
	}

	public static void invalidCommand() {
		System.out.println("I don't understand what you're trying to tell me.");
	}

	public static void commandInput() {
		System.out.println("Please input one of the valid commands in the proper format.");
	}

	public static void inputInvalid() {
		System.out.println("Your input was invalid.");
	}

	public static void inputProper() {
		System.out.println("Please input one of the valid inputs in the proper format.");
	}

	public static void inputValidList(String s) {
		System.out.println("Valid inputs include: " + s + ".");
	}

	public static void weaponExamine(String s) {
		System.out.println("You can't examine the " + s + " if you don't have it!");
	}

	public static void weaponGuess(String s) {
		System.out.println("You can't guess the " + s + " unless it is in your inventory!");
	}

	public static void noInput(String s) {
		System.out.println("Type this word alone to use this command: " + s + ".");
	}

	public static void makeGuess() {
		System.out.println("You must be in one of the main mine rooms of the mansion to make a guess.");
	}

	public static void exploreMansion() {
		System.out.println("Please explore the mansion and try using this command later.");
	}

	public static void needWeapon() {
		System.out.println("You can't make a guess if you don't have any weapons in your inventory!");
	}
}