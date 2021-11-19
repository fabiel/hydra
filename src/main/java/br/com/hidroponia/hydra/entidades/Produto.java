package br.com.hidroponia.hydra.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;

	@JoinTable(	name="produto_insumo", 
			joinColumns=@JoinColumn(name="id_produto"), 
			inverseJoinColumns=@JoinColumn(name="id_insumo"), 
			uniqueConstraints=@UniqueConstraint(columnNames={"id_produto", "id_insumo"}))	
	@OneToMany(cascade=CascadeType.ALL)
	private List<ProdutoInsumoItem> insumos;
	
	@Column(name = "valor_custo_total")
	private Double valorCustoTotal;
	
	@Column(name = "margem_lucro")
	private Integer margemLucro;
	
	@ElementCollection
	@CollectionTable(name="produto_fotos", joinColumns=@JoinColumn(name="id_produto"))
	@Column(name="fotos")
	private List<String> fotos;

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

	public List<ProdutoInsumoItem> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<ProdutoInsumoItem> insumos) {
		this.insumos = insumos;
	}

	public Double getValorCustoTotal() {
		return valorCustoTotal;
	}

	public void setValorCustoTotal(Double valorCustoTotal) {
		this.valorCustoTotal = valorCustoTotal;
	}

	public Integer getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(Integer margemLucro) {
		this.margemLucro = margemLucro;
	}

	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}
	
	
	
}