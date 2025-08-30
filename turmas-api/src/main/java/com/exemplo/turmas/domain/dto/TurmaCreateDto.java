package com.exemplo.turmas.domain.dto;

import jakarta.validation.constraints.NotBlank;

public class TurmaCreateDto {
    @NotBlank(message = "nome é obrigatório")
    private String nome;
    @NotBlank(message = "periodo é obrigatório")
    private String periodo;
    @NotBlank(message = "curso é obrigatório")
    private String curso;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
}
