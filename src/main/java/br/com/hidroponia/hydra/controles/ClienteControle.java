package br.com.hidroponia.hydra.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hidroponia.hydra.entidades.Cliente;
import br.com.hidroponia.hydra.servicos.ClienteServico;

@RestController
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
public class ClienteControle {

	@Autowired
	private ClienteServico clienteServico;
	
	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) throws Exception{
		return ResponseEntity.ok().body(clienteServico.salvar(cliente));
	}

	@RequestMapping(value = "/cliente", method = RequestMethod.PUT)
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente) throws Exception{
		return ResponseEntity.ok().body(clienteServico.salvar(cliente));
	}

	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> excluir(@PathVariable("id") Long id) throws Exception{
		this.clienteServico.excluir(id);
		
		return ResponseEntity.ok().body("OK");
	}
}
