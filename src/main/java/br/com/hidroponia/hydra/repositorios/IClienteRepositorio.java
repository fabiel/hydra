package br.com.hidroponia.hydra.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.hidroponia.hydra.entidades.Cliente;

public interface IClienteRepositorio extends PagingAndSortingRepository<Cliente, Long> {

	
}
