package com.lucasmartins.projetoweb.model.repository.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "turma")
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome_da_turma")
    private String nome;

    @Column(name = "curso")
    private String curso;

    @Column(name = "perido_da_turma")
    private String periodo;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AlunoEntity> alunos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<AlunoEntity> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoEntity> alunos) {
        this.alunos = alunos;
    }
}
