# API REST de Controle de Livros

Este projeto é uma API RESTful simples desenvolvida em **Java + Spring Boot** para gerenciar um cadastro de livros. O armazenamento dos dados é realizado temporariamente em memória.

## 👥 Alunos
* Carlos Kvasir Lima

## 🛠️ Tecnologias e Ferramentas

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3.x
* **Build Tool:** Maven
* **Gerenciador de Ambiente:** mise

## 🚀 Como Executar

1. Certifique-se de ter o `mise` configurado no seu sistema para gerenciar o Java.
2. Na raiz do projeto, instale as ferramentas necessárias:
   ```bash
   mise install
   ```
3. Execute a aplicação utilizando o Maven Wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```

A API estará disponível em `http://localhost:8080/`.

## 📚 Endpoints Disponíveis

* `POST /livros` - Cadastrar um novo livro
* `GET /livros` - Listar todos os livros cadastrados
* `GET /livros/{id}` - Buscar um livro específico pelo ID
* `PUT /livros/{id}` - Atualizar os dados de um livro existente
* `DELETE /livros/{id}` - Remover um livro pelo ID
