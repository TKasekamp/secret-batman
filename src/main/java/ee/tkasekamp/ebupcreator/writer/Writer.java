package ee.tkasekamp.ebupcreator.writer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Metadata;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;


import ee.tkasekamp.ebupcreator.data.Post;
import ee.tkasekamp.ebupcreator.data.Thread;

public class Writer {
	protected final static Logger log = LoggerFactory.getLogger(Writer.class);
	public static void writeBook(Thread thread) {
		// Create new Book
		Book book = new Book();

		addMetadata(thread, book);
		
		for (Post post : thread.getPosts()) {
			book.addSection(post.getPostCount(), ResourceCreator.getResource(post));
		}
		
		for (String name : thread.getImages()) {
			String link = name.replaceFirst("./", "C:/Users/Tonis/Desktop/");
//			int index = link.lastIndexOf("/");
//			String name = link.substring(index + 1, link.length());
			log.info(name + " : " + link);
			try {
				FileInputStream in = new FileInputStream(link);
				Resource res = new Resource(in, name);
				book.addResource(res);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			writeEpub(book);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void addMetadata(Thread thread, Book book) {
		Metadata metadata = book.getMetadata();
		// Set the title
		metadata.addTitle(thread.getName());

		// Add an Author
		metadata.addAuthor(new Author(thread.getCreator()));

	}

	private static void writeEpub(Book book) throws FileNotFoundException, IOException {
		// Create EpubWriter
		EpubWriter epubWriter = new EpubWriter();

		// Write the Book as Epub
		epubWriter.write(book, new FileOutputStream("test1_book1.epub"));
	}
}
