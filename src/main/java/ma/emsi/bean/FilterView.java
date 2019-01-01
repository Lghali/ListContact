package ma.emsi.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import ma.emsi.services.ContactService;

@ManagedBean(name = "dtFilterView")
@ViewScoped
public class FilterView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Contact> contacts;

	private List<Contact> filteredContacts;

	@PostConstruct
	public void init() {
		ContactService contactService = new ContactService();
		contacts = contactService.findAll();
	}

	public boolean filterByPrice(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();
		if (filterText == null || filterText.equals("")) {
			return true;
		}

		if (value == null) {
			return false;
		}

		return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
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