package com.exemplo.turmas.api;

import com.exemplo.turmas.domain.dto.TurmaCreateDto;
import com.exemplo.turmas.domain.dto.TurmaDto;
import com.exemplo.turmas.domain.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService service;
    public TurmaController(TurmaService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<TurmaDto> criar(@RequestBody @Valid TurmaCreateDto dto){
        TurmaDto salvo = service.criar(dto);
        return ResponseEntity.created(URI.create("/turmas/" + salvo.getId())).body(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<TurmaDto>> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String periodo,
            @RequestParam(required = false) String curso
    ){
        return ResponseEntity.ok(service.listar(nome, periodo, curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
