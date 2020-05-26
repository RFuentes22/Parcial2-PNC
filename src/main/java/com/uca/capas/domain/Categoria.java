package com.uca.capas.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Repository;

@Entity
@Repository
@Table(schema="public",name="cat_categoria")
public class Categoria {

	@Id
	@GeneratedValue(generator="cat_categoria_c_categoria_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="cat_categoria_c_categoria_seq",sequenceName="public.cat_categoria_c_categoria_seq", allocationSize = 1)
	@Column(name="c_categoria")
	private Integer ccategoria;
	
	@NotEmpty(message="El Campo no puede estar vacio")
	@Size(message="El Campo no debe de tener mas de 50 caracteres",max=50)
	@Column(name="s_categoria")
	private String	scategoria;
	
	
	@OneToMany(mappedBy = "categoria",fetch = FetchType.EAGER)
	private List<Libro> librosList;
	
	public Categoria() {
	
	}

	public Integer getCcategoria() {
		return ccategoria;
	}

	public void setCcategoria(Integer ccategoria) {
		this.ccategoria = ccategoria;
	}

	public String getScategoria() {
		return scategoria;
	}

	public void setScategoria(String scategoria) {
		this.scategoria = scategoria;
	}

	
	public List<Libro> getLibrosList() {
		return librosList;
	}

	public void setLibrosList(List<Libro> librosList) {
		this.librosList = librosList;
	}

	
	
	
	
	
	
	
	
}
