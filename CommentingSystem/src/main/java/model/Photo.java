package model;

/**
 * The class is used to contain the structure of a photograph object.
 *
 * @author Zhasmina Stoyanova
 * @version 1.0
 */
public class Photo {
	private int id;
	private String description;
	private int ownerId;

	public Photo(int id, String description, int ownerId) {
		this.id = id;
		this.description = description;
		this.ownerId = ownerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
}
