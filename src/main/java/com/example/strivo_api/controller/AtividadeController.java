package com.example.strivo_api.controller;

import com.example.strivo_api.model.Atividade;
import com.example.strivo_api.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AtividadeController {

    @Autowired
    private AtividadeRepository repository;

    @GetMapping("/atividades")
    private List<Atividade> getAtividades(){
        return repository.findAll();
    }

    @PostMapping("/atividades")
    private Atividade postAtividades(@RequestBody Atividade atividade){
        return repository.save(atividade);
    }
}
