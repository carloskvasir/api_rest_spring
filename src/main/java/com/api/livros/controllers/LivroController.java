package com.api.livros.controllers;

import com.api.livros.dtos.LivroRequestDTO;
import com.api.livros.dtos.LivroResponseDTO;
import com.api.livros.models.Livro;
import com.api.livros.services.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<LivroResponseDTO> cadastrar(@Valid @RequestBody LivroRequestDTO dto) {
        Livro livroCriado = livroService.salvar(dto);
        return new ResponseEntity<>(LivroResponseDTO.fromEntity(livroCriado), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listar() {
        List<LivroResponseDTO> lista = livroService.listarTodos().stream()
                .map(LivroResponseDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> buscarPorId(@PathVariable Long id) {
        Livro livro = livroService.buscarPorId(id);
        return ResponseEntity.ok(LivroResponseDTO.fromEntity(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody LivroRequestDTO dto) {
        Livro livroAtualizado = livroService.atualizar(id, dto);
        return ResponseEntity.ok(LivroResponseDTO.fromEntity(livroAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        livroService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
