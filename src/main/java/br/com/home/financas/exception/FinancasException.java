package br.com.home.financas.exception;

public class FinancasException extends Exception {

	private static final long serialVersionUID = 4783647283480915492L;

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
