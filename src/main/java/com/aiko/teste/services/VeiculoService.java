package com.aiko.teste.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.teste.domain.Veiculo;
import com.aiko.teste.repositories.VeiculoRepository;
import com.aiko.teste.services.exceptions.ObjectNotFoundException;
@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Transactional
	public Veiculo insert( Veiculo obj) {
		obj.setId(0);
		obj= veiculoRepository.save(obj);
		return obj;
	}
	public Veiculo find(long id) {
		Optional<Veiculo> p= veiculoRepository.findById(id);
		return p.orElseThrow(()-> new  ObjectNotFoundException(
				"Objeto não encontrado! Id:"+id+",Tipo: "+ Veiculo.class.getName()));
	}
	public List<Veiculo> findAll() {
		List<Veiculo>veiculos=veiculoRepository.findAll();
		return veiculos;
	}
	public Veiculo update(Veiculo obj) {
		//busca o obj, caso não exista lança excessão
		Veiculo v= find(obj.getId());
		updateData(v, obj);
		
		return veiculoRepository.save(v);
		}
	
	
	//método auxiliar para atualização de dados
	private void updateData(Veiculo v, Veiculo obj){
	
		v.setName(obj.getName());
		v.setModelo(obj.getModelo());
		v.setLinhaId(obj.getLinhaId());

	}
	
	public void delete(long id) {
		find(id);

			veiculoRepository.deleteById(id);
		
	}
}
