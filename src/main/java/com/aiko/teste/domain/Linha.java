package com.aiko.teste.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Linha implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	@ManyToMany(mappedBy = "linhas", cascade = CascadeType.ALL)
	private List<Parada> paradas = new ArrayList<>();
	@OneToMany(mappedBy = "linhaId", cascade = CascadeType.ALL)
	private List<Veiculo> veiculos;

	public Linha() {

	}



	public Linha(String name, List<Parada> paradas, List<Veiculo> veiculos) {
		super();
		this.name = name;
		this.paradas = paradas;
		this.veiculos = veiculos;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Parada> getParadas() {
		return paradas;
	}

	public void setParadas(List<Parada> paradas) {
		this.paradas = paradas;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
