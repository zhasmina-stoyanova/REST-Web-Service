package model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The class is used to contain the structure of a comment object.
 *
 * @author Zhasmina Stoyanova
 * @version 1.0
 */
@XmlRootElement
public class Comment {
	private int id;
	private String text;
	private int userId;
	private int commentedId;
	private boolean isPhoto;
	private Date dateCreated;
	private int rating;

	public Comment() {
	}

	public Comment(int id, String text, int userId, int commentedId, boolean isPhoto, Date dateCreated, int rating) {
		this.id = id;
		this.text = text;
		this.userId = userId;
		this.commentedId = commentedId;
		this.isPhoto = isPhoto;
		this.dateCreated = dateCreated;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCommentedId() {
		return commentedId;
	}

	public void setCommentedId(int commentedId) {
		this.commentedId = commentedId;
	}

	public boolean isPhoto() {
		return isPhoto;
	}

	public void setPhoto(boolean isPhoto) {
		this.isPhoto = isPhoto;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
