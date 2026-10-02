package com.api.livros.config;

import com.api.livros.dtos.LivroRequestDTO;
import com.api.livros.services.LivroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder implements CommandLineRunner {

    private final LivroService livroService;

    public DataSeeder(LivroService livroService) {
        this.livroService = livroService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Popula a base em memória apenas se estiver vazia (evita duplicação em live-reloads complexos)
        if (livroService.listarTodos(0, 1).isEmpty()) {
            System.out.println("🌱 Semeando dados iniciais (Seeds)...");
            livroService.salvar(new LivroRequestDTO("Clean Code", "Robert Martin", 464, 120.0));
            livroService.salvar(new LivroRequestDTO("O Guia do Mochileiro das Galáxias", "Douglas Adams", 208, 42.0));
            livroService.salvar(new LivroRequestDTO("Duna", "Frank Herbert", 600, 90.0));
            livroService.salvar(new LivroRequestDTO("1984", "George Orwell", 328, 45.0));
            livroService.salvar(new LivroRequestDTO("O Senhor dos Anéis", "J.R.R. Tolkien", 1200, 150.0));
            System.out.println("✅ Seeds inseridos com sucesso!");
        }
    }
}
