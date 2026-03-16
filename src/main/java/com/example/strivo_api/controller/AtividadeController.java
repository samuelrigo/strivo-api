package com.example.strivo_api.controller;

import com.example.strivo_api.model.Atividade;
import com.example.strivo_api.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AtividadeController {

    @Autowired
    private AtividadeRepository repository;

    @GetMapping("/atividades")
    private List<Atividade> getAtividades(){
        return repository.findAll();
    }

    @PostMapping("/atividades")
    private Atividade adicionarAtividades(@RequestBody Atividade atividade){
        return repository.save(atividade);
    }

    @GetMapping("/atividades/{id}")
    public ResponseEntity<Atividade> getAtividadeById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/atividades/{id}")
    public ResponseEntity<Atividade> deleteAtividadeById(@PathVariable Long id) {
        return repository.findById(id)
                .map(atividade -> {
                    atividade.setAtivo(false);
                    repository.save(atividade);
                    return atividade;
                })
                .map(atividade -> ResponseEntity.noContent().<Atividade>build())
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/atividades/{id}")
    public ResponseEntity<Atividade> atualizarAtividadeById(@PathVariable Long id, @RequestBody Atividade atividade){
        return repository.findById(id).map(atividadeNova -> {
            atividade.setId(id);
            return repository.save(atividade);
        }).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
