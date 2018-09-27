package com.text.parser.assignment;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestTextParser {

	@Test
	public void testTextParserTokenNuber() throws Exception {
		TextParser obj = new TextParser();
		List<TextToken> lst = new ArrayList<TextToken>();
		lst = obj.parseSequence("sdhf?dfsdf");
		assertEquals(2, lst.size());
	}

	@Test
	public void textBlankToken() throws Exception {
		TextParser obj = new TextParser();
		List<TextToken> lst = new ArrayList<TextToken>();
		lst = obj.parseSequence("      ");
		assertNull(lst);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testNullSequenceParseToken() throws Exception {
		thrown.expect(NullPointerException.class);
		TextParser obj = new TextParser();
		obj.parseSequence(null);

	}

	@Test
	public void testTextParserNoAphanumeric() throws Exception {
		TextParser obj = new TextParser();
		List<TextToken> lst = new ArrayList<TextToken>();
		lst = obj.parseSequence("?&$%");
		assertEquals(0, lst.size());
	}

	@Test
	public void testTextParserNoSpecialCharcter() throws Exception {
		TextParser obj = new TextParser();
		List<TextToken> lst = new ArrayList<TextToken>();
		lst = obj.parseSequence("jhdfskd64565GFGFGF");
		assertEquals(1, lst.size());
		assertEquals("jhdfskd64565GFGFGF", lst.get(0).getToken());
	}

	@Test
	public void testIsAplhaNumeric() {
		TextToken textToken = new TextToken("sdfsd6678", "sdfsd6678??", 0, 8);
		assertEquals("Aplphanumeric", textToken.isAlphanumeric(textToken.getToken()));
	}

	@Test
	public void testIsAplhabatic() {
		TextToken textToken = new TextToken("sdfsdADF", "sdfsdADF??", 0, 7);
		assertEquals("Alphabatical", textToken.isAlphanumeric(textToken.getToken()));
	}

	@Test
	public void testIsNumeric() {
		TextToken textToken = new TextToken("123", "sdfsdADF?123?", 9, 11);
		assertEquals("Numeric", textToken.isAlphanumeric(textToken.getToken()));
	}

}
