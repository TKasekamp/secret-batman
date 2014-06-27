package ee.tkasekamp.ebupcreator.parser;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import ee.tkasekamp.ebupcreator.data.Post;
import ee.tkasekamp.ebupcreator.data.Thread;

public class PostParser {
//	private String firstPage;

	public PostParser() {
		super();
	}

	public Thread parseThread(String firstPage) {
//		this.firstPage = firstPage;

		Document doc = getDocument(firstPage);
		Element contents = getPosts(doc);

		Thread thread = new Thread(firstPage);

		for (Element content : contents.children()) {
			thread.getPosts().add(parsePost(content));
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

}
