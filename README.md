# Task Manager API

REST API per la gestione di task, sviluppata con Java 21 e Spring Boot.

## Tecnologie
- Java 21
- Spring Boot 4.1
- Maven

## Endpoint

| Metodo | Percorso    | Descrizione                       |
|--------|-------------|-----------------------------------|
| GET    | /tasks      | Elenco di tutti i task            |
| GET    | /tasks/{id} | Singolo task (404 se assente)     |
| POST   | /tasks      | Crea un nuovo task                |

## Avvio
`./mvnw spring-boot:run`

L'applicazione parte su http://localhost:8080.