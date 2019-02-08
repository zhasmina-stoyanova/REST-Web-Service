package client;

import java.util.Scanner;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import model.Users;
/**
 * A client that is used for logging users with different privileges, 
 * for providing options of the system that are used to filter, update, 
 * delete and add comments, and show all photos. The manipulations are done 
 * in the uri, as the operations are hidden for the users. Adding of a comment 
 * and getting result of operation is done through JSON format.
 *
 * @author Zhasmina Stoyanova
 * @version 1.0
 */
public class WebClient {
	private static String uri = "http://localhost:8080/system/";
	private static Response response = null;
	private static WebTarget target = null;
	private static Client client = null;
	private static ClientConfig config;

	static {
		config = new ClientConfig();
		client = ClientBuilder.newClient(config);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean correctLoginData = false;
		String currentUser = "";
		String currentPassword = "";
		boolean hasAdminPrivileges = false;
		do {
			System.out.println("Please, enter correct \nUsername: ");
			currentUser = input.nextLine();
			System.out.println("Password: ");
			currentPassword = input.nextLine();

			// check if password and username are correct
			for (int i = 0; i < Users.userList.size(); i++) {
				String legalUser = Users.userList.get(i).getUsername();
				String legalPassword = Users.userList.get(i).getPassword();
				if (currentUser.equals(legalUser) && currentPassword.equals(legalPassword)) {
					correctLoginData = true;
					hasAdminPrivileges = Users.userList.get(i).hasAdminPrivileges();
					break;
				}
			}
		} while (!correctLoginData);

		int option = 0;
		int commentId = 0;
		do {
			// Menu with options
			System.out.println("Choose option (1-10):\n" + "1. Add Comment\n" + "2. Upvote Comment\n"
					+ "3. Downvote Comment\n" + "4. Get Comments by User\n" + "5. Get Comments of Photo\n"
					+ "6. Get Comment Replies\n" + "7. View all comments\n" + "8. View all photos\n"
					+ "9. Remove Comment (admin privileges)*\n" + "10. Exit");
			String serverResponse = "";
			option = input.nextInt();
			switch (option) {
			case 1:
				System.out.println("Please, enter comment in the following JSON format: "
						+ "\n{\"commentedId\": [id], \"userId\": [id], \"photo\": [true, false], \"text\": [text]}");
				Scanner input2 = new Scanner(System.in);
				String commentJSON = input2.nextLine();
				addComment(commentJSON);
				serverResponse = "Comment added.";
				break;
			case 2:
				System.out.println("Please, enter comment id:");
				commentId = input.nextInt();
				serverResponse = upvoteRating(commentId);
				break;
			case 3:
				System.out.println("Please, enter comment id:");
				commentId = input.nextInt();
				serverResponse = downvoteRating(commentId);
				break;
			case 4:
				System.out.println("Please, enter user id:");
				int userId = input.nextInt();
				serverResponse = getCommentsByUser(userId);
				break;
			case 5:
				System.out.println("Please, enter photo id:");
				int photoId = input.nextInt();
				serverResponse = getCommentsByPhoto(photoId);
				break;
			case 6:
				System.out.println("Please, enter comment id:");
				commentId = input.nextInt();
				serverResponse = getRepliesByComment(commentId);
				break;
			case 7:
				serverResponse = viewAllComments();
				break;
			case 8:
				serverResponse = viewAllPhotos();
				break;
			case 9:
				if (!hasAdminPrivileges) {
					serverResponse = "UnauthorizedAccess!";
				} else {
					System.out.println("Please, enter comment id:");
					commentId = input.nextInt();
					serverResponse = "Comment deleted!";
				}
				break;
			case 10: 
				System.out.println("No more options!");
				return;
			default:
				System.out.println("The chosen option is not valid!");
			}

			System.out.println("Response: \n" + serverResponse + "\n");

		} while (option != 10);
		input.close();
	}

	public static void addComment(String commentJSON) {
		target = client.target(uri).path("comments").path("add");
		response = target.request().accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(commentJSON, MediaType.APPLICATION_JSON), Response.class);
	}

	public static String downvoteRating(int commentId) {
		target = client.target(uri).path("comments").path("downvote").path(commentId + "");
		response = target.request().accept(MediaType.APPLICATION_JSON)
				.put(Entity.entity(commentId, MediaType.APPLICATION_JSON), Response.class);
		return response.readEntity(String.class);
	}

	public static String upvoteRating(int commentId) {
		target = client.target(uri).path("comments").path("upvote").path(commentId + "");
		response = target.request().accept(MediaType.APPLICATION_JSON)
				.put(Entity.entity(commentId, MediaType.APPLICATION_JSON), Response.class);
		return response.readEntity(String.class);
	}

	public static String getCommentsByUser(int userId) {
		target = client.target(uri).path("comments").path("byuser").path(userId + "");
		response = target.request().accept(MediaType.APPLICATION_JSON).get();
		return response.readEntity(String.class);
	}

	public static String getCommentsByPhoto(int photoId) {
		target = client.target(uri).path("comments").path("byphoto").path(photoId + "");
		response = target.request().accept(MediaType.APPLICATION_JSON).get();
		return response.readEntity(String.class);
	}

	public static String getRepliesByComment(int commentId) {
		target = client.target(uri).path("comments").path("bycomment").path(commentId + "");
		response = target.request().accept(MediaType.APPLICATION_JSON).get();
		return response.readEntity(String.class);
	}

	public static String viewAllComments() {
		target = client.target(uri).path("comments").path("all");
		response = target.request().accept(MediaType.APPLICATION_JSON).get();
		return response.readEntity(String.class);
	}

	public static String viewAllPhotos() {
		target = client.target(uri).path("photos").path("all");
		response = target.request().accept(MediaType.APPLICATION_JSON).get();
		return response.readEntity(String.class);
	}

	public static String deleteComment(int commentId) {
		target = client.target(uri).path("comments").path("delete").path(commentId + "");
		Invocation.Builder invocationBuilder = target.request();
		response = invocationBuilder.delete();
		return response.readEntity(String.class);
	}
}
