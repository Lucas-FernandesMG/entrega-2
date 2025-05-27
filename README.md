# 📡 Digital Twin Backend

Este é o backend de um projeto de Digital Twin, desenvolvido com **Spring Boot**, utilizando **JPA/Hibernate** e banco de dados **H2**. A aplicação permite salvar e recuperar leituras de sensores (entidade `Reading`).

---
## Integrantes 
- Lucas Fernandes Marabini Gaspar  RM:98814
- Emerson Batista da Silva  RM:96288
- Leonardo yukio Uliana Seno RM:550648
- Eduarco Cicero dos Santos RM:551415

## 🧱 Entidade: Reading

A entidade `Reading` representa uma leitura capturada por um sensor:

| Campo         | Tipo            | Descrição                        |
|---------------|-----------------|----------------------------------|
| `id`          | `Long`          | Identificador único              |
| `sensorId`    | `String`        | ID do sensor                     |
| `sensorValue` | `Double`        | Valor registrado pelo sensor     |
| `timestamp`   | `LocalDateTime` | Data e hora da leitura           |

---

## 🚀 Como rodar o projeto

### Pré-requisitos

- Java 17 ou superior
- Maven 3.8+
- IDE (IntelliJ, Eclipse, VS Code etc.) — opcional

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
2. Compile e rode:
- ./mvnw spring-boot:run

3. Acesse no navegador:
   
- http://localhost:8080
