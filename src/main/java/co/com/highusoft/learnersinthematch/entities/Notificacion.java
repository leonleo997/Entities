package co.com.highusoft.learnersinthematch.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the NOTIFICACION database table.
 * 
 */
@Entity
@Table(name="NOTIFICACION")
@NamedQuery(name="Notificacion.findAll", query="SELECT n FROM Notificacion n")
public class Notificacion implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOTIFICACION_ID_GENERATOR", sequenceName="NOTIFICACION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOTIFICACION_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION", nullable=false)
	private Date fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_EJECUCION")
	private Date fechaEjecucion;

	@Column(nullable=false, length=60)
	private String mensaje;

	//bi-directional many-to-one association to UsuarioNotificacion
	@OneToMany(mappedBy="notificacion")
	private List<UsuarioNotificacion> usuarioNotificacions;

	public Notificacion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEjecucion() {
		return this.fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<UsuarioNotificacion> getUsuarioNotificacions() {
		return this.usuarioNotificacions;
	}

	public void setUsuarioNotificacions(List<UsuarioNotificacion> usuarioNotificacions) {
		this.usuarioNotificacions = usuarioNotificacions;
	}

	public UsuarioNotificacion addUsuarioNotificacion(UsuarioNotificacion usuarioNotificacion) {
		getUsuarioNotificacions().add(usuarioNotificacion);
		usuarioNotificacion.setNotificacion(this);

		return usuarioNotificacion;
	}

	public UsuarioNotificacion removeUsuarioNotificacion(UsuarioNotificacion usuarioNotificacion) {
		getUsuarioNotificacions().remove(usuarioNotificacion);
		usuarioNotificacion.setNotificacion(null);

		return usuarioNotificacion;
	}

}