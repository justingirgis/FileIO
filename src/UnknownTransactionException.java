
public class UnknownTransactionException extends Exception{
	/**
	*	Default constructor
	*/
	public UnknownTransactionException() {
		super();
	}
	/**
	* @param message of the exception
	*/
	public UnknownTransactionException(String message) {
		super(message);
	}
	/**
	* overrides the toString()
	*/
	public String toString() {
		return "UnknownTransactionException class";
	}
}
