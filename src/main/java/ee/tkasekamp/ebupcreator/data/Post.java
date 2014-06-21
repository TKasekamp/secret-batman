package ee.tkasekamp.ebupcreator.data;

public class Post {
	private String postDate;
	private String postTime;
	private String postID;
	private String postLink;
	private String userName;
	private String content;

	public Post() {
		super();
	}

	public Post(String postDate, String postTime, String postID,
			String postLink, String userName, String content) {
		super();
		this.postDate = postDate;
		this.postTime = postTime;
		this.postID = postID;
		this.postLink = postLink;
		this.userName = userName;
		this.content = content;
	}

	public String getPostDate() {
		return postDate;
	}

	public String getPostTime() {
		return postTime;
	}

	public String getPostID() {
		return postID;
	}

	public String getPostLink() {
		return postLink;
	}

	public String getUserName() {
		return userName;
	}

	public String getContent() {
		return content;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public void setPostLink(String postLink) {
		this.postLink = postLink;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Post [postDate=" + postDate + ", postTime=" + postTime
				+ ", postID=" + postID + ", postLink=" + postLink
				+ ", userName=" + userName + ", content=" + content + "]";
	}
}
