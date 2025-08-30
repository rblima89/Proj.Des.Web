package com.exemplo.turmas.domain.service;

import com.exemplo.turmas.domain.dto.TurmaCreateDto;
import com.exemplo.turmas.domain.dto.TurmaDto;
import com.exemplo.turmas.domain.entity.Turma;
import com.exemplo.turmas.domain.repository.TurmaRepository;
import com.exemplo.turmas.infra.exception.NoContentException;
import com.exemplo.turmas.infra.exception.NotFoundException;
import com.exemplo.turmas.infra.mapper.TurmaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TurmaService {
    private final TurmaRepository repo;

    public TurmaService(TurmaRepository repo){ this.repo = repo; }

    @Transactional
    public TurmaDto criar(TurmaCreateDto dto){
        Turma salvo = repo.save(TurmaMapper.toEntity(dto));
        return TurmaMapper.toDto(salvo);
    }

    @Transactional(readOnly = true)
    public TurmaDto buscarPorId(Long id){
        Turma t = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Turma id %d não encontrada".formatted(id)));
        return TurmaMapper.toDto(t);
    }

    @Transactional(readOnly = true)
    public List<TurmaDto> listar(String nome, String periodo, String curso){
        List<Turma> lista;
        if (nome != null && !nome.isBlank()){
            lista = repo.findByNomeContainingIgnoreCase(nome);
        } else if (periodo != null && !periodo.isBlank()){
            lista = repo.findByPeriodoIgnoreCase(periodo);
        } else if (curso != null && !curso.isBlank()){
            lista = repo.findByCursoIgnoreCase(curso);
        } else {
            lista = repo.findAll();
        }
        if (lista.isEmpty()) throw new NoContentException();
        return lista.stream().map(TurmaMapper::toDto).toList();
    }

    @Transactional
    public void deletar(Long id){
        if (!repo.existsById(id)) {
            throw new NotFoundException("Turma id %d não encontrada".formatted(id));
        }
        repo.deleteById(id);
    }
}
