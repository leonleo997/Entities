package co.com.highusoft.learnersinthematch.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TEMA database table.
 * 
 */
@Entity
@Table(name="TEMA")
@NamedQuery(name="Tema.findAll", query="SELECT t FROM Tema t")
public class Tema implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEMA_IDTEMA_GENERATOR", sequenceName="TEMA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEMA_IDTEMA_GENERATOR")
	@Column(name="ID_TEMA", unique=true, nullable=false)
	private Long idTema;

	@Column(name="DESCRIPCION_TEMA", length=50)
	private String descripcionTema;

	@Column(name="LINK_SKYPE", length=20)
	private String linkSkype;

	@Column(name="MIN_APRENDICES")
	private BigDecimal minAprendices;

	@Column(name="MIN_GUIAS")
	private BigDecimal minGuias;

	@Column(name="NOMBRE_TEMA", nullable=false, length=20)
	private String nombreTema;

	//bi-directional many-to-one association to Cuadrante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUADRANTE_ID_CUADRANTE", nullable=false)
	private Cuadrante cuadrante;

	//bi-directional many-to-one association to Estado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ESTADO_ID_ESTADO", nullable=false)
	private Estado estado;

	//bi-directional many-to-one association to NivelMadurez
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NIVEL_MADUREZ_ID_NIVEL_MADUREZ", nullable=false)
	private NivelMadurez nivelMadurez;

	//bi-directional many-to-one association to UsuarioTema
	@OneToMany(mappedBy="tema")
	private List<UsuarioTema> usuarioTemas;

	public Tema() {
	}

	public Long getIdTema() {
		return this.idTema;
	}

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}

	public String getDescripcionTema() {
		return this.descripcionTema;
	}

	public void setDescripcionTema(String descripcionTema) {
		this.descripcionTema = descripcionTema;
	}

	public String getLinkSkype() {
		return this.linkSkype;
	}

	public void setLinkSkype(String linkSkype) {
		this.linkSkype = linkSkype;
	}

	public BigDecimal getMinAprendices() {
		return this.minAprendices;
	}

	public void setMinAprendices(BigDecimal minAprendices) {
		this.minAprendices = minAprendices;
	}

	public BigDecimal getMinGuias() {
		return this.minGuias;
	}

	public void setMinGuias(BigDecimal minGuias) {
		this.minGuias = minGuias;
	}

	public String getNombreTema() {
		return this.nombreTema;
	}

	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}

	public Cuadrante getCuadrante() {
		return this.cuadrante;
	}

	public void setCuadrante(Cuadrante cuadrante) {
		this.cuadrante = cuadrante;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public NivelMadurez getNivelMadurez() {
		return this.nivelMadurez;
	}

	public void setNivelMadurez(NivelMadurez nivelMadurez) {
		this.nivelMadurez = nivelMadurez;
	}

	public List<UsuarioTema> getUsuarioTemas() {
		return this.usuarioTemas;
	}

	public void setUsuarioTemas(List<UsuarioTema> usuarioTemas) {
		this.usuarioTemas = usuarioTemas;
	}

	public UsuarioTema addUsuarioTema(UsuarioTema usuarioTema) {
		getUsuarioTemas().add(usuarioTema);
		usuarioTema.setTema(this);

		return usuarioTema;
	}

	public UsuarioTema removeUsuarioTema(UsuarioTema usuarioTema) {
		getUsuarioTemas().remove(usuarioTema);
		usuarioTema.setTema(null);

		return usuarioTema;
	}

}