package ma.emsi.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

import ma.emsi.services.ContactService;

@ManagedBean(name = "dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Contact> contacts;

	@ManagedProperty("#{contactService}")
	private ContactService contactService;

	@PostConstruct
	public void init() {
		contacts = contactService.findAll();
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setService(ContactService contactService) {
		this.contactService = contactService;
	}
}
