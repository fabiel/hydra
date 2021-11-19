package br.com.hidroponia.hydra.servicos;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.hidroponia.hydra.entidades.Cliente;
import br.com.hidroponia.hydra.exceptions.HydraException;
import br.com.hidroponia.hydra.repositorios.IClienteRepositorio;

@ServicoTransacional
public class ClienteServico implements ServicoBase<Cliente> {

	@Autowired
	private IClienteRepositorio clienteRepo;

	@Override
	public Cliente salvar(Cliente object) throws HydraException {
		return this.clienteRepo.save(object);
	}

	@Override
	public Cliente atualizar(Cliente object) throws HydraException {
		return this.clienteRepo.save(object);
	}

	@Override
	public void excluir(Long id) throws HydraException {
		this.clienteRepo.deleteById(id);
	}

}
