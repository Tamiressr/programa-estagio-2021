package com.aiko.teste.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiko.teste.domain.Linha;
import com.aiko.teste.repositories.LinhaRepository;
import com.aiko.teste.repositories.ParadaRepository;
@Service
public class LinhaService {

	
	@Autowired
	private LinhaRepository linhaRepository;
	@Autowired
	private ParadaRepository paradaRepository;
	
	@Transactional
	public Linha insert(@Valid Linha obj) {
		//garante que está salvando um obj novo
				obj.setId(0);
				obj= linhaRepository.save(obj);
				paradaRepository.saveAll(obj.getParadas());
				return obj;
	}

	public Linha find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Linha> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public @Valid Linha update(@Valid Linha obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
