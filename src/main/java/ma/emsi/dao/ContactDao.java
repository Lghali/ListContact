package ma.emsi.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.emsi.bean.Contact;
import ma.emsi.bean.User;
import ma.emsi.dao.IDao;
import ma.emsi.util.HibernateUtil;

public class ContactDao implements IDao<Contact> {

	public static Logger log = Logger.getLogger(ContactDao.class);

	public boolean create(Contact o) {
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

	public boolean update(Contact o) {
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

	public boolean delete(Contact o) {
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

	public Contact findById(Long id) {
		Contact c = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			c = (Contact) session.get(Contact.class, id);
			tx.commit();
			session.close();
			return c;
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			session.close();
			return c;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Contact> findAll(User user) {
		List<Contact> contacts = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			contacts = session.createQuery("from Contact where idUser='" + user.getId() + "'").list();
			tx.commit();
			session.close();
			return contacts;
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			session.close();
			return contacts;
		}

	}

	@SuppressWarnings("unchecked")
	public List<Contact> findAll() {
		List<Contact> contacts = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			contacts = session.createQuery("from Contact").list();
			tx.commit();
			session.close();
			return contacts;
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			session.close();
			return contacts;
		}

	}
}
