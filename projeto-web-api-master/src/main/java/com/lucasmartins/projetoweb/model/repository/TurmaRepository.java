package com.lucasmartins.projetoweb.model.repository;

import com.lucasmartins.projetoweb.model.repository.entity.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaEntity, Integer> {

    TurmaEntity findByNome(String nome);

}
