package ee.tkasekamp.ebupcreator.parser;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ee.tkasekamp.ebupcreator.data.Post;
import ee.tkasekamp.ebupcreator.data.Thread;

public class PostParser {
	protected final Logger log = LoggerFactory.getLogger(getClass());

	public PostParser() {
		super();
	}

	public Thread parseThread(String firstPage) {
		Document doc = getDocument(firstPage);
		Element contents = getPosts(doc);

		Thread thread = new Thread(firstPage);

		for (Element content : contents.children()) {
			thread.getPosts().add(parsePost(content));
			getImages(content, thread);
		}

		thread.setCreator(thread.getPosts().get(0).getUserName());
		thread.setName(doc.title());

		return thread;
	}

	private Element getPosts(Document doc) {
		Element contents = doc.getElementById("posts");
		return contents;
	}

	private Document getDocument(String page) {
		File input = new File(page);
		Document doc = null;
		try {
			doc = Jsoup.parse(input, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

	private Post parsePost(Element el) {
		// TODO something about timezones
		String date = el.getElementsByClass("date").first().text();
		String time = el.getElementsByClass("time").first().html();
		String postCount = el.getElementsByClass("postcounter").first().text();
		String postLink = el.getElementsByClass("postcounter").first()
				.attr("href");
		String userName = el.getElementsByClass("username").first().text();
		String content = el.getElementsByClass("content").first().outerHtml();
		Post post = new Post(date, time, postCount, postLink, userName, content);
		return post;

	}

	private void getImages(Element el, Thread thread) {
		for (Element img : el.getElementsByClass("content").first()
				.getElementsByTag("img")) {
			String link = img.attr("src");
			thread.getImages().add(link);
		}
	}

}
