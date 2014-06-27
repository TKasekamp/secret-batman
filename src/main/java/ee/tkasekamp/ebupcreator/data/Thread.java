package ee.tkasekamp.ebupcreator.data;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Thread {
	private String name;
	private String link;
	private String creator;
	private ArrayList<Post> posts;
	private Set<String> images;

	public Thread(String link) {
		this.link = link;
		posts = new ArrayList<>();
		images = new LinkedHashSet<String>();
	}

	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public ArrayList<Post> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Thread [name=" + name + ", link=" + link + ", creator="
				+ creator + ", posts=" + posts + "]";
	}
}
