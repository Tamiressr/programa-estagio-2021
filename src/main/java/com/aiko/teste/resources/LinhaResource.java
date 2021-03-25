package com.aiko.teste.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aiko.teste.domain.Linha;
import com.aiko.teste.domain.Parada;
import com.aiko.teste.domain.Veiculo;
import com.aiko.teste.services.LinhaService;
import com.aiko.teste.services.ParadaService;
import com.aiko.teste.services.VeiculoService;

@RestController
@RequestMapping(value="/linhas")
public class LinhaResource {

	
	@Autowired
	private LinhaService linhaService;
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Linha obj){
		
		Linha linha=linhaService.insert(obj);
		//pega a uri do novo recurso que foi inserido
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(linha.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Linha> find(@PathVariable long id) {

			
		Linha obj= linhaService.find(id);
			 
			return ResponseEntity.ok().body(obj);
		
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Linha>> findAll() {

			
			List<Linha>list= linhaService.findAll();
			
		return ResponseEntity.ok().body(list);
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody  Linha obj,@PathVariable Integer id){
	
		
		obj.setId(id);
		obj= linhaService.update(obj);
		return ResponseEntity.noContent().build();		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity< Linha> delete(@PathVariable Integer id) {
		 linhaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
