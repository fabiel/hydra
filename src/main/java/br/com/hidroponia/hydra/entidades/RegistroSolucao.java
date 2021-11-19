package br.com.hidroponia.hydra.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "registro_solucao")
public class RegistroSolucao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo_solucao")
	@Enumerated(EnumType.STRING)
	private TipoSolucaoEnum tipoSolucao;
	
	@Column(columnDefinition = "DATE")
	private LocalDate data;
	
	@JoinTable(	name="registro_solucao_insumo", 
			joinColumns=@JoinColumn(name="id_registro"), 
			inverseJoinColumns=@JoinColumn(name="id_insumo"), 
			uniqueConstraints=@UniqueConstraint(columnNames={"id_registro", "id_insumo"}))	
	@OneToMany(cascade=CascadeType.ALL)
	private List<RegistroSolucaoItem> insumos;
	
	@Column(name = "custo_total")
	private Double custoTotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoSolucaoEnum getTipoSolucao() {
		return tipoSolucao;
	}

	public void setTipoSolucao(TipoSolucaoEnum tipoSolucao) {
		this.tipoSolucao = tipoSolucao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<RegistroSolucaoItem> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<RegistroSolucaoItem> insumos) {
		this.insumos = insumos;
	}

	public Double getCustoTotal() {
		return custoTotal;
	}

	public void setCustoTotal(Double custoTotal) {
		this.custoTotal = custoTotal;
	}
	
	
}