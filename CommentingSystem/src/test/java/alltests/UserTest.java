package alltests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.User;

public class UserTest {
	private int maxIntValue = Integer.MAX_VALUE;
	private User user1 = new User(1, "pesho", "pesho123", false);
	private User user2 = new User(2, "misho", "misho123", false);
	private User user3 = new User(maxIntValue, "grisho", "grisho123", true);

	@Test
	public void testGetId() {
		assertEquals(1, user1.getId());
		assertEquals(2, user2.getId());
		assertEquals(maxIntValue, user3.getId());
	}

	@Test
	public void testSetId() {
		user1.setId(100);
		assertEquals(100, user1.getId());
		user2.setId(maxIntValue / 2);
		assertEquals(maxIntValue / 2, user2.getId());
		user3.setId(maxIntValue);
		assertEquals(maxIntValue, user3.getId());
	}

	@Test
	public void testGetUsername() {
		assertEquals("pesho", user1.getUsername());
		assertEquals("misho", user2.getUsername());
		assertEquals("grisho", user3.getUsername());
	}

	@Test
	public void testSetUsername() {
		user1.setUsername("1111111111");
		assertEquals("1111111111", user1.getUsername());
		user2.setUsername("");
		assertEquals("", user2.getUsername());
		user3.setUsername("A_00ct111t");
		assertEquals("A_00ct111t", user3.getUsername());
	}

	@Test
	public void testGetPassword() {
		assertEquals("pesho123", user1.getPassword());
		assertEquals("misho123", user2.getPassword());
		assertEquals("grisho123", user3.getPassword());
	}

	@Test
	public void testSetPassword() {
		user1.setPassword("1111111111");
		assertEquals("1111111111", user1.getPassword());
		user2.setPassword("");
		assertEquals("", user2.getPassword());
		user3.setPassword("A_00ct111t");
		assertEquals("A_00ct111t", user3.getPassword());
	}

	@Test
	public void testHasAdminPrivileges() {
		assertEquals(false, user1.hasAdminPrivileges());
		assertEquals(false, user2.hasAdminPrivileges());
		assertEquals(true, user3.hasAdminPrivileges());
	}

	@Test
	public void testSetHasAdminPrivileges() {
		user1.setHasAdminPrivileges(true);
		assertEquals(true, user1.hasAdminPrivileges());
		user2.setHasAdminPrivileges(false);
		assertEquals(false, user2.hasAdminPrivileges());
		user3.setHasAdminPrivileges(true);
		assertEquals(true, user3.hasAdminPrivileges());
	}
}
