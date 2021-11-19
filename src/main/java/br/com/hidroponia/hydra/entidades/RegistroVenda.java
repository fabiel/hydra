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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "registro_venda")
public class RegistroVenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade={CascadeType.DETACH})
	@JoinColumn(name = "id_cliente", nullable=false)
	private Cliente cliente;
	
	@JoinTable(	name="registro_venda_produto", 
			joinColumns=@JoinColumn(name="id_registro"), 
			inverseJoinColumns=@JoinColumn(name="id_produto"), 
			uniqueConstraints=@UniqueConstraint(columnNames={"id_registro", "id_produto"}))	
	@OneToMany(cascade=CascadeType.ALL)
	private List<RegistroVendaItem> produtos;
	
	@Column(name = "valor_venda")
	private Double valorVenda;
	
	@Column
	private String observacoes;
	
	@Column(name = "nota_fiscal")
	private String notaFiscal;
	
	@Column(name = "data_venda", columnDefinition = "DATE")
	private LocalDate dataVenda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<RegistroVendaItem> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<RegistroVendaItem> produtos) {
		this.produtos = produtos;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	
	
}