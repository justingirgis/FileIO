import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OutputHandler {
	private String filename;
	private File file;
	private Scanner scanner;
	
	/**
	*	Default Constructor
	*/
	public OutputHandler() {
		this("input.txt");
	}
	/**
	*	overloaded constructor that includes exception catcher
	*	@param filename what the file name of what user input is to be read and computed
	*/
	public OutputHandler(String filename) {
		this.filename = filename;
		file = new File(filename);
		//terminate if input file does not exist
		if(!file.exists()) {
			System.out.println("Input file " + filename + " not found. Terminating program.");
			System.exit(0);
		}
		//Open the scanner to read the input file
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Input file " + filename + " not found. Terminating program.");
		}
	}
	

	/**
	* If file exists, then it stores info. Otherwise creates a new file
	*/
	public void store() {
		while(scanner.hasNextLine()) {
			//get line and extract data
			String line = scanner.nextLine();
			String name = line.split(";")[1] + ".txt";
			File tmp = new File(name);
			//create file if it doesn't already exist
			if(!tmp.exists()) {
				try {
					tmp.createNewFile();
				} catch (IOException e) {
					System.out.println("Could not create file " + name + ". Skipping it.");
					continue;
				}
			}
			//write to file if it does exist
			FileWriter fr = null;
			try {
				fr = new FileWriter(tmp, true);
				fr.write(line + "\n");
			} catch (IOException e) {
				System.out.println("Failed to open FileWriter. Skipping it.");
			} finally {
				try {
					fr.close();
				} catch (IOException e) {
					//error occurs if it tries to close FileWriter and it doesn't exist.
					//In this case it can just be ignored.
				}
			}
		}
	}
	/**
	* close the scanner
	*/
	public void close() {
		scanner.close();
	}
	/**
	* @return override toString
	*/
	public String toString() {
		return "OutputHandler: " + filename;
	}
}