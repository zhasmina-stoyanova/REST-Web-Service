package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is used to store a static list of users.
 *
 * @author Zhasmina Stoyanova
 * @version 1.0
 */
public class Users {
	public static List<User> userList = new ArrayList<User>();

	// initialize users
	static {
    	User user1 = new User(1, "pesho", "pesho123", false);
    	User user2 = new User(2, "misho", "misho123", false);
    	User user3 = new User(3, "grisho", "grisho123", true);
    	userList.add(user1);
    	userList.add(user2);
    	userList.add(user3);
	}
    
    
}
