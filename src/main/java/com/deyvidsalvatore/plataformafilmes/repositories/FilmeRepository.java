package com.deyvidsalvatore.plataformafilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deyvidsalvatore.plataformafilmes.models.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
    
}
