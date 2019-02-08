package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is used to store a static list of photographs.
 *
 * @author Zhasmina Stoyanova
 * @version 1.0
 */
public class Photos {
	public static List<Photo> photoList = new ArrayList<Photo>();

	// initialize photos
	static {
		Photo photo1 = new Photo(1, "sea", 1);
		Photo photo2 = new Photo(2, "mountain", 2);
		Photo photo3 = new Photo(3, "city", 2);
		photoList.add(photo1);
		photoList.add(photo2);
		photoList.add(photo3);
	}
}
