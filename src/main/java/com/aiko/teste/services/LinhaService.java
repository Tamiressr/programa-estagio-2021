package com.aiko.teste.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.teste.domain.Linha;
import com.aiko.teste.repositories.LinhaRepository;
import com.aiko.teste.repositories.ParadaRepository;
import com.aiko.teste.repositories.VeiculoRepository;
import com.aiko.teste.services.exceptions.ObjectNotFoundException;
@Service
public class LinhaService {

	
	@Autowired
	private LinhaRepository linhaRepository;
	@Autowired
	private ParadaRepository paradaRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Transactional
	public Linha insert(Linha obj) {
				obj= linhaRepository.save(obj);
				paradaRepository.saveAll(obj.getParadas());
				veiculoRepository.saveAll(obj.getVeiculos());
				return obj;
	}

	public Linha find(long id) {
		Optional<Linha> linha= linhaRepository.findById(id);
		return linha.orElseThrow(()-> new  ObjectNotFoundException(
				"Objeto não encontrado! Id:"+id+",Tipo: "+ Linha.class.getName()));
	}

	public List<Linha> findAll() {
		List<Linha>linhas=linhaRepository.findAll();
		return linhas;
	}

	public void delete(long id) {
		find(id);
		linhaRepository.deleteById(id);
		
	}

	public Linha update(Linha obj) {
		//busca o obj, caso não exista lança excessão
		Linha p= find(obj.getId());
		updateData(p, obj);
		
		return linhaRepository.save(p);
		}
	
	
	//método auxiliar para atualização de dados
	private void updateData(Linha p, Linha obj){
	
		p.setName(obj.getName());
		p.setParadas(obj.getParadas());
		
	}

}
