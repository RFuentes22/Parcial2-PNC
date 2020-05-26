package com.uca.capas.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="cat_libro")
public class Libro {

	@Id
	@GeneratedValue(generator="cat_libro_c_libro_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="cat_libro_c_libro_seq",sequenceName="public.cat_libro_c_libro_seq", allocationSize = 1)
	@Column(name="c_libro")
	private Integer clibro;
	
	@Size(message="El Campo no debe de tener mas de 500 caracteres",max=500)
	@NotEmpty(message="El Campo no puede estar vacio")
	@Column(name="s_titulo")
	private String	stitulo;
	
	@Size(message="El Campo no debe de tener mas de 150 caracteres",max=150)
	@NotEmpty(message="El Campo no puede estar vacio")
	@Column(name="s_autor")
	private String	sautor;
	
	@NotNull(message = "Debes de seleccionar una Categoria")
	@Column(name="c_categoria")
	private Integer	ccategoria;
	
	
	@Column(name="f_ingreso")
	private Timestamp  fingreso;
	
	@NotNull(message="El Campo no puede estar vacio")
	@Column(name="b_estado")
	private Boolean	bestado;
	
	@Size(message="El Campo no debe de tener mas de 10 caracteres",max=10)
	@NotEmpty(message="El Campo no puede estar vacio")
	@Column(name="s_isbn")
	private String	sisbn;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_categoria",unique=true,insertable = false, updatable = false)
	private Categoria categoria;

	
	
	
	public Libro() {
		
	}

	public Integer getClibro() {
		return clibro;
	}

	public void setClibro(Integer clibro) {
		this.clibro = clibro;
	}

	public String getStitulo() {
		return stitulo;
	}

	public void setStitulo(String stitulo) {
		this.stitulo = stitulo;
	}

	public String getSautor() {
		return sautor;
	}

	public void setSautor(String sautor) {
		this.sautor = sautor;
	}

	public Integer getCcategoria() {
		return ccategoria;
	}

	public void setCcategoria(Integer ccategoria) {
		this.ccategoria = ccategoria;
	}

	public Timestamp getFingreso() {
		return fingreso;
	}

	public void setFingreso(Timestamp sdate) {
		this.fingreso = sdate;
	}

	public Boolean getBestado() {
		return bestado;
	}

	public void setBestado(Boolean bestado) {
		this.bestado = bestado;
	}

	public String getSisbn() {
		return sisbn;
	}

	public void setSisbn(String sisbn) {
		this.sisbn = sisbn;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	//Delegate para conversion de fecha
		public String getFechaDelegate(){
			if(this.fingreso == null){
				return "";
			}
			else{
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				String shortdate = sdf.format(this.fingreso.getTime());
				return shortdate;
			}
		}
	
	
	
}
