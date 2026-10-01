# Plano de Execução: API REST de Controle de Livros

Este documento detalha o planejamento e as etapas de desenvolvimento para a API de Controle de Livros, baseada nos requisitos do PDF e nas opções arquiteturais escolhidas.

## 🛠️ Ferramentas e Versões

*   **Linguagem:** Java 21 (LTS)
*   **Framework:** Spring Boot 3.x
*   **Gerenciador de Dependências:** Maven (utilizando o wrapper `mvnw`)
*   **Gerenciador de Ambiente:** `mise` (gerenciando a versão do Java globalmente para o projeto)
*   **Arquitetura:** Camadas (Layer-based)

## 📦 Dependências do Projeto

*   `spring-boot-starter-web`: Para os endpoints REST (Tomcat embutido, Spring MVC).
*   `spring-boot-starter-validation`: Para as regras de validação usando Bean Validation (Hibernate Validator).

---

## 🏗️ Estrutura de Diretórios e Pacotes

A organização seguirá o padrão de arquitetura em camadas:

```text
src/main/java/com/api/livros/
├── LivrosApplication.java
├── controllers/
│   └── LivroController.java
├── services/
│   └── LivroService.java
├── models/
│   └── Livro.java
├── dtos/
│   ├── LivroRequestDTO.java
│   └── LivroResponseDTO.java
└── exceptions/
    ├── GlobalExceptionHandler.java
    └── ResourceNotFoundException.java
```

---

## 🚀 Etapas de Execução

### Etapa 1: Configuração Inicial e Ambiente
1. **Configurar o gerenciador `mise`:**
   * Criar o arquivo `.mise.toml` na raiz do projeto com o conteúdo:
     ```toml
     [tools]
     java = "21"
     ```
   * Executar `mise install` para instalar/vincular a versão do Java correta.
2. **Gerar o projeto Spring Boot:**
   * Inicializar o projeto estruturado com o Maven Wrapper.
   * Configurar o `pom.xml` com as dependências `spring-boot-starter-web` e `spring-boot-starter-validation`.
3. **Verificação de Ambiente:**
   * Testar a compilação inicial com `./mvnw clean install`.

### Etapa 2: Criação do Modelo de Domínio
1. Criar a entidade principal `Livro` no pacote `models`.
2. Adicionar os atributos:
   * `id` (Long)
   * `titulo` (String)
   * `autor` (String)
   * `quantidadePaginas` (Integer)
   * `preco` (Double)

### Etapa 3: Definição dos DTOs e Validações
1. Criar `LivroRequestDTO` no pacote `dtos` com as anotações do **Bean Validation**:
   * `titulo`: `@NotBlank` e `@Size(min = 3)`
   * `autor`: `@NotBlank`
   * `quantidadePaginas`: `@NotNull` e `@Min(1)`
   * `preco`: `@NotNull` e `@Positive`
2. Criar `LivroResponseDTO` no pacote `dtos` para padronizar o retorno da API, ocultando atributos internos caso existam no futuro e focando apenas nos dados da resposta (id, titulo, autor, quantidadePaginas, preco).

### Etapa 4: Implementação da Lógica de Negócio (Service)
1. Criar a classe `LivroService` (anotada com `@Service`).
2. Criar o armazenamento em memória: `private final List<Livro> livros = new ArrayList<>();`.
3. Implementar um contador para simular o auto-incremento do ID (ex: `AtomicLong idCounter`).
4. Implementar os métodos CRUD:
   * `salvar(LivroRequestDTO dto)` -> Retorna o `Livro` criado.
   * `listarTodos()` -> Retorna a lista completa.
   * `buscarPorId(Long id)` -> Retorna o livro ou lança a exceção `ResourceNotFoundException`.
   * `atualizar(Long id, LivroRequestDTO dto)` -> Atualiza ou lança exceção.
   * `remover(Long id)` -> Remove ou lança exceção.

### Etapa 5: Implementação dos Endpoints (Controller)
1. Criar `LivroController` no pacote `controllers` anotado com `@RestController` e `@RequestMapping("/livros")`.
2. Injetar o `LivroService`.
3. Implementar as rotas utilizando `ResponseEntity` para formatar os códigos HTTP corretamente:
   * **`POST /livros`**: `@PostMapping`, usando `@Valid` e `@RequestBody`. Retorna `201 Created`.
   * **`GET /livros`**: `@GetMapping`. Retorna `200 OK`.
   * **`GET /livros/{id}`**: `@GetMapping("/{id}")`. Retorna `200 OK`.
   * **`PUT /livros/{id}`**: `@PutMapping("/{id}")`, usando `@Valid`. Retorna `200 OK`.
   * **`DELETE /livros/{id}`**: `@DeleteMapping("/{id}")`. Retorna `204 No Content`.

### Etapa 6: Tratamento Global de Erros (ControllerAdvice)
1. Criar a classe `GlobalExceptionHandler` no pacote `exceptions`, anotada com `@RestControllerAdvice`.
2. Interceptar erros de validação (`MethodArgumentNotValidException`):
   * Mapear os campos com erro e retornar uma resposta amigável com status `400 Bad Request`.
3. Interceptar a exceção de livro inexistente (`ResourceNotFoundException`):
   * Retornar uma mensagem de erro indicando a falha de busca, atualização ou exclusão com status `404 Not Found`.

---

## 📝 Próximos Passos
Com o plano e as ferramentas bem definidas, a execução pode seguir diretamente a ordem sequencial descrita nas etapas, partindo da inicialização e preparação com o **mise** e **Maven** (Etapa 1).
