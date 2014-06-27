package ee.tkasekamp.ebupcreator;

import static org.junit.Assert.*;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;

import ee.tkasekamp.ebupcreator.data.Post;
import ee.tkasekamp.ebupcreator.data.Thread;
import ee.tkasekamp.ebupcreator.parser.PostParser;

public class ParseTest {
	private final String testpage = "C:/Users/Tonis/Desktop/Polandball inspired comics - Page 803.htm";
	Element contents;
	private PostParser parser;

	@Before
	public void setUp() {
		parser = new PostParser();
	}

	@Test
	public void test1() {
		Thread thread = parser.parseThread(testpage);
		Post post = thread.getPosts().get(0);

		String link = "http://forum.paradoxplaza.com/forum/showthread.php?466607-Polandball-inspired-comics&p=17602476&viewfull=1#post17602476";
		String date = "20-06-2014 17:48";
		assertEquals(date, post.getDate());
		assertEquals("17:48", post.getTime());
		assertEquals("#16041", post.getPostCount());
		assertEquals(link, post.getPostLink());
		assertEquals("AsdfeZxcas", post.getUserName());
		// Testing HTML content by string is way to much trouble
	}

	@Test
	public void test2() {
		Thread thread = parser.parseThread(testpage);
		assertEquals(testpage, thread.getLink());
		assertEquals("Polandball inspired comics - Page 803", thread.getName());
		assertEquals("AsdfeZxcas", thread.getCreator());
		assertEquals(16, thread.getPosts().size());
	}

}
