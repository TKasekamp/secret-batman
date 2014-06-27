package ee.tkasekamp.ebupcreator.data;

public class Post {
	private String date;
	private String time;
	private String postCount;
	private String postLink;
	private String userName;
	private String content;

	public Post() {
		super();
	}

	public Post(String date, String time, String postCount, String postLink,
			String userName, String content) {
		super();
		this.date = date;
		this.time = time;
		this.postCount = postCount;
		this.postLink = postLink;
		this.userName = userName;
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPostCount() {
		return postCount;
	}

	public void setPostCount(String postCount) {
		this.postCount = postCount;
	}

	public String getPostLink() {
		return postLink;
	}

	public void setPostLink(String postLink) {
		this.postLink = postLink;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Post [date=" + date + ", time=" + time + ", postCount="
				+ postCount + ", postLink=" + postLink + ", userName="
				+ userName + ", content=" + content + "]";
	}

}
