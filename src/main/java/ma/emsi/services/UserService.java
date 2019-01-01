package ma.emsi.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.emsi.bean.User;
import ma.emsi.dao.IDao;
import ma.emsi.util.HibernateUtil;

public class UserService implements IDao<User>{
	
	public static Logger log = Logger.getLogger(UserService.class);

	public boolean create(User o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return false;
        }
	}

	public boolean update(User o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return false;
        }
	}

	public boolean delete(User o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return false;
        }
	}

	public User findById(Long id) {
		User u = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            u = (User) session.get(User.class, id);
            tx.commit();
            session.close();
            return u;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return u;
        }
	}
	
	public User findByLogin(String login) {
		User u = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<User> users = session.createQuery("select u from User u where u.login=:login").setParameter("login", login).list();;
            tx.commit();
            session.close();
            if (users.size() == 1)
            {
            	return (User) users.get(0);
            }
            return null;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return u;
        }
	}

	public List<User> findAll() {
		List<User> users = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            users = session.createQuery("from User").list();
            tx.commit();
            session.close();
            return users;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return users;
        }
	}

}
