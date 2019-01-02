package ma.emsi.testUtile;



import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ma.emsi.bean.User;
import ma.emsi.services.UserService;

public class UserTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		User u = new User("hamza", "hamza");
		UserService us = new UserService();
		assertTrue(us.create(u));
	}

}
