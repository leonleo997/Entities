package co.com.highusoft.learnersinthematch.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the NIVEL_MADUREZ database table.
 * 
 */
@Entity
@Table(name="NIVEL_MADUREZ")
@NamedQuery(name="NivelMadurez.findAll", query="SELECT n FROM NivelMadurez n")
public class NivelMadurez implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NIVEL_MADUREZ_IDNIVELMADUREZ_GENERATOR", sequenceName="NIVEL_MADUREZ_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NIVEL_MADUREZ_IDNIVELMADUREZ_GENERATOR")
	@Column(name="ID_NIVEL_MADUREZ", unique=true, nullable=false)
	private Long idNivelMadurez;

	@Column(name="NOMBRE_NIVEL_MADUREZ", nullable=false, length=20)
	private String nombreNivelMadurez;

	//bi-directional many-to-one association to Tema
	@OneToMany(mappedBy="nivelMadurez")
	private List<Tema> temas;

	public NivelMadurez() {
	}

	public Long getIdNivelMadurez() {
		return this.idNivelMadurez;
	}

	public void setIdNivelMadurez(Long idNivelMadurez) {
		this.idNivelMadurez = idNivelMadurez;
	}

	public String getNombreNivelMadurez() {
		return this.nombreNivelMadurez;
	}

	public void setNombreNivelMadurez(String nombreNivelMadurez) {
		this.nombreNivelMadurez = nombreNivelMadurez;
	}

	public List<Tema> getTemas() {
		return this.temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public Tema addTema(Tema tema) {
		getTemas().add(tema);
		tema.setNivelMadurez(this);

		return tema;
	}

	public Tema removeTema(Tema tema) {
		getTemas().remove(tema);
		tema.setNivelMadurez(null);

		return tema;
	}

}