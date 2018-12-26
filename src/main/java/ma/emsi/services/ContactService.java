package ma.emsi.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.emsi.bean.Contact;
import ma.emsi.dao.IDao;
import ma.emsi.util.HibernateUtil;

public class ContactService implements IDao<Contact>{
	
	public static Logger log = Logger.getLogger(ContactService.class);

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
