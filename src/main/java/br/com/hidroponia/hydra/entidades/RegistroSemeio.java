package br.com.hidroponia.hydra.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "registro_semeio")
public class RegistroSemeio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@JoinTable(	name="registro_semeio_insumo", 
			joinColumns=@JoinColumn(name="id_registro"), 
			inverseJoinColumns=@JoinColumn(name="id_insumo"), 
			uniqueConstraints=@UniqueConstraint(columnNames={"id_registro", "id_insumo"}))	
	@OneToMany(cascade=CascadeType.ALL)
	private List<RegistroSemeioItem> insumos;
	
	@Column(columnDefinition = "DATE")
	private LocalDate data;
	
	@Column
	private Double custo;
	
	@Column(name = "quantidade_semeada")
	private Integer quantidadeSemeada;
	
	@Column(name = "quantidade_descartada")
	private Integer quantidadeDescartada;
	
	@Column
	private String lote;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<RegistroSemeioItem> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<RegistroSemeioItem> insumos) {
		this.insumos = insumos;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Integer getQuantidadeSemeada() {
		return quantidadeSemeada;
	}

	public void setQuantidadeSemeada(Integer quantidadeSemeada) {
		this.quantidadeSemeada = quantidadeSemeada;
	}

	public Integer getQuantidadeDescartada() {
		return quantidadeDescartada;
	}

	public void setQuantidadeDescartada(Integer quantidadeDescartada) {
		this.quantidadeDescartada = quantidadeDescartada;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}
	
	
	
}