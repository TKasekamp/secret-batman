package ee.tkasekamp.ebupcreator;

import ee.tkasekamp.ebupcreator.parser.PostParser;
import ee.tkasekamp.ebupcreator.writer.Writer;
import ee.tkasekamp.ebupcreator.data.Thread;

public class App {
	static String testpage = "C:/Users/Tonis/Desktop/Polandball inspired comics - Page 803.htm";
	static PostParser parser = new PostParser();

	public static void main(String[] args) {
		Thread thread = parser.parseThread(testpage);

		Writer.writeBook(thread);
	}

}
