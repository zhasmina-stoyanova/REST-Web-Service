package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The class is used to store a static list of comments
 * and add manipulations and filtering with comment objects.
 *
 * @author Zhasmina Stoyanova
 * @version 1.0
 */
public class Comments {
	public static List<Comment> commentList = new ArrayList<Comment>();

	// initialize comments to start with some
	static {
		Comment comment1 = new Comment(1, "The mountain looks nice", 1, 2, true, new Date(), 0);
		Comment comment2 = new Comment(2, "The mountain is beautiful", 2, 2, true, new Date(), 0);
		Comment comment3 = new Comment(3, "The sea looks nice", 2, 1, true, new Date(), 0);
		Comment comment4 = new Comment(4, "The city is beautiful", 1, 3, true, new Date(), 0);
		Comment comment5 = new Comment(5, "I don't think the sea looks so nice", 1, 3, false, new Date(), 0);
		Comment comment6 = new Comment(6, "I don't agree", 2, 3, false, new Date(), 0);
		commentList.add(comment1);
		commentList.add(comment2);
		commentList.add(comment3);
		commentList.add(comment4);
		commentList.add(comment5);
		commentList.add(comment6);
	}

	public Comments() {

	}

	// get replies by commentId
	public List<Comment> getRepliesByCommentId(long commentId) {
		List<Comment> repliesByCommentId = new ArrayList<Comment>();
		for (int i = 0; i < commentList.size(); i++) {
			if (!commentList.get(i).isPhoto() && commentId == commentList.get(i).getCommentedId()) {
				System.out.println(commentList.get(i).getText());
				repliesByCommentId.add(commentList.get(i));
			}
		}
		return repliesByCommentId;
	}

	// get comments by userId
	public List<Comment> getCommentsByUserId(long userId) {
		List<Comment> commentsByUserList = new ArrayList<Comment>();
		for (int i = 0; i < commentList.size(); i++) {
			if (userId == commentList.get(i).getUserId()) {
				commentsByUserList.add(commentList.get(i));
			}
		}
		return commentsByUserList;
	}

	// get comments by photoId
	public List<Comment> getCommentsByPhotoId(long photoId) {
		List<Comment> commentsByPhotoList = new ArrayList<Comment>();
		for (int i = 0; i < commentList.size(); i++) {
			if (commentList.get(i).isPhoto() && photoId == commentList.get(i).getCommentedId()) {
				commentsByPhotoList.add(commentList.get(i));
			}
		}
		return commentsByPhotoList;
	}

	// add comment
	public Comment addComment(Comment comment) {
		Comment newComment = new Comment(commentList.size() + 1, comment.getText(), comment.getUserId(),
				comment.getCommentedId(), comment.isPhoto(), new Date(), 0);
		commentList.add(newComment);
		return comment;
	}

	// downvote comment
	public Comment downvoteComment(int commentId) {
		Comment updatedComment = null;
		for (int i = 0; i < commentList.size(); i++) {
			if (commentId == commentList.get(i).getId()) {
				int newRating = commentList.get(i).getRating() - 1;
				commentList.get(i).setRating(newRating);
				updatedComment =  commentList.get(i);
				break;
			}
		}
		return updatedComment;
	}
	
	// upvote comment
	public Comment upvoteComment(int commentId) {
		Comment updatedComment = null;
		for (int i = 0; i < commentList.size(); i++) {
			if (commentId == commentList.get(i).getId()) {
				int newRating = commentList.get(i).getRating() + 1;
				commentList.get(i).setRating(newRating);
				updatedComment =  commentList.get(i);
				break;
			}
		}
		return updatedComment;
	}

	//delete comment
	public void deleteComment(int commentId) { 
		for (int i = 0; i < commentList.size(); i++) {
			if (commentId == commentList.get(i).getId()) {
				commentList.remove(i);
				break;
			}
		}
	}

}
