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
@Table(name = "registro_custo_operacional")
public class RegistroCustoOperacional implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "DATE")
	private LocalDate data;
	
	@JoinTable(	name="registro_custo_operacional_conta", 
			joinColumns=@JoinColumn(name="id_registro"), 
			inverseJoinColumns=@JoinColumn(name="id_conta"), 
			uniqueConstraints=@UniqueConstraint(columnNames={"id_registro", "id_conta"}))	
	@OneToMany(cascade=CascadeType.ALL)
	private List<RegistroCustoOperacionalItem> contas;
	
	@Column
	private Double custo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<RegistroCustoOperacionalItem> getContas() {
		return contas;
	}

	public void setContas(List<RegistroCustoOperacionalItem> contas) {
		this.contas = contas;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}
	
	
	
}