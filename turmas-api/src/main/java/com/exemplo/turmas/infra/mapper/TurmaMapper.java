package com.exemplo.turmas.infra.mapper;

import com.exemplo.turmas.domain.dto.TurmaCreateDto;
import com.exemplo.turmas.domain.dto.TurmaDto;
import com.exemplo.turmas.domain.entity.Turma;

public class TurmaMapper {
    public static Turma toEntity(TurmaCreateDto dto){
        Turma t = new Turma();
        t.setNome(dto.getNome().trim());
        t.setPeriodo(dto.getPeriodo().trim());
        t.setCurso(dto.getCurso().trim());
        return t;
    }
    public static TurmaDto toDto(Turma t){
        TurmaDto dto = new TurmaDto();
        dto.setId(t.getId());
        dto.setNome(t.getNome());
        dto.setPeriodo(t.getPeriodo());
        dto.setCurso(t.getCurso());
        dto.setCriadoEm(t.getCriadoEm());
        return dto;
    }
}
