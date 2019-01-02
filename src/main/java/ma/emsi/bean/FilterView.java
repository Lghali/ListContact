package ma.emsi.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import ma.emsi.services.ContactService;

@ManagedBean(name = "dtFilterView")
@ViewScoped
public class FilterView implements Serializable {

	private static final long serialVersionUID = 1L;
	ContactService service = new ContactService();
	private List<Contact> contacts = service.findAll();

	private List<Contact> filteredContacts;

	@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		contacts = service.findAll();
	}

	public List<Contact> getContacts() {
		
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Contact> getFilteredContacts() {
		return filteredContacts;
	}

	public void setFilteredContacts(List<Contact> filteredContacts) {
		this.filteredContacts = filteredContacts;
	}

}