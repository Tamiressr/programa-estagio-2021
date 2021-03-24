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

import com.aiko.teste.domain.Parada;
import com.aiko.teste.services.ParadaService;


@RestController
@RequestMapping(value="/paradas")
public class ParadaResource {

	@Autowired
	private ParadaService paradaService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Parada obj){
		Parada parada=paradaService.insert(obj);
		//pega a uri do novo recurso que foi inserido
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(parada.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Parada> findById(@PathVariable long id){
		
		Parada parada=paradaService.find(id);
		return ResponseEntity.ok().body(parada);		
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Parada>> findAll(){
		List <Parada> parada=paradaService.findAll();
		return ResponseEntity.ok().body(parada);		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Parada> update(@Valid @RequestBody  Parada p,@PathVariable long id){
		Parada obj=new Parada(p.getId(),p.getName(),p.getLatitude(),p.getLongitude());
		obj.setId(id);
			obj= paradaService.update(obj);
		return ResponseEntity.noContent().build();		
	}
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Parada> delete(@PathVariable Integer id) {
		 paradaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
