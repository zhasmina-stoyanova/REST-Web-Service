package resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Photo;
import model.Photos;
/**
 * A resource file for getting all photo objects through Jersey API in JSON format.
 *
 * @author Zhasmina Stoyanova
 * @version 1.0
 */
@Path("photos")
public class PhotosResource {
	Photos photos = new Photos();
	
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Photo> getAllPhotosList() {
    	return Photos.photoList;
    }
}
