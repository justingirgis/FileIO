import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class InputHandler {
	private File file;
	private PrintWriter pw;
	private String filename;

	/**
	*	Default Constructor
	 */

	public InputHandler() {
		this("input.txt");
	}
	
	/**
	*	overloaded constructor that take in the filename
	*	@param filename
	*/
	public InputHandler(String filename) {
		this.filename = filename;
		file = new File(filename);
		//delete file if it exists
		if(file.exists()) {
			file.delete();
		}
		//create a new file and open a PrintWriter, terminate if exception occurs
		try {
			file.createNewFile();
			pw = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.out.println(filename + " could not be found or is read-only. Terminating program");
			pw.close();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Could not create " + filename + ". Terminating program.");
			pw.close();
			System.exit(0);
		}
	}
	
	/**
	* function store() checks to make sure input is valid
	* @param input string
	*/
	public void store(String input) {
		try {
			//check if input contains 4 fields and the second field is not empty
			if(input.split(";").length != 4 || input.split(";")[1].length() < 1) {
				throw new UnknownTransactionException("Input was incorrect.");
			}
			pw.println(input);
		} catch(UnknownTransactionException e) { // catches an exception
			System.out.println("Invalid entry. Should follow format <name>;<service>;<amount>;<date>");
		}
	}
	
	/**
	* Close pw
	*/
	public void close() {
		pw.close();
	}
	
	/**
	 * override toString()
	* @return String
	*/
	public String toString() {
		return "Input Handler: " + filename;
	}
}
