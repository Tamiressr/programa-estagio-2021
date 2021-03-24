package com.aiko.teste.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String modelo;
	private long linhaId;
	
	
	public Veiculo() {
		
	}
		
	
	public Veiculo(long id, String name, String modelo, long linhaId) {
		this.id = id;
		this.name = name;
		this.modelo = modelo;
		this.linhaId = linhaId;
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public long getLinhaId() {
		return linhaId;
	}
	public void setLinhaId(long linhaId) {
		this.linhaId = linhaId;
	}


}
