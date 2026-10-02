# Changelog

Todos os marcos e mudanças notáveis neste projeto serão documentados neste arquivo.

O formato baseia-se no [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/) e é gerado automaticamente via `git-cliff`.

## [1.4.0](https://github.com/carloskvasir/api_rest_spring/releases/tag/v1.4.0) - 2026-10-02

### 🚀 Features

- Cria gerador de scaffolds (bin/scaffold.sh) e [**SDR-009**](dev-docs/README.md)

## [1.3.1](https://github.com/carloskvasir/api_rest_spring/releases/tag/v1.3.1) - 2026-10-02

### ⚙️ Tarefas de Manutenção (Chore)

- Release da versao 1.3.1

### 📚 Documentation

- Adiciona lombok no readme e sdr-008 no indice de governanca

## [1.3.0](https://github.com/carloskvasir/api_rest_spring/releases/tag/v1.3.0) - 2026-10-02

### ⚙️ Tarefas de Manutenção (Chore)

- Release da versao 1.3.0

### 🚀 Features

- Implementa lombok para reducao de boilerplate e pr template ([**SDR-008**](dev-docs/README.md))

## [1.2.0](https://github.com/carloskvasir/api_rest_spring/releases/tag/v1.2.0) - 2026-10-02

### ⚙️ Tarefas de Manutenção (Chore)

- Release da versao 1.2.0

### 🚀 Features

- Configura cliff.toml para rastrear sdrs e gerar links de releases no changelog
- Automatiza envio de release para o github no script de release local

## [1.1.0](https://github.com/carloskvasir/api_rest_spring/releases/tag/v1.1.0) - 2026-10-02

### ⚙️ Tarefas de Manutenção (Chore)

- Release da versao 1.1.0

### 📚 Documentation

- Formaliza fluxo obrigatorio de releases, tags e changelogs
- Transforma dev-docs/readme em um indice estruturado de SDRs

### 🚀 Features

- Adiciona script de automacao de releases locais (git-cliff)

## [1.0.0](https://github.com/carloskvasir/api_rest_spring/releases/tag/v1.0.0) - 2026-10-02

### ⚙️ Tarefas de Manutenção (Chore)

- Setup inicial do projeto de Controle de Livros
- Adiciona suporte a docker multi-stage e docker-compose ([**SDR-004**](dev-docs/README.md))
- Configura hot-reload via volume no docker-compose para dev
- Limpa repositorio removendo PDF do trabalho, plano de execucao e arquivos temporarios
- Realiza release da versao 1.0.0 e sincroniza pom.xml

### 🐛 Bug Fixes

- Resolve bug de rede do docker usando network_mode host e ajusta porta para 8080

### 📚 Documentation

- Configura diretrizes da IA e cria documentacao base (SDRs e GEMINI.md)
- Aprimora padrao de SDR baseado no modelo de revisao do Bruno Russo
- Atualiza readme e adiciona [**SDR-005**](dev-docs/README.md) documentando o hot-reload via docker
- Migra projeto para a licenca MPL-2.0 (Carlos Kvasir)
- Adiciona David Marlon na secao de alunos do README
- Adiciona David Marlon na secao de alunos do OpenAPI (Swagger)
- Adiciona link do repositorio oficial no inicio do README
- Exporta swagger ui estatico para hospedagem no github pages
- Adiciona link publico direto do github pages no readme
- Adiciona [**SDR-007**](dev-docs/README.md) documentando os seeds e o github pages
- Inicializa CHANGELOG.md seguindo o padrao keep-a-changelog
- Adiciona diretrizes rigorosas para a IA automatizar atualizacoes de Changelog e SDRs
- Reforca manifesto de IA com regras de sanity check, commits atomicos e boy scout

### 🚀 Features

- Implementa api de controle de livros
- Adiciona HomeController (/) para facilitar testes manuais e altera porta Docker para 8000
- Adiciona CommandLineRunner (DataSeeder) para popular API com dados iniciais
- Integra padrao OpenAPI (Swagger UI) para documentacao e testes interativos ([**SDR-006**](dev-docs/README.md))
- Move interface Swagger UI para a raiz e centraliza a documentacao (textos do projeto) no padrao OpenAPI

### 🚜 Refactor

- Eleva maturidade restful da aplicacao (Location, RFC7807, PATCH, Paginacao)

### 🧪 Testing

- Implenta cultura de testes ([**SDR-003**](dev-docs/README.md)) e validacoes
- Implementa cultura de testes unitarios e integrados ([**SDR-003**](dev-docs/README.md))


