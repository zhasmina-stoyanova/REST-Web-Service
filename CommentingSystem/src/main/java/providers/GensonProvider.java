package providers;

import java.text.SimpleDateFormat;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

/**
 * The class is used to convert the date and time in appropriate format
 * when the data is outputed in JSON format.
 *
 * @author Zhasmina Stoyanova
 * @version 1.0
 */
@Provider
public class GensonProvider implements ContextResolver<Genson> {

    private final com.owlike.genson.Genson genson = new GensonBuilder().useDateAsTimestamp(false)
    		.useDateFormat(new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss"))
            .create();
    @Override
    public Genson getContext(Class<?> type) {
        return genson;
    }
}