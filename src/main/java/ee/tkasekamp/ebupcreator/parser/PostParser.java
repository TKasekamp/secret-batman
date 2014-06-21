package ee.tkasekamp.ebupcreator.parser;

import java.nio.charset.Charset;

import nl.siegmann.epublib.domain.Resource;

import org.jsoup.nodes.Element;

public class PostParser {
	private final Charset utf8 = Charset.forName("UTF8");

	public Resource postParser(Element post) {
		String href = post.getElementsByClass("postcounter").get(0).text()
				+ ".html";
		byte[] a = getHtmlDocForContent(post.getElementsByClass("content").get(0).html(),
				post.getElementsByClass("postcounter").get(0).text(), null);
		return new Resource(a, href);

	}

	public Resource getHtmlForContentRes(String content, String contentTitle,
			final String url) {
		String href = String.format("%s.html", contentTitle);
		return new Resource(this.getHtmlDocForContent(content, contentTitle,
				url), href);
	}

	public byte[] getHtmlDocForContent(String content, String contentTitle,
			String url) {
		String doc = String
				.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
						+ "<!DOCTYPE html\n"
						+ "        PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n"
						+ "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
						+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n"
						+ "<head>\n"
						+ "    <link rel=\"stylesheet\" href=\"styles.css\" type=\"text/css\" /> "
						+ "    <title>%s</title>\n" + "</head>\n"
						+ "<body>%s</body>" + "</html>", contentTitle, content);
		return doc.getBytes(utf8);
	}
}
