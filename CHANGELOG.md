# Changelog

Todos os marcos e mudanças notáveis neste projeto serão documentados neste arquivo.

O formato baseia-se no [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/),
e este projeto adota o [Versionamento Semântico](https://semver.org/lang/pt-BR/).

## [1.0.0] - 2026-10-01

### Intenção do Pacote
Estabelecer a primeira versão estável (MVP) de uma API RESTful de nível profissional para o controle de livros em memória. 
O foco desta entrega não foi apenas cumprir os requisitos funcionais básicos (CRUD), mas sim estruturar **um alicerce arquitetural definitivo, testado, conteinerizado e impecavelmente documentado**. Essa blindagem (SDRs, Swagger, Docker, Tratamento RFC 7807) garante que as próximas versões — como a futura integração de um banco de dados relacional — sejam feitas sem qualquer risco de quebrar o contrato da API original.

### Added
- Estabelecimento do processo contínuo de Git Tags e Releases via CLI nas diretrizes da IA (`GEMINI.md`), exigindo links dinâmicos para o Changelog.
- Atualização do manifesto `GEMINI.md` com diretrizes estritas de Sanity Check, Commits Atômicos, Regra do Escoteiro e Anti-Destruição de Código.
- Inicialização estrutural do projeto em Spring Boot 3.3 e Java 21 (Camadas: `controllers`, `services`, `dtos`, `models`, `exceptions`).
- Suporte a operações completas e parciais via REST (`GET`, `POST`, `PUT`, `PATCH`, `DELETE`).
- Tratamento global de exceções formatado em JSON seguindo o padrão RFC 7807 (`ProblemDetail`).
- Inserção de cabeçalhos maduros como o `Location` (status 201).
- Infraestrutura completa de testes Unitários e de Integração (JUnit 5, MockMvc, AssertJ).
- Dockerização com suporte a Hot-Reload para agilidade no ambiente de desenvolvimento (`docker-compose.yml`).
- Componente `DataSeeder` para popular a base em memória automaticamente com 5 registros clássicos de imediato.
- Integração do pacote **Springdoc OpenAPI** gerando uma interface visual do Swagger UI na raiz da aplicação (`/`).
- Criação e hospedagem de documentação estática do Swagger na pasta `/docs` via GitHub Pages.
- Arquitetura documentada via SDRs (System Design Records) na pasta `dev-docs/`.
- Repositório sob os termos da licença livre Mozilla Public License Version 2.0 (MPL-2.0).


---
[1.0.0]: https://github.com/carloskvasir/api_rest_spring/releases/tag/v1.0.0
