package ma.emsi.services;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.apache.log4j.Logger;

import ma.emsi.bean.Contact;
import ma.emsi.bean.User;
import ma.emsi.dao.ContactDao;
import ma.emsi.dao.IDao;

@ManagedBean(name = "contactService")
@ApplicationScoped
public class ContactService implements IDao<Contact> {

	public static Logger log = Logger.getLogger(ContactService.class);

	ContactDao dao = new ContactDao();

	public boolean create(Contact o) {
		return dao.create(o);

	}

	public boolean update(Contact o) {
		return dao.update(o);
	}

	public boolean delete(Contact o) {
		return dao.delete(o);
	}

	public Contact findById(Long id) {
		return dao.findById(id);
	}

	
	public List<Contact> findAll(User u) {
		return dao.findAll();
	}

	public List<Contact> findAll() {
		return dao.findAll();
	}

}
