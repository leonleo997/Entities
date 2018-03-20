package co.com.highusoft.learnersinthematch.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CUADRANTE database table.
 * 
 */
@Entity
@Table(name="CUADRANTE")
@NamedQuery(name="Cuadrante.findAll", query="SELECT c FROM Cuadrante c")
public class Cuadrante implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUADRANTE_IDCUADRANTE_GENERATOR", sequenceName="CUADRANTE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUADRANTE_IDCUADRANTE_GENERATOR")
	@Column(name="ID_CUADRANTE", unique=true, nullable=false)
	private Long idCuadrante;

	@Column(name="NOMBRE_CUADRANTE", nullable=false, length=20)
	private String nombreCuadrante;

	//bi-directional many-to-one association to Tema
	@OneToMany(mappedBy="cuadrante")
	private List<Tema> temas;

	public Cuadrante() {
	}

	public Long getIdCuadrante() {
		return this.idCuadrante;
	}

	public void setIdCuadrante(Long idCuadrante) {
		this.idCuadrante = idCuadrante;
	}

	public String getNombreCuadrante() {
		return this.nombreCuadrante;
	}

	public void setNombreCuadrante(String nombreCuadrante) {
		this.nombreCuadrante = nombreCuadrante;
	}

	public List<Tema> getTemas() {
		return this.temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public Tema addTema(Tema tema) {
		getTemas().add(tema);
		tema.setCuadrante(this);

		return tema;
	}

	public Tema removeTema(Tema tema) {
		getTemas().remove(tema);
		tema.setCuadrante(null);

		return tema;
	}

}