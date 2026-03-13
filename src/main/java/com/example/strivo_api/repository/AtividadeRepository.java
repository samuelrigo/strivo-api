package com.example.strivo_api.repository;

import com.example.strivo_api.model.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade,Long> {
}
