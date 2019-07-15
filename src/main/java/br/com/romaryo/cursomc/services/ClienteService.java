package br.com.romaryo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.romaryo.cursomc.domain.Cliente;
import br.com.romaryo.cursomc.repositories.ClienteRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) throws ObjectNotFoundException{
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" + id + "  Tipo: " + Cliente.class.getName()));
	}
}
