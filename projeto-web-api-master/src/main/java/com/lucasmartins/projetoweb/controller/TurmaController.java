package com.lucasmartins.projetoweb.controller;

import com.lucasmartins.projetoweb.controller.dto.TurmaDto;
import com.lucasmartins.projetoweb.service.TurmaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public TurmaDto cadastrarTurma(@RequestBody TurmaDto turmaDto) {
        return turmaService.cadastrarTurma(turmaDto);
    }

    @GetMapping("/{turmaId}")
    @ResponseStatus(code = HttpStatus.OK)
    public TurmaDto buscarTurmaPorId(@PathVariable int turmaId) {
        return turmaService.findById(turmaId);
    }

    @GetMapping("/nome/{nome}")
    @ResponseStatus(code = HttpStatus.OK)
    public TurmaDto buscarTurmaPorNome(@PathVariable String nome) {
        return turmaService.findByNome(nome);
    }
}
