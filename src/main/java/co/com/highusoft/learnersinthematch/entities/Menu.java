package co.com.highusoft.learnersinthematch.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MENU database table.
 * 
 */
@Entity
@Table(name="MENU")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MENU_IDMENU_GENERATOR", sequenceName="MENU_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MENU_IDMENU_GENERATOR")
	@Column(name="ID_MENU", unique=true, nullable=false)
	private Long idMenu;

	@Column(nullable=false, length=20)
	private String nombre;

	//bi-directional many-to-one association to Menu
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MENU_ID_MENU")
	private Menu menu;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="menu")
	private List<Menu> menus;

	//bi-directional many-to-many association to Pagina
	@ManyToMany
	@JoinTable(
		name="MENU_PAGINA"
		, joinColumns={
			@JoinColumn(name="MENU_ID_MENU", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="PAGINA_ID_PAGINA", nullable=false)
			}
		)
	private List<Pagina> paginas;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="MENU_ROL"
		, joinColumns={
			@JoinColumn(name="MENU_ID_MENU", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="ROL_ID_ROL", nullable=false)
			}
		)
	private List<Rol> rols;

	public Menu() {
	}

	public Long getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setMenu(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setMenu(null);

		return menus;
	}

	public List<Pagina> getPaginas() {
		return this.paginas;
	}

	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}