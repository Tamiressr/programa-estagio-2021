package com.aiko.teste.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.teste.domain.Parada;
import com.aiko.teste.repositories.ParadaRepository;
import com.aiko.teste.services.exceptions.ObjectNotFoundException;
@Service
public class ParadaService {
	
	@Autowired
	private ParadaRepository paradaRepository;
	
	@Transactional
	public Parada insert( Parada obj) {
		obj.setId(0);
		obj= paradaRepository.save(obj);
		return obj;
	}
	public Parada find(long id) {
		Optional<Parada> p= paradaRepository.findById(id);
		return p.orElseThrow(()-> new  ObjectNotFoundException(
				"Objeto não encontrado! Id:"+id+",Tipo: "+ Parada.class.getName()));
	}
	public List<Parada> findAll() {
		List<Parada>paradas=paradaRepository.findAll();
		return paradas;
	}
	public Parada update(Parada obj) {
		//busca o obj, caso não exista lança excessão
		Parada p= find(obj.getId());
		updateData(p, obj);
		
		return paradaRepository.save(p);
		}
	
	
	//método auxiliar para atualização de dados
	private void updateData(Parada p, Parada obj){
	
		p.setName(obj.getName());
		p.setLatitude(obj.getLatitude());
		p.setLongitude(obj.getLongitude());
		
	}
	public void delete(long id) {
		find(id);

			paradaRepository.deleteById(id);
		
	}
}
