package ee.tkasekamp.ebupcreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Metadata;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.domain.TOCReference;
import nl.siegmann.epublib.epub.EpubWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.java.accessibility.util.Translator;

import ee.tkasekamp.ebupcreator.parser.PostParser;

public class App {
	static String testpage = "C:/Users/Tonis/Desktop/Polandball inspired comics - Page 803.htm";
	static Book book;
	static PostParser parser = new PostParser();

	public static void main(String[] args) {
		File input = new File(testpage);
		Document doc = null;
		try {
			doc = Jsoup.parse(input, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		epubTest();

		Element contents = doc.getElementById("posts");
		int i = 0;
		for (Element content : contents.children()) {
			book.addSection("Post " + i++, parser.postParser(content));
		}
		try {
			epubWriter();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void epubTest() {
		try {
			// Create new Book
			book = new Book();
			Metadata metadata = book.getMetadata();
			// Set the title
			metadata.addTitle("Epublib test book 1");

			// Add an Author
			metadata.addAuthor(new Author("Joe", "Tester"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void epubWriter() throws FileNotFoundException, IOException {
		// Create EpubWriter
		EpubWriter epubWriter = new EpubWriter();

		// Write the Book as Epub
		epubWriter.write(book, new FileOutputStream("test1_book1.epub"));
	}
}
