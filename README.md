# API REST de Controle de Livros

Este projeto é uma API RESTful avançada desenvolvida em **Java + Spring Boot** para gerenciar um cadastro de livros, seguindo rigorosos padrões RESTful (RFC 7807, cabeçalhos Location, PATCH parcial) e arquitetura validada por SDRs (System Design Reviews). O armazenamento dos dados é realizado em memória.

## 👥 Alunos
* Carlos Kvasir Lima

## 🛠️ Tecnologias e Ferramentas

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3.3.x
* **Build Tool:** Maven (Wrapper)
* **Qualidade:** Testes Unitários e de Integração (JUnit 5 + MockMvc)
* **Infraestrutura:** Docker e Docker Compose (com Hot-Reload mapeado para Dev)

## 🚀 Como Executar (Ambiente de Desenvolvimento)

O ambiente foi totalmente dockerizado com **Live Reload**. Qualquer alteração feita e salva no código da sua IDE será refletida automaticamente na API em menos de 1 segundo.

1. Certifique-se de ter o Docker instalado e rodando.
2. Na raiz do projeto, suba a aplicação em background:
   ```bash
   docker compose up -d
   ```
3. A API estará disponível na porta `8000`: **http://localhost:8000/**

## 📚 Endpoints e Documentação

Para facilitar os testes (via Postman, Insomnia ou Navegador), **acesse a raiz da aplicação (`http://localhost:8000/`)**. 
Nós criamos uma "Vitrine" (HomeController) que retornará um JSON detalhando todos os endpoints disponíveis, seus métodos HTTP e exemplos de payloads esperados para cadastro e atualização.

As documentações das decisões arquiteturais (SDRs) e padrões da IA (GEMINI.md) estão armazenadas na pasta `/dev-docs/`.

## 📜 Licença

Este projeto está licenciado sob a **Mozilla Public License Version 2.0 (MPL-2.0)**.
Copyright (c) 2026 Carlos Kvasir - [carloskvasir.dev](https://carloskvasir.dev)

Veja o arquivo [LICENSE](LICENSE) para mais detalhes sobre as permissões e limitações.
