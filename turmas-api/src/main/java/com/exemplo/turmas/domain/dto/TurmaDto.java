package com.exemplo.turmas.domain.dto;

import java.time.OffsetDateTime;

public class TurmaDto {
    private Long id;
    private String nome;
    private String periodo;
    private String curso;
    private OffsetDateTime criadoEm;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    public OffsetDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(OffsetDateTime criadoEm) { this.criadoEm = criadoEm; }
}
