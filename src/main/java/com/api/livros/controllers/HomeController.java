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
        apiInfo.put("documentacao_swagger", "Acesse a interface interativa em: http://localhost:8080/swagger-ui.html");
        
        List<Map<String, String>> rotas = List.of(
            Map.of("metodo", "GET", "rota", "/livros", "descricao", "Lista todos os livros (suporta ?page=0&size=10)"),
            Map.of("metodo", "GET", "rota", "/livros/{id}", "descricao", "Busca um livro específico pelo ID"),
            Map.of("metodo", "POST", "rota", "/livros", "descricao", "Cadastra um novo livro."),
            Map.of("metodo", "PUT", "rota", "/livros/{id}", "descricao", "Atualiza integralmente um livro"),
            Map.of("metodo", "PATCH", "rota", "/livros/{id}", "descricao", "Atualiza parcialmente um livro"),
            Map.of("metodo", "DELETE", "rota", "/livros/{id}", "descricao", "Remove um livro pelo ID"),
            Map.of("metodo", "GET", "rota", "/swagger-ui.html", "descricao", "Interface visual OpenAPI (Swagger)")
        );
        
        apiInfo.put("rotas_disponiveis", rotas);
        
        return apiInfo;
    }
}
