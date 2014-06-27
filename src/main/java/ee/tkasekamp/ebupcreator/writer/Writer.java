package ee.tkasekamp.ebupcreator.writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Metadata;
import nl.siegmann.epublib.epub.EpubWriter;


import ee.tkasekamp.ebupcreator.data.Post;
import ee.tkasekamp.ebupcreator.data.Thread;

public class Writer {

	public static void writeBook(Thread thread) {
		// Create new Book
		Book book = new Book();

		addMetadata(thread, book);
		
		for (Post post : thread.getPosts()) {
			book.addSection(post.getPostCount(), ResourceCreator.getResource(post));
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
