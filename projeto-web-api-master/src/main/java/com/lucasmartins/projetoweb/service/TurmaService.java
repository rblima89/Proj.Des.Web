package com.lucasmartins.projetoweb.service;

import com.lucasmartins.projetoweb.controller.dto.TurmaDto;
import com.lucasmartins.projetoweb.model.repository.TurmaRepository;
import com.lucasmartins.projetoweb.model.repository.entity.TurmaEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public TurmaDto cadastrarTurma(TurmaDto turmaDto) {
        final TurmaEntity turmaEntity = new TurmaEntity();
        turmaEntity.setNome(turmaDto.getNome());
        turmaEntity.setCurso(turmaDto.getCurso());
        turmaEntity.setPeriodo(turmaDto.getPeriodo());

        final TurmaEntity turmaCadastrada = turmaRepository.save(turmaEntity);

        final TurmaDto turmaDtoCadastrada = new TurmaDto();
        turmaDtoCadastrada.setId(turmaCadastrada.getId());
        turmaDtoCadastrada.setNome(turmaCadastrada.getNome());
        turmaDtoCadastrada.setCurso(turmaCadastrada.getCurso());
        turmaDtoCadastrada.setPeriodo(turmaCadastrada.getPeriodo());

        return turmaDtoCadastrada;
    }

    public TurmaDto findById(int turmaId) {
        final Optional<TurmaEntity> turmaEntity = turmaRepository.findById(turmaId);
        if (turmaEntity.isEmpty()) {
            throw new RuntimeException("Turma nao encontrada");
        }
        final TurmaDto turmaDto = new TurmaDto();
        turmaDto.setId(turmaEntity.get().getId());
        turmaDto.setNome(turmaEntity.get().getNome());
        turmaDto.setCurso(turmaEntity.get().getCurso());
        turmaDto.setPeriodo(turmaEntity.get().getPeriodo());

        return turmaDto;
    }


    public TurmaDto findByNome(String nome) {
        final TurmaEntity turma = turmaRepository.findByNome(nome);
        if (turma == null) {
            throw new RuntimeException("Turma nao encontrada");
        }
        final TurmaDto turmaDto = new TurmaDto();
        turmaDto.setId(turma.getId());
        turmaDto.setNome(turma.getNome());
        turmaDto.setCurso(turma.getCurso());
        turmaDto.setPeriodo(turma.getPeriodo());

        return turmaDto;
    }
}
