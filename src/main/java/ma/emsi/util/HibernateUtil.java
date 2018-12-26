package ma.emsi.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
	
	public static Logger log = Logger.getLogger(HibernateUtil.class);
 
    private static final SessionFactory sessionFactory=buildSessionFactory();
 
   public static SessionFactory buildSessionFactory(){
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
