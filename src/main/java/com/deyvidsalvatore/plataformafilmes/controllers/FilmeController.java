package com.deyvidsalvatore.plataformafilmes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deyvidsalvatore.plataformafilmes.models.Filme;
import com.deyvidsalvatore.plataformafilmes.repositories.FilmeRepository;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    
    private final FilmeRepository filmeRepository;

    public FilmeController(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }

    @GetMapping
    public List<Filme> getAllFilmes() {
        return filmeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getFilmeById(@PathVariable Long id){
        Optional<Filme> filmeOptional = filmeRepository.findById(id);
        if(filmeOptional.isPresent()){
            Filme filme = filmeOptional.get();
            return ResponseEntity.ok(filme);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Filme> createFilme(@RequestBody Filme filme){
        Filme filmeCriado = filmeRepository.save(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> updateFilme(@PathVariable Long id, @RequestBody Filme filmeAtualizado) {
        Optional<Filme> filmeOptional = filmeRepository.findById(id);
        if (filmeOptional.isPresent()){
            Filme filme = filmeOptional.get();
            filme.setTitulo(filmeAtualizado.getTitulo());
            filme.setDescricao(filmeAtualizado.getDescricao());
            filme.setUrlGoogleDrive(filmeAtualizado.getUrlGoogleDrive());
            filme.setImagemCapa(filmeAtualizado.getImagemCapa());
            filmeRepository.save(filme);
            return ResponseEntity.ok(filme);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFilme(@PathVariable Long id) {
        Optional<Filme> filmeOptional = filmeRepository.findById(id);
        if(filmeOptional.isPresent()) {
            Filme filme = filmeOptional.get();
            filmeRepository.delete(filme);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Apagado com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }
}
