package com.example.strivo_api.service;

import com.example.strivo_api.model.Atividade;
import com.example.strivo_api.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository repository;

    public List<Atividade> getAtividades() {
            return repository.findAll();
    }

    public Atividade adicionarAtividade(Atividade atividade) {
        return repository.save(atividade);
    }

    public Optional<Atividade> getAtividadeById(Long id) {
        return repository.findById(id);
    }

    public Optional<Atividade> deletarAtividade(Long id) {
        return repository.findById(id).map(atividade -> {
            atividade.setAtivo(false);
            return repository.save(atividade);
        });
    }

    public Optional<Atividade> atualizarAtividade(Long id, Atividade atividade) {
        return repository.findById(id).map(atividadeExistente -> {
            atividade.setId(id);
            return repository.save(atividade);
        });
    }
}