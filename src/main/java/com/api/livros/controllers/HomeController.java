package com.api.livros.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> apiInfo = new LinkedHashMap<>();
        apiInfo.put("nome", "API REST de Controle de Livros");
        apiInfo.put("status", "Online");
        apiInfo.put("mensagem", "Bem-vindo! Utilize as rotas abaixo para interagir com a API.");
        
        List<Map<String, String>> rotas = List.of(
            Map.of("metodo", "GET", "rota", "/livros", "descricao", "Lista todos os livros (suporta ?page=0&size=10)"),
            Map.of("metodo", "GET", "rota", "/livros/{id}", "descricao", "Busca um livro específico pelo ID"),
            Map.of("metodo", "POST", "rota", "/livros", "descricao", "Cadastra um novo livro. Exemplo payload: {\"titulo\":\"Clean Code\",\"autor\":\"Robert Martin\",\"quantidadePaginas\":464,\"preco\":120.0}"),
            Map.of("metodo", "PUT", "rota", "/livros/{id}", "descricao", "Atualiza integralmente os dados de um livro existente"),
            Map.of("metodo", "PATCH", "rota", "/livros/{id}", "descricao", "Atualiza parcialmente os dados de um livro. Exemplo payload: {\"preco\": 150.0}"),
            Map.of("metodo", "DELETE", "rota", "/livros/{id}", "descricao", "Remove um livro pelo ID")
        );
        
        apiInfo.put("rotas_disponiveis", rotas);
        
        return apiInfo;
    }
}
