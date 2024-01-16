# <p align="center"> Desafio Backend Simplify </p>
## Objetivo
O objetivo do repositório é treinar o framework Spring, resolvendo um desafio de vaga backend e aprimorando minhas habilidades como programador.

## Tecnologias Utilizadas
- Spring Boot
- Spring Data JPA
- Spring Validation
- Lombok
- Jakarta

## Como rodar
Basta baixar o projeto e rodar o seguinte comando: `java -Dspring.profiles.active=prod -jar target/demo-0.0.1-SNAPSHOT.jar`

## Rotas
POST - `/tasks` - criar uma nova task no banco.
`{
    "name": "Testname",
    "description": "Test Description",
    "realized": true,
    "priority": 1
}`

GET - `/tasks` - pegar todas as tasks do banco.

PUT - `/tasks/{id}` - editar uma task no banco.
`{
    "description": "Test Description",
    "realized": true,
    "priority": 1
}`

DELETE - `/tasks/{id}` - deletar uma task do banco.

GET - `/tasks/byPriority/{priority}` - pegar todas as tasks do banco pela priority.

GET - `/tasks/byRealized/{realized}` - pegar todas as tasks do banco pela realized.
