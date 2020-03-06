/**
 * Justin Girgis
 * Serenity Brown
 * CECS 277
 * File IO Project
 */

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		InputHandler ih = new InputHandler(); // create a new InputHandler
		System.out.println(ih);
		System.out.println("Insert transactions. Enter \"exit\" to stop.");
		Scanner scanner = new Scanner(System.in);
		String line;
		System.out.print(":");
		while(!((line = scanner.nextLine()).equals("exit"))) { // if "exit" then quit
			ih.store(line);
			System.out.print(">");
		}
		scanner.close();
		ih.close();
		OutputHandler oh = new OutputHandler();
		System.out.println(oh);
		oh.store();
		oh.close();
		System.out.println("done");
	}
}
