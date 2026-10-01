package com.api.livros.services;

import com.api.livros.dtos.LivroRequestDTO;
import com.api.livros.exceptions.ResourceNotFoundException;
import com.api.livros.models.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    public List<Livro> listarTodos(int page, int size) {
        int start = Math.min(page * size, livros.size());
        int end = Math.min((page + 1) * size, livros.size());
        return new ArrayList<>(livros.subList(start, end));
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

    public Livro atualizarParcial(Long id, Map<String, Object> campos) {
        Livro livro = buscarPorId(id);
        campos.forEach((campo, valor) -> {
            switch (campo) {
                case "titulo" -> livro.setTitulo((String) valor);
                case "autor" -> livro.setAutor((String) valor);
                case "quantidadePaginas" -> livro.setQuantidadePaginas((Integer) valor);
                case "preco" -> {
                    if (valor instanceof Integer v) {
                        livro.setPreco(v.doubleValue());
                    } else if (valor instanceof Double v) {
                        livro.setPreco(v);
                    }
                }
            }
        });
        return livro;
    }

    public void remover(Long id) {
        Livro livro = buscarPorId(id);
        livros.remove(livro);
    }
}
