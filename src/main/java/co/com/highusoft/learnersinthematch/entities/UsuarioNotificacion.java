package co.com.highusoft.learnersinthematch.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USUARIO_NOTIFICACION database table.
 * 
 */
@Entity
@Table(name="USUARIO_NOTIFICACION")
@NamedQuery(name="UsuarioNotificacion.findAll", query="SELECT u FROM UsuarioNotificacion u")
public class UsuarioNotificacion implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_NOTIFICACION_IDUSUARIONOTIFICACION_GENERATOR", sequenceName="USUARIO_NOTIFICACION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_NOTIFICACION_IDUSUARIONOTIFICACION_GENERATOR")
	@Column(name="ID_USUARIO_NOTIFICACION", unique=true, nullable=false)
	private Long idUsuarioNotificacion;

	//bi-directional many-to-one association to Estado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ESTADO_ID_ESTADO", nullable=false)
	private Estado estado;

	//bi-directional many-to-one association to Notificacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NOTIFICACION_ID_NOTI", nullable=false)
	private Notificacion notificacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USUARIO_ID_USER", nullable=false)
	private Usuario usuario;

	public UsuarioNotificacion() {
	}

	public Long getIdUsuarioNotificacion() {
		return this.idUsuarioNotificacion;
	}

	public void setIdUsuarioNotificacion(Long idUsuarioNotificacion) {
		this.idUsuarioNotificacion = idUsuarioNotificacion;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Notificacion getNotificacion() {
		return this.notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}