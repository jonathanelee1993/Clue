import java.util.*;
import java.io.*;

public class ReadStory {

	private static String filename;
	private static Room outside;
	private static Room corridor;
	private static Room kitchen;
	private static Room ballroom;
	private static Room conservatory;
	private static Room billiardroom;
	private static Room library;
	private static Room study;
	private static Room hall;
	private static Room lounge;
	private static Room diningroom;

	public ReadStory() {
		
	}

	public static String addText(String object) {
		String space = "";
		if (object.equals("outside")) {
			filename = "outside.txt";
			createText(filename);
		} else if (object.equals("intro")) {
			filename = "intro.txt";
			createText(filename);
		} else if (object.equals("corridor")) {
			filename = "corridor.txt";
			createText(filename);
		} else if (object.equals("kitchen")) {
			filename = "kitchen.txt";
			createText(filename);
		} else if (object.equals("ballroom")) {
			filename = "ballroom.txt";
			createText(filename);
		} else if (object.equals("conservatory")) {
			filename = "conservatory.txt";
			createText(filename);
		} else if (object.equals("billiardroom")) {
			filename = "billiardroom.txt";
			createText(filename);
		} else if (object.equals("library")) {
			filename = "library.txt";
			createText(filename);
		} else if (object.equals("study")) {
			filename = "study.txt";
			createText(filename);
		} else if (object.equals("hall")) {
			filename = "hall.txt";
			createText(filename);
		} else if (object.equals("lounge")) {
			filename = "lounge.txt";
			createText(filename);
		} else if (object.equals("diningroom")) {
			filename = "diningroom.txt";
			createText(filename);
		} else if (object.equals("candlestick")) {
			filename = "candlestick.txt";
			createText(filename);
		} else if (object.equals("knife")) {
			filename = "knife.txt";
			createText(filename);
		} else if (object.equals("leadpipe")) {
			filename = "leadpipe.txt";
			createText(filename);
		} else if (object.equals("revolver")) {
			filename = "revolver.txt";
			createText(filename);
		} else if (object.equals("rope")) {
			filename = "rope.txt";
			createText(filename);
		} else if (object.equals("map")) {
			filename = "map.txt";
			createText(filename);
		} else if (object.equals("help")) {
			filename = "help.txt";
			createText(filename);
		} else if (object.equals("suspect")) {
			filename = "suspect.txt";
			createText(filename);
		} else if (object.equals("weapon")) {
			filename = "weapon.txt";
			createText(filename);
		} else if (object.equals("room")) {
			filename = "room.txt";
			createText(filename);
		} else if (object.equals("wrench")) {
			filename = "wrench.txt";
			createText(filename);
		} 
		return space;
	}

	public static void createText(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while(true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
			br.close();
		}
		catch (IOException ex) {}
	}
}