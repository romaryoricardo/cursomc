package br.com.romaryo.cursomc.resourses;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.romaryo.cursomc.domain.Pedido;
import br.com.romaryo.cursomc.services.PedidoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;
	
	
	//@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Pedido> find(@PathVariable Integer id) throws ObjectNotFoundException{
		
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj) throws ObjectNotFoundException {
		obj = service.insert(obj);
		// PADRAO RETORNAR URL COM O ID QUE FOI CRIADO
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
}
