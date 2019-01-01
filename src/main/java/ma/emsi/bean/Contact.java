package ma.emsi.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.log4j.Logger;

import ma.emsi.services.ContactService;

@Entity
@ManagedBean
@SessionScoped
public class Contact implements Serializable {
	
	public static Logger log = Logger.getLogger(Contact.class);

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String tel;
	@ManyToOne
	private User user;

	public Contact() {
	}

	public Contact(String nom, String tel, User user) {
		this.nom = nom;
		this.tel = tel;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String ajouterContact() {
		ContactService contactService = new ContactService();
		User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		contactService.create(new Contact(nom, tel, user));
		clear();
		return "listContatct?faces-redirect=true";
	}
	
	public String modifierContact(Long id) {
		ContactService contactService = new ContactService();
		Contact contact = contactService.findById(id);
		contactService.delete(contact);
		clear();
		return "listContatct?faces-redirect=true";
	}
	
	public String supprimerContact(Long id) {
		ContactService contactService = new ContactService();
		Contact contact = contactService.findById(id);
		contactService.update(contact);
		clear();
		return "listContatct?faces-redirect=true";
	}
	
	public void clear(){
	    setId(null);
	    setNom(null);
	    setTel(null);
	}
}
