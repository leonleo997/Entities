package co.com.highusoft.learnersinthematch.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PAGINA database table.
 * 
 */
@Entity
@Table(name="PAGINA")
@NamedQuery(name="Pagina.findAll", query="SELECT p FROM Pagina p")
public class Pagina implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAGINA_IDPAGINA_GENERATOR", sequenceName="PAGINA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAGINA_IDPAGINA_GENERATOR")
	@Column(name="ID_PAGINA", unique=true, nullable=false)
	private Long idPagina;

	@Column(nullable=false, length=20)
	private String nombre;

	@Column(nullable=false, length=20)
	private String url;

	//bi-directional many-to-many association to Menu
	@ManyToMany(mappedBy="paginas")
	private List<Menu> menus;

	public Pagina() {
	}

	public Long getIdPagina() {
		return this.idPagina;
	}

	public void setIdPagina(Long idPagina) {
		this.idPagina = idPagina;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}