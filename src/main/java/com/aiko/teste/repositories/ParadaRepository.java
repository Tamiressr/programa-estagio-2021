package com.aiko.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiko.teste.domain.Parada;
@Repository
public interface ParadaRepository extends JpaRepository<Parada, Long> {

}
