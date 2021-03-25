package com.aiko.teste.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private double latitude;
	private double longitude;
	 @JsonIgnore
	@ManyToMany
	  @JoinTable(
	  name = "parada_linha", 
	  joinColumns = @JoinColumn(name = "parada_id"), 
	  inverseJoinColumns = @JoinColumn(name = "linha_id"))
	  private List<Linha> linhas;
	
	public Parada() {
		// TODO Auto-generated constructor stub
	}
	

	public Parada(String name, double latitude, double longitude) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;

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
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public List<Linha> getLinhas() {
		return linhas;
	}


	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}
	

}
