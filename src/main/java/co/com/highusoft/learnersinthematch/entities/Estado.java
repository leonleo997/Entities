package co.com.highusoft.learnersinthematch.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ESTADO database table.
 * 
 */
@Entity
@Table(name="ESTADO")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTADO_IDESTADO_GENERATOR", sequenceName="ESTADO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADO_IDESTADO_GENERATOR")
	@Column(name="ID_ESTADO", unique=true, nullable=false)
	private Long idEstado;

	@Column(nullable=false, length=20)
	private String categoria;

	@Column(name="NOMBRE_ESTADO", nullable=false, length=20)
	private String nombreEstado;

	//bi-directional many-to-one association to Tema
	@OneToMany(mappedBy="estado")
	private List<Tema> temas;

	//bi-directional many-to-one association to UsuarioNotificacion
	@OneToMany(mappedBy="estado")
	private List<UsuarioNotificacion> usuarioNotificacions;

	public Estado() {
	}

	public Long getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombreEstado() {
		return this.nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public List<Tema> getTemas() {
		return this.temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public Tema addTema(Tema tema) {
		getTemas().add(tema);
		tema.setEstado(this);

		return tema;
	}

	public Tema removeTema(Tema tema) {
		getTemas().remove(tema);
		tema.setEstado(null);

		return tema;
	}

	public List<UsuarioNotificacion> getUsuarioNotificacions() {
		return this.usuarioNotificacions;
	}

	public void setUsuarioNotificacions(List<UsuarioNotificacion> usuarioNotificacions) {
		this.usuarioNotificacions = usuarioNotificacions;
	}

	public UsuarioNotificacion addUsuarioNotificacion(UsuarioNotificacion usuarioNotificacion) {
		getUsuarioNotificacions().add(usuarioNotificacion);
		usuarioNotificacion.setEstado(this);

		return usuarioNotificacion;
	}

	public UsuarioNotificacion removeUsuarioNotificacion(UsuarioNotificacion usuarioNotificacion) {
		getUsuarioNotificacions().remove(usuarioNotificacion);
		usuarioNotificacion.setEstado(null);

		return usuarioNotificacion;
	}

}