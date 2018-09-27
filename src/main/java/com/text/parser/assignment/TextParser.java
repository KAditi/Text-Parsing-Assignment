package com.text.parser.assignment;

import java.lang.CharSequence;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Aditi Text parser class consists of method parseSequnece(CharSequence
 *         x) which accepts CharSequence and return list of token
 *
 */
public class TextParser {
	private final static Logger LOGGER = Logger.getLogger(TextParser.class.getName());

	/**
	 * This method parse input CharSequence into list of TextToken objects Any
	 * special character is considered as delimiter
	 * 
	 * @param inputSequence
	 * @return
	 * @throws Exception
	 */
	public List<TextToken> parseSequence(CharSequence inputSequence) throws Exception {
		StringBuffer strBuff = new StringBuffer();
		List<TextToken> listStr = new ArrayList<TextToken>();
		int j = 0;
		if (inputSequence == null) {
			throw new NullPointerException("Input sequemce is null");
		}
		if (inputSequence.toString().trim().length() == 0) {
			LOGGER.log(Level.INFO, "Input sequence is blank");
			return null;
		}
		if (inputSequence.toString().matches("^[a-zA-Z0-9]*$")) {
			TextToken textTokenObj = new TextToken(inputSequence.toString(), inputSequence.toString(), 0,
					inputSequence.toString().length() - 1);
			listStr.add(textTokenObj);
			return listStr;
		}
		for (int i = 0; i < inputSequence.length(); i++) {
			if (isAlphanumeric(inputSequence.charAt(i))) {
				strBuff.append(inputSequence.charAt(i));
				if (i == inputSequence.length() - 1) {
					if (strBuff.length() != 0) {
						TextToken textTokenObj = new TextToken(strBuff.toString(), inputSequence.toString(), i - 1,
								i - (strBuff.toString().length()));
						listStr.add(textTokenObj);
					}
					strBuff.setLength(0);
				}
			} else {
				if (strBuff.length() != 0) {
					TextToken textTokenObj = new TextToken(strBuff.toString(), inputSequence.toString(), i - 1,
							i - (strBuff.toString().length()));
					listStr.add(textTokenObj);
				}
				strBuff.setLength(0);

			}
		}

		return listStr;
	}

	/**
	 * This method return true if input character is alphanumeric
	 * 
	 * @param Character
	 * @return
	 */
	private boolean isAlphanumeric(Character ch) {
		boolean result = false;
		String pattern = "^[a-zA-Z0-9]*$";
		if (new Character(ch).toString().matches(pattern)) {
			result = true;
		}

		return result;
	}

	public static void main(String[] args) {
		TextParser obj = new TextParser();
		System.out.println("Enter the text:");
		Scanner in = new Scanner(System.in);
		List<TextToken> resultList;
		CharSequence inputSequence = in.nextLine();
		System.out.println(inputSequence);
		try {
			resultList = obj.parseSequence(inputSequence);
			if (resultList != null) {
				for (int i = 0; i < resultList.size(); i++)
					System.out.println(resultList.get(i).toString());
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}
}
