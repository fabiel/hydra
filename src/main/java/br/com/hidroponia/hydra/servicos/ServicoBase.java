package br.com.hidroponia.hydra.servicos;

import br.com.hidroponia.hydra.exceptions.HydraException;

public interface ServicoBase<T> {

	T salvar(T object) throws HydraException;

	T atualizar(T object) throws HydraException;

	void excluir(Long id) throws HydraException;
	
	
}
