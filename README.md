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

## Descrição

Este é o frontend do projeto Digital Twin. Ele consome dados do backend real, exibindo leituras de sensores e seus históricos.

---

## Como rodar

1. Clone o repositório:
   ```
   git clone https://github.com/Lucas-FernandesMG/entrega-1.git
   ```
2. Entre na pasta do projeto:
   ```
   cd entrega-1
   ```
3. Instale as dependências:
   ```
   npm install
   ```
4. Inicie o frontend:
   ```
   npm start
   ```
   ou, se for React Native:
   ```
   expo start
   ```
5. Garanta que o backend está rodando em `http://localhost:8080`.

---

## Configuração da URL da API

No menu de configurações, você pode ajustar a URL do backend consumido (exemplo: `http://localhost:8080/api/readings`).

---

## Exemplo de funcionamento

- Listagem de sensores exibindo nome, valor e horário.
- Ao clicar em um sensor, mostra o histórico de leituras.
- Integração real com o backend via requisições HTTP (`fetch`).

---

## Prints de telas

Adicione aqui screenshots do app mostrando listagem de sensores e detalhes de um sensor consumindo dados reais do backend.

---

## Observações

- O app consome os campos: `sensorName`, `sensorValue`, `timestamp` e `id` da API.
- Certifique-se que o backend está ativo para visualizar os dados.
