package ma.emsi.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.log4j.Logger;

import ma.emsi.services.UserService;

@Entity
@ManagedBean
@SessionScoped
public class User implements Serializable {

	public static Logger log = Logger.getLogger(User.class);

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String password;

	public User() {
	}

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String connexion() {
		UserService userService = new UserService();
		User user = userService.findByLogin(login);
		System.out.println(user);
		if (user != null && user.getPassword().equals(password)) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
			return "listContatct?faces-redirect=true";
		} else {
			clear();
			return "error?faces-redirect=true";
		}
	}

	public String logout(){
		System.out.println("User.logout()");
//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		clear();
//		FacesContext.getCurrentInstance().getExternalContext().dispatch("index");
		return "index?faces-redirect=true";
	}

	public void clear() {
		setId(null);
		setLogin(null);
		setPassword(null);
	}

}
