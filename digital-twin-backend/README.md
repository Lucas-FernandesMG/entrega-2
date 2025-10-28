# Digital Twin Backend

Spring Boot REST API that stores sensor readings. All `/api/readings/**` endpoints are protected with JWT. The project runs out of the box with H2 and optionally with Docker-hosted MySQL/PostgreSQL.

## Requisitos

- Java 17 (`java -version` deve mostrar 17).
- Bash (Git Bash, WSL, etc.). Os comandos abaixo usam sintaxe Bash. Em PowerShell/CMD adapte conforme indicado.
- O Maven Wrapper (`mvnw` / `mvnw.cmd`) já vem no repositório, então não precisa instalar Maven globalmente.
- Opcional: Docker Desktop (para levantar MySQL) e um cliente HTTP (`curl`, Postman, Insomnia).

## Estrutura do projeto

```
digital-twin-backend/
├─ docker-compose.yml
├─ mvnw / mvnw.cmd
├─ pom.xml
├─ src/
│  ├─ main/java/com/desafio/... (REST, segurança, domínio)
│  └─ main/resources/application.properties
└─ README.md
```

## Execução rápida com H2 (padrão)

1. Entrar na pasta do backend:
	 ```bash
	 cd "c:/Users/Emerson/projetos_externos/entrega-2/digital-twin-backend"
	 ```

2. Rodar a aplicação (usa H2 por padrão):
	 ```bash
	 ./mvnw spring-boot:run
	 ```
	 Em PowerShell use `mvnw.cmd spring-boot:run`.

A API ficará em <http://localhost:8080>. O console H2 segue disponível em <http://localhost:8080/h2-console> (JDBC: `jdbc:h2:file:./data/readings`, usuário `sa`, senha vazia salvo override).

### Usuário admin padrão

No primeiro start é criado `admin / admin123`. Faça login para obter JWT:

```bash
curl -X POST http://localhost:8080/auth/login \
	-H "Content-Type: application/json" \
	-d '{"username":"admin","password":"admin123"}'
```

Use o token nas requisições protegidas:

```bash
curl http://localhost:8080/api/readings \
	-H "Authorization: Bearer <TOKEN>"
```

Criação de usuário (somente dev):

```bash
curl -X POST http://localhost:8080/auth/register \
	-H "Content-Type: application/json" \
	-d '{"username":"dev","password":"devpass"}'
```

## Rodando com MySQL via Docker

> Antes de seguir, deixe o Docker Desktop ativo.

1. Subir os serviços do docker-compose (MySQL incluso; volume para Postgres já definido caso queira adicionar depois):
	 ```bash
	 cd "c:/Users/Emerson/projetos_externos/entrega-2/digital-twin-backend"
	 docker-compose up -d
	 ```

2. Exportar variáveis **antes** de iniciar o Spring Boot.

### MySQL (Bash)
```bash
export SPRING_DATASOURCE_URL="jdbc:mysql://localhost:3306/digitaltwindb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
export SPRING_DATASOURCE_USERNAME="app"
export SPRING_DATASOURCE_PASSWORD="password"
export SPRING_DATASOURCE_DRIVER="com.mysql.cj.jdbc.Driver"
export SPRING_JPA_DDL_AUTO="update"
```

### Configuração JWT
```bash
export JWT_SECRET="uma-chave-muito-segura-com-32-ou-mais-caracteres"
export JWT_EXPIRATION_MS=3600000
```
PowerShell: `$env:SPRING_DATASOURCE_URL = "..."` e `$env:JWT_SECRET = "..."`.

3. Rodar a aplicação:
```bash
./mvnw spring-boot:run
```

4. Ao finalizar, derrube os containers se não for usar:
```bash
docker-compose down
```

## Gerando o JAR

```bash
./mvnw -DskipTests package
java -jar target/digital-twin-backend-0.0.1-SNAPSHOT.jar
```

## Variáveis de ambiente úteis

| Variável | Padrão (H2) | Finalidade |
|----------|-------------|------------|
| `SPRING_DATASOURCE_URL` | `jdbc:h2:file:./data/readings` | URL JDBC |
| `SPRING_DATASOURCE_USERNAME` | `sa` | Usuário DB |
| `SPRING_DATASOURCE_PASSWORD` | vazio | Senha DB |
| `SPRING_DATASOURCE_DRIVER` | `org.h2.Driver` | Driver |
| `SPRING_JPA_DDL_AUTO` | `update` | Estratégia de schema |
| `JWT_SECRET` | `ChangeThisSecretToAStrongValue` | Segredo HMAC (substitua em produção) |
| `JWT_EXPIRATION_MS` | `3600000` | Expiração do token (ms) |

## Endpoints principais

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/auth/login` | Retorna JWT |
| `POST` | `/auth/register` | Cria usuário (uso dev) |
| `POST` | `/api/readings` | Cria leitura (JWT) |
| `GET` | `/api/readings` | Lista todas as leituras (JWT) |
| `GET` | `/api/readings/{sensorId}` | Filtra por sensor (JWT) |
| `GET` | `/h2-console` | Console H2 (dev) |

## Problemas comuns

- `docker-compose: command not found`: instale Docker Desktop e reabra o terminal.
- `./mvnw: Permission denied`: rode `chmod +x mvnw` ou use `mvnw.cmd` (PowerShell/CMD).
- Erro de comprimento do JWT: garanta `JWT_SECRET` com pelo menos 32 caracteres.
- Falha na conexão com o banco: verifique containers (`docker ps`), portas e credenciais.

## Integração com front-end

Aponte o front para `http://localhost:8080`. Após login, inclua `Authorization: Bearer <token>` em cada requisição protegida.

## Equipe

- Lucas Fernandes Marabini Gaspar — RM 98814
- Emerson Batista da Silva — RM 96288
- Leonardo Yukio Uliana Seno — RM 550648
- Eduardo Cicero dos Santos — RM 551415

## Próximos passos

- Trocar a senha padrão do admin ou remover o DataInitializer antes de produção.
- Proteger/remover `/auth/register` fora de ambientes de desenvolvimento.
- Adicionar testes automatizados e pipeline CI/CD conforme necessário.

