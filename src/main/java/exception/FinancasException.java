package exception;

public class FinancasException extends Exception {

	private static final long serialVersionUID = -965537976728182832L;

	public FinancasException() {
		super();
	}

	public FinancasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public FinancasException(String message, Throwable cause) {
		super(message, cause);
	}

	public FinancasException(String message) {
		super(message);
	}

	public FinancasException(Throwable cause) {
		super(cause);
	}

}
