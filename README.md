# Projeto Java com Spring Boot e JWT

Este projeto implementa uma API RESTful simples para cadastro de usuários, autenticação com JWT (JSON Web Token) e controle de acesso baseado em papéis (roles: `ADMIN` e `USER`).

## Funcionalidades Principais

* **Cadastro de Usuários**: Registro de novos usuários com nome de usuário, e-mail e senha.
* **Autenticação JWT**: Sistema de login que gera um token JWT válido.
* **Controle de Acesso por Role**: Endpoints específicos protegidos por papéis de usuário.
* **Gerenciamento Básico de Usuários**: Permissões diferenciadas para `ADMIN` e `USER`.

## Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.5.0**
* **Spring Security 6.5.0**
* **JJWT (JSON Web Token) 0.12.5**
* **Spring Data JPA**
* **Banco de Dados H2 (em memória)**
* **Maven**
* **Springdoc OpenAPI (Swagger UI)**

## Configuração do Ambiente

1.  **JDK 21**: Certifique-se de ter o Java Development Kit 21 ou superior instalado.
2.  **Maven**: Verifique se o Maven está instalado e configurado em sua máquina.
3.  **Clone o Repositório**: Se este projeto estiver em um repositório Git, clone-o para sua máquina local.

## Instruções de Execução

### 1. Configuração Inicial (Uma Vez)

1. **Instalar Dependências e Compilar**:
    Abra o terminal na raiz do projeto e execute:
    ```bash
    mvn clean install
    ```
    Isso baixará todas as dependências e compilará o projeto.

### 2. Iniciando a Aplicação

#### Opção A: Pela IDE (IntelliJ IDEA)

1.  Abra o projeto no IntelliJ IDEA.
2.  Vá para a classe principal `src/main/java/com/example/trabalhojwt/TrabalhojwtApplication.java`.
3.  Clique no botão "Play" (Run) ao lado do método `main` para iniciar a aplicação.

#### Opção B: Pelo Terminal (Executando o JAR)

1.  Após executar `mvn clean install` (Passo 1.2), um arquivo `.jar` executável será criado na pasta `target/`.
2.  No terminal, na raiz do projeto, execute:
    ```bash
    java -jar target/trabalhojwt-0.0.1-SNAPSHOT.jar
    ```

Ao iniciar a aplicação, você verá logs no console, incluindo a inicialização das roles `ROLE_USER` e `ROLE_ADMIN` pelo `DataInitializer` (isso só acontece na primeira vez que o banco H2 em memória é criado).

## Documentação da API (Swagger UI)

Após a aplicação estar em execução, você pode acessar a documentação interativa da API via Swagger UI.

**Link para o Swagger UI:**

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Como Usar a API (Exemplos no Swagger UI)

1.  **Registro de Usuário (`POST /api/auth/signup`)**:
    * No Swagger UI, expanda a seção "Autenticação".
    * Encontre o endpoint `POST /api/auth/signup`.
    * Clique em "Try it out".
    * No "Request body", insira o JSON para um novo usuário:
        ```json
        {
            "username": "meu_usuario",
            "email": "meu@email.com",
            "password": "minhasenhaforte",
            "role": ["user"]
        }
        ```
    * Clique em "Execute". Você deve receber um `200 OK` com a mensagem de sucesso.

2.  **Login de Usuário (`POST /api/auth/signin`)**:
    * No Swagger UI, expanda a seção "Autenticação".
    * Encontre o endpoint `POST /api/auth/signin`.
    * Clique em "Try it out".
    * No "Request body", insira o JSON com as credenciais do usuário registrado:
        ```json
        {
            "username": "meu_usuario",
            "password": "minhasenhaforte"
        }
        ```
    * Clique em "Execute". Você deve receber um `200 OK` com um `accessToken` (seu JWT) e informações do usuário.

3.  **Acessando Endpoints Protegidos (com o JWT)**:
    * Copie o `accessToken` que você recebeu no passo de login.
    * No canto superior direito do Swagger UI, clique no botão "Authorize" (ou ícone de cadeado).
    * Cole o token no campo `Value` no formato `Bearer SEU_TOKEN_AQUI` (substituindo `SEU_TOKEN_AQUI` pelo token real).
    * Clique em "Authorize" e depois em "Close".
    * Agora, você pode testar endpoints protegidos, como `GET /api/test/user` ou `GET /api/test/admin` (se seu usuário tiver a role `ADMIN`), e deverá receber o "Conteúdo de Usuário." ou "Conteúdo de Administrador."
