package ma.emsi.testUtile;

import org.apache.log4j.Logger;

import ma.emsi.bean.User;
import ma.emsi.services.UserService;
import ma.emsi.util.HibernateUtil;

public class TestHibernate {
	
	public static Logger log = Logger.getLogger(TestHibernate.class);

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory().openSession();
		
		log.info("Premier test de log4j.");
		
		UserService userService = new UserService();
		User user1 = new User("lghali", "lghali");
		User user2 = new User("hamza", "hamza");
		userService.create(user1);
		userService.create(user2);
		
	}
}
