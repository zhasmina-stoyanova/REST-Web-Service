package alltests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.Photo;

public class PhotoTest {
	public int maxIntValue = Integer.MAX_VALUE;
	private Photo photo1 = new Photo(1, "sea", 1);
	private Photo photo2 = new Photo(2, "mountain", 2);
	private Photo photo3 = new Photo(maxIntValue, "city", 2);

	@Test
	public void testGetId() {
		assertEquals(1, photo1.getId());
		assertEquals(2, photo2.getId());
		assertEquals(maxIntValue, photo3.getId());
	}

	@Test
	public void testSetId() {
		photo1.setId(100);
		assertEquals(100, photo1.getId());
		photo2.setId(maxIntValue / 2);
		assertEquals(maxIntValue / 2, photo2.getId());
		photo3.setId(maxIntValue);
		assertEquals(maxIntValue, photo3.getId());
	}

	@Test
	public void testGetDescription() {
		assertEquals("sea", photo1.getDescription());
		assertEquals("mountain", photo2.getDescription());
		assertEquals("city", photo3.getDescription());
	}

	@Test
	public void testSetDescription() {
		photo1.setDescription("1111111111");
		assertEquals("1111111111", photo1.getDescription());
		photo2.setDescription("");
		assertEquals("", photo2.getDescription());
		photo3.setDescription("A_00ct111t");
		assertEquals("A_00ct111t", photo3.getDescription());
	}

	@Test
	public void testGetOwnerId() {
		assertEquals(1, photo1.getOwnerId());
		assertEquals(2, photo2.getOwnerId());
		assertEquals(2, photo3.getOwnerId());
	}

	@Test
	public void testSetOwnerId() {
		photo1.setOwnerId(maxIntValue);
		assertEquals(maxIntValue, photo1.getOwnerId());
		photo2.setOwnerId(maxIntValue/2);
		assertEquals(maxIntValue/2, photo2.getOwnerId());
	}
}
