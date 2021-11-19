package br.com.hidroponia.hydra.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Insumo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;
	
	@Column(name = "tipo_insumo")
	@Enumerated(EnumType.STRING)
	private TipoInsumoEnum tipoInsumo;

	@Column(name = "unidade_medida")
	@Enumerated(EnumType.STRING)
	private UnidadeMedidaEnum unidadeMedida;
	
	@Column(name = "estoque_atual")
	private Integer estoqueAtual;
	
	@Column(name = "estoque_minimo")
	private Integer estoqueMinimo;
	
	@Column(name = "custo_atual")
	private Double custoAtual;
	
	@ElementCollection
	@CollectionTable(name="insumo_fotos", joinColumns=@JoinColumn(name="id_insumo"))
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

	public TipoInsumoEnum getTipoInsumo() {
		return tipoInsumo;
	}

	public void setTipoInsumo(TipoInsumoEnum tipoInsumo) {
		this.tipoInsumo = tipoInsumo;
	}

	public UnidadeMedidaEnum getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedidaEnum unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Integer getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(Integer estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public Integer getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(Integer estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public Double getCustoAtual() {
		return custoAtual;
	}

	public void setCustoAtual(Double custoAtual) {
		this.custoAtual = custoAtual;
	}

	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}
	
	
}
