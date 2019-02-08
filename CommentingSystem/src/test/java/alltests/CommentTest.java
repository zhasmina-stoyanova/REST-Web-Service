package alltests;

import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import model.Comment;

public class CommentTest {
	Date date1 = null;
	Date date2 = null;
	Date date3 = null;
	private int maxIntValue = 0;
	private Comment comment1 = null;
	private Comment comment2 = null;
	private Comment comment3 = null;

	public CommentTest() throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
		date1 = dateformat.parse("2012-07-10 14:58:00");
		date2 = dateformat.parse("2000-01-01 12:00:00");
		date3 = dateformat.parse("2020-12-31 11:59:59");
		maxIntValue = Integer.MAX_VALUE;
		comment1 = new Comment(1, "The city is beautiful", 1, 3, true, date1, maxIntValue);
		comment2 = new Comment(5, "I don't think the sea looks so nice", 1, maxIntValue, false, date3, 0);
		comment3 = new Comment(maxIntValue, "I don't agree", maxIntValue, 3, false, date2, 0);
	}

	@Test
	public void testGetId() {
		assertEquals(1, comment1.getId());
		assertEquals(5, comment2.getId());
		assertEquals(maxIntValue, comment3.getId());
	}

	@Test
	public void testSetId() {
		comment1.setId(100);
		assertEquals(100, comment1.getId());
		comment2.setId(maxIntValue / 2);
		assertEquals(maxIntValue / 2, comment2.getId());
		comment3.setId(maxIntValue);
		assertEquals(maxIntValue, comment3.getId());
	}

	@Test
	public void testGetText() {
		assertEquals("The city is beautiful", comment1.getText());
		assertEquals("I don't think the sea looks so nice", comment2.getText());
		assertEquals("I don't agree", comment3.getText());
	}

	@Test
	public void testSetText() {
		comment1.setText("1111111111");
		assertEquals("1111111111", comment1.getText());
		comment2.setText("");
		assertEquals("", comment2.getText());
		comment3.setText("A_00ct111t");
		assertEquals("A_00ct111t", comment3.getText());
	}

	@Test
	public void testGetUserId() {
		assertEquals(1, comment1.getUserId());
		assertEquals(1, comment2.getUserId());
		assertEquals(maxIntValue, comment3.getUserId());
	}

	@Test
	public void testSetUserId() {
		comment1.setUserId(100);
		assertEquals(100, comment1.getUserId());
		comment2.setUserId(maxIntValue / 2);
		assertEquals(maxIntValue / 2, comment2.getUserId());
		comment3.setUserId(maxIntValue);
		assertEquals(maxIntValue, comment3.getUserId());
	}

	@Test
	public void testGetCommentedId() {
		assertEquals(3, comment1.getCommentedId());
		assertEquals(maxIntValue, comment2.getCommentedId());
		assertEquals(3, comment3.getCommentedId());
	}

	@Test
	public void testSetCommentedId() {
		comment1.setCommentedId(100);
		assertEquals(100, comment1.getCommentedId());
		comment2.setCommentedId(maxIntValue / 2);
		assertEquals(maxIntValue / 2, comment2.getCommentedId());
		comment3.setCommentedId(maxIntValue);
		assertEquals(maxIntValue, comment3.getCommentedId());
	}

	@Test
	public void testIsPhoto() {
		assertEquals(true, comment1.isPhoto());
		assertEquals(false, comment2.isPhoto());
		assertEquals(false, comment3.isPhoto());
	}

	@Test
	public void testSetPhoto() {
		comment1.setPhoto(false);
		assertEquals(false, comment1.isPhoto());
		comment2.setPhoto(false);
		assertEquals(false, comment2.isPhoto());
		comment3.setPhoto(true);
		assertEquals(true, comment3.isPhoto());
	}

	@Test
	public void testGetDateCreated() {
		assertEquals(date1, comment1.getDateCreated());
		assertEquals(date3, comment2.getDateCreated());
		assertEquals(date2, comment3.getDateCreated());
	}

	@Test
	public void testSetDateCreated() {
		comment1.setDateCreated(date1);
		assertEquals(date1, comment1.getDateCreated());
		comment2.setDateCreated(date2);
		assertEquals(date2, comment2.getDateCreated());
		comment3.setDateCreated(date1);
		assertEquals(date1, comment3.getDateCreated());
	}

	@Test
	public void testGetRating() {
		assertEquals(maxIntValue, comment1.getRating());
		assertEquals(0, comment2.getRating());
		assertEquals(0, comment3.getRating());
	}

	@Test
	public void testSetRating() {
		comment1.setRating(100);
		assertEquals(100, comment1.getRating());
		comment2.setRating(maxIntValue / 2);
		assertEquals(maxIntValue / 2, comment2.getRating());
		comment3.setRating(maxIntValue);
		assertEquals(maxIntValue, comment3.getRating());
	}
}
