package co.com.highusoft.learnersinthematch.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name="USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_ID_GENERATOR", sequenceName="USUARIO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Long id;

	@Lob
	@Column(nullable=false)
	private byte[] contrasenia;

	@Column(nullable=false, length=30)
	private String correo;

	@Column(name="FRECUENCIA_NOTIFICACION", nullable=false, length=30)
	private String frecuenciaNotificacion;

	@Column(name="NOMBRE_USUARIO", nullable=false, length=20)
	private String nombreUsuario;

	//bi-directional many-to-many association to Rol
	@ManyToMany(mappedBy="usuarios")
	private List<Rol> rols;

	//bi-directional many-to-one association to UsuarioNotificacion
	@OneToMany(mappedBy="usuario")
	private List<UsuarioNotificacion> usuarioNotificacions;

	//bi-directional many-to-one association to UsuarioTema
	@OneToMany(mappedBy="usuario")
	private List<UsuarioTema> usuarioTemas;

	public Usuario() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(byte[] contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFrecuenciaNotificacion() {
		return this.frecuenciaNotificacion;
	}

	public void setFrecuenciaNotificacion(String frecuenciaNotificacion) {
		this.frecuenciaNotificacion = frecuenciaNotificacion;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

	public List<UsuarioNotificacion> getUsuarioNotificacions() {
		return this.usuarioNotificacions;
	}

	public void setUsuarioNotificacions(List<UsuarioNotificacion> usuarioNotificacions) {
		this.usuarioNotificacions = usuarioNotificacions;
	}

	public UsuarioNotificacion addUsuarioNotificacion(UsuarioNotificacion usuarioNotificacion) {
		getUsuarioNotificacions().add(usuarioNotificacion);
		usuarioNotificacion.setUsuario(this);

		return usuarioNotificacion;
	}

	public UsuarioNotificacion removeUsuarioNotificacion(UsuarioNotificacion usuarioNotificacion) {
		getUsuarioNotificacions().remove(usuarioNotificacion);
		usuarioNotificacion.setUsuario(null);

		return usuarioNotificacion;
	}

	public List<UsuarioTema> getUsuarioTemas() {
		return this.usuarioTemas;
	}

	public void setUsuarioTemas(List<UsuarioTema> usuarioTemas) {
		this.usuarioTemas = usuarioTemas;
	}

	public UsuarioTema addUsuarioTema(UsuarioTema usuarioTema) {
		getUsuarioTemas().add(usuarioTema);
		usuarioTema.setUsuario(this);

		return usuarioTema;
	}

	public UsuarioTema removeUsuarioTema(UsuarioTema usuarioTema) {
		getUsuarioTemas().remove(usuarioTema);
		usuarioTema.setUsuario(null);

		return usuarioTema;
	}

}