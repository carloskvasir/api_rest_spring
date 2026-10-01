package com.api.livros.services;

import com.api.livros.dtos.LivroRequestDTO;
import com.api.livros.exceptions.ResourceNotFoundException;
import com.api.livros.models.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LivroService {
    private final List<Livro> livros = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public Livro salvar(LivroRequestDTO dto) {
        Livro livro = new Livro();
        livro.setId(idCounter.getAndIncrement());
        livro.setTitulo(dto.titulo());
        livro.setAutor(dto.autor());
        livro.setQuantidadePaginas(dto.quantidadePaginas());
        livro.setPreco(dto.preco());
        livros.add(livro);
        return livro;
    }

    public List<Livro> listarTodos() {
        return new ArrayList<>(livros);
    }

    public Livro buscarPorId(Long id) {
        return livros.stream()
            .filter(l -> l.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado com id: " + id));
    }

    public Livro atualizar(Long id, LivroRequestDTO dto) {
        Livro livro = buscarPorId(id);
        livro.setTitulo(dto.titulo());
        livro.setAutor(dto.autor());
        livro.setQuantidadePaginas(dto.quantidadePaginas());
        livro.setPreco(dto.preco());
        return livro;
    }

    public void remover(Long id) {
        Livro livro = buscarPorId(id);
        livros.remove(livro);
    }
}
