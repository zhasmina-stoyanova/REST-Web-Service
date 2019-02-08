package model;

/**
 * The class is used to contain the structure of a user object.
 *
 * @author Zhasmina Stoyanova
 * @version 1.0
 */
public class User {
	private int id;
	private String username;
	private String password;
	private boolean hasAdminPrivileges;

	public User(int id, String username, String password, boolean hasAdminPrivileges) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.hasAdminPrivileges = hasAdminPrivileges;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean hasAdminPrivileges() {
		return hasAdminPrivileges;
	}

	public void setHasAdminPrivileges(boolean hasAdminPrivileges) {
		this.hasAdminPrivileges = hasAdminPrivileges;
	}
}
