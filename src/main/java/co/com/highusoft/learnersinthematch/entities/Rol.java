package co.com.highusoft.learnersinthematch.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ROL database table.
 * 
 */
@Entity
@Table(name="ROL")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROL_IDROL_GENERATOR", sequenceName="ROL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_IDROL_GENERATOR")
	@Column(name="ID_ROL", unique=true, nullable=false)
	private Long idRol;

	@Column(nullable=false, length=20)
	private String categoria;

	@Column(name="NOMBRE_ROL", nullable=false, length=20)
	private String nombreRol;

	//bi-directional many-to-many association to Menu
	@ManyToMany(mappedBy="rols")
	private List<Menu> menus;

	//bi-directional many-to-many association to Usuario
	@ManyToMany
	@JoinTable(
		name="ROL_USUARIO"
		, joinColumns={
			@JoinColumn(name="ROL_ID_ROL", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="USUARIO_ID_USUARIO", nullable=false)
			}
		)
	private List<Usuario> usuarios;

	public Rol() {
	}

	public Long getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}