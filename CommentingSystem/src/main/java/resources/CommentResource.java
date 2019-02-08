package resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Comment;
import model.Comments;
/**
 * A resource file, containing operations for adding, filtering, deleting
 * and updating comment objects through Jersey API in JSON format.
 *
 * @author Zhasmina Stoyanova
 * @version 1.0
 */
@Path("comments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	Comments comments = new Comments();	
    
    @GET
    @Path("/all")
    public List<Comment> getAllCommentsList() {
    	return Comments.commentList;
    }
    
    @GET
    @Path("/byuser/{userId}")
    public List<Comment> getCommentsByUser(@PathParam("userId") int userId) {
    	return comments.getCommentsByUserId(userId);
    }
    
    @GET
    @Path("/byphoto/{photoId}")
    public List<Comment> getCommentsByPhoto(@PathParam("photoId") int photoId) {
    	return comments.getCommentsByPhotoId(photoId);
    }
    
    @GET
    @Path("/bycomment/{commentId}")
    public List<Comment> getRepliesByComment(@PathParam("commentId") int commentId) {
    	return comments.getRepliesByCommentId(commentId);
    }
    
    @POST
    @Path("/add")
    public Comment addComment(Comment comment) {
    	return comments.addComment(comment);
    }
    
    @PUT
    @Path("/downvote/{commentId}")

    public Comment downvoteComment(@PathParam("commentId") int commentId) {
    	return comments.downvoteComment(commentId);
    }
    
    @PUT
    @Path("/upvote/{commentId}")
    public Comment upvoteComment(@PathParam("commentId") int commentId) {
    	return comments.upvoteComment(commentId);
    }
    
    @DELETE
    @Path("/delete/{commentId}")
    public void deleteComment(@PathParam("commentId") int commentId) {
    	comments.deleteComment(commentId);
    }
}
