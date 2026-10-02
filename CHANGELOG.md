## [1.1.0] - 2026-10-02

### 🚀 Features

- Adiciona script de automacao de releases locais (git-cliff)

### 📚 Documentation

- Formaliza fluxo obrigatorio de releases, tags e changelogs
- Transforma dev-docs/readme em um indice estruturado de SDRs
## [1.0.0] - 2026-10-02

### 🚀 Features

- Implementa api de controle de livros
- Adiciona HomeController (/) para facilitar testes manuais e altera porta Docker para 8000
- Adiciona CommandLineRunner (DataSeeder) para popular API com dados iniciais
- Integra padrao OpenAPI (Swagger UI) para documentacao e testes interativos (SDR-006)
- Move interface Swagger UI para a raiz e centraliza a documentacao (textos do projeto) no padrao OpenAPI

### 🐛 Bug Fixes

- Resolve bug de rede do docker usando network_mode host e ajusta porta para 8080

### 📚 Documentation

- Configura diretrizes da IA e cria documentacao base (SDRs e GEMINI.md)
- Aprimora padrao de SDR baseado no modelo de revisao do Bruno Russo
- Atualiza readme e adiciona SDR-005 documentando o hot-reload via docker
- Migra projeto para a licenca MPL-2.0 (Carlos Kvasir)
- Adiciona David Marlon na secao de alunos do README
- Adiciona David Marlon na secao de alunos do OpenAPI (Swagger)
- Adiciona link do repositorio oficial no inicio do README
- Exporta swagger ui estatico para hospedagem no github pages
- Adiciona link publico direto do github pages no readme
- Adiciona SDR-007 documentando os seeds e o github pages
- Inicializa CHANGELOG.md seguindo o padrao keep-a-changelog
- Adiciona diretrizes rigorosas para a IA automatizar atualizacoes de Changelog e SDRs
- Reforca manifesto de IA com regras de sanity check, commits atomicos e boy scout

### 🚜 Refactor

- Eleva maturidade restful da aplicacao (Location, RFC7807, PATCH, Paginacao)

### 🧪 Testing

- Implenta cultura de testes (SDR-003) e validacoes
- Implementa cultura de testes unitarios e integrados (SDR-003)

### ⚙️ Miscellaneous Tasks

- Setup inicial do projeto de Controle de Livros
- Adiciona suporte a docker multi-stage e docker-compose (SDR-004)
- Configura hot-reload via volume no docker-compose para dev
- Limpa repositorio removendo PDF do trabalho, plano de execucao e arquivos temporarios
- Realiza release da versao 1.0.0 e sincroniza pom.xml
