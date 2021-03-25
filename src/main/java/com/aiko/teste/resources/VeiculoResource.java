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

import com.aiko.teste.domain.Veiculo;
import com.aiko.teste.services.VeiculoService;

@RestController
@RequestMapping(value="/veiculos")
public class VeiculoResource {
	@Autowired
	private VeiculoService veiculoService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Veiculo obj){
		Veiculo veiculo=veiculoService.insert(obj);
		//pega a uri do novo recurso que foi inserido
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Veiculo> findById(@PathVariable long id){
		
		Veiculo veiculo=veiculoService.find(id);
		return ResponseEntity.ok().body(veiculo);		
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Veiculo>> findAll(){
		List <Veiculo> veiculo=veiculoService.findAll();
		return ResponseEntity.ok().body(veiculo);		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Veiculo> update(@Valid @RequestBody  Veiculo p,@PathVariable long id){
		Veiculo obj=new Veiculo(p.getId(),p.getName(), p.getModelo(),p.getLinhaId());
		obj.setId(id);
			obj= veiculoService.update(obj);
		return ResponseEntity.noContent().build();		
	}
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Veiculo> delete(@PathVariable long id) {
		veiculoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
