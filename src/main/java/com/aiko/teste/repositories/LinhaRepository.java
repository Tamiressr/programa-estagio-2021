package com.aiko.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiko.teste.domain.Linha;

@Repository
public interface LinhaRepository extends JpaRepository<Linha, Long>{



}
