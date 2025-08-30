package com.exemplo.turmas.domain.repository;

import com.exemplo.turmas.domain.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    List<Turma> findByNomeContainingIgnoreCase(String nome);
    List<Turma> findByPeriodoIgnoreCase(String periodo);
    List<Turma> findByCursoIgnoreCase(String curso);
}
