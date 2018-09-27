package com.text.parser.assignment;

/**
 * @author Aditi This class object consists of token, input sequence , start &
 *         end index of token w.r.t. original sequence token : Parsed token
 *         inputSequence:
 *
 */
public final class TextToken {
	private String token;
	private String inputSequence;
	private int endIndex;
	private int startIndex;

	@Override
	public String toString() {
		return "TextToken [token=" + token + ", inputSequence=" + inputSequence + "]";
	}

	public TextToken(String token, String inputSequence, int endIndex, int startIndex) {
		super();
		this.token = token;
		this.inputSequence = inputSequence;
		this.endIndex = endIndex;
		this.startIndex = startIndex;
	}

	public String getToken() {
		return token;
	}

	public String getInputSequence() {
		return inputSequence;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public String isAlphanumeric(String inputToken) {
		if (inputToken.matches("^[0-9]*$"))
			return "Numeric";
		else if (inputToken.matches("^[A-Za-z]*$"))
			return "Alphabatical";
		else
			return "Aplphanumeric";
	}

}
