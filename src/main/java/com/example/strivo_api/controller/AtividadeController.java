package com.example.strivo_api.controller;

import com.example.strivo_api.model.Atividade;
import com.example.strivo_api.service.AtividadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AtividadeController {

    @Autowired
    private AtividadeService service;

    @GetMapping("/atividades")
    public List<Atividade> getAtividades() {
        return service.getAtividades();
    }

    @PostMapping("/atividades")
    public Atividade adicionarAtividade(@Valid @RequestBody Atividade atividade) {
        return service.adicionarAtividade(atividade);
    }

    @GetMapping("/atividades/{id}")
    public ResponseEntity<Atividade> getAtividadeById(@PathVariable Long id) {
        return service.getAtividadeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/atividades/{id}")
    public ResponseEntity<Atividade> deletarAtividade(@PathVariable Long id) {
        return service.deletarAtividade(id)
                .map(a -> ResponseEntity.noContent().<Atividade>build())
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/atividades/{id}")
    public ResponseEntity<Atividade> atualizarAtividade(@Valid @PathVariable Long id, @RequestBody Atividade atividade) {
        return service.atualizarAtividade(id, atividade)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}