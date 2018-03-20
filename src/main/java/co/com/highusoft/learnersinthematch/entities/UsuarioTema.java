package co.com.highusoft.learnersinthematch.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the USUARIO_TEMA database table.
 * 
 */
@Entity
@Table(name="USUARIO_TEMA")
@NamedQuery(name="UsuarioTema.findAll", query="SELECT u FROM UsuarioTema u")
public class UsuarioTema implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_TEMA_IDUSUARIOTEMA_GENERATOR", sequenceName="USUARIO_TEMA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_TEMA_IDUSUARIOTEMA_GENERATOR")
	@Column(name="ID_USUARIO_TEMA", unique=true, nullable=false)
	private Long idUsuarioTema;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_USUARIO_TEMA", nullable=false)
	private Date fechaUsuarioTema;

	//bi-directional many-to-one association to Tema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TEMA_ID_TEMA", nullable=false)
	private Tema tema;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USUARIO_ID_USUARIO", nullable=false)
	private Usuario usuario;

	public UsuarioTema() {
	}

	public Long getIdUsuarioTema() {
		return this.idUsuarioTema;
	}

	public void setIdUsuarioTema(Long idUsuarioTema) {
		this.idUsuarioTema = idUsuarioTema;
	}

	public Date getFechaUsuarioTema() {
		return this.fechaUsuarioTema;
	}

	public void setFechaUsuarioTema(Date fechaUsuarioTema) {
		this.fechaUsuarioTema = fechaUsuarioTema;
	}

	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}