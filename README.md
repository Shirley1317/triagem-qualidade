# Triagem de Qualidade

Este projeto é uma API para triagem de produtos, desenvolvida com Java e Spring Boot, seguindo arquitetura de microserviços.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- MYSQL (ou outro banco de dados relacional)
- Lombok
- Insomnia para testes de API

## Configuração

### Pré-requisitos
- Java 17
- Maven ou Gradle

### Executando o Projeto

1. Clone o repositório:
``` bash
    git clone https://github.com/Shirley1317/triagem-qualidade.git
    cd triagem-qualidade

2. Configure o banco de dados no arquivo application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/triagem_qualidade
spring.datasource.username=root
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Execute a aplicação:

./mvn spring-boot:run

### Testando a API

Abaixo estão os endpoints disponíveis para a API, com suas respectivas descrições:

|**Método HTTP**    |   **Endpoint**        | **Descrição               |
|-------------------|-----------------------|---------------------------|
|`GET`              |`/api/produtos`        |Listar todos os produtos   |
|`POST`             |`/api/produtos`        |Criar um novo produto      |
|`PUT`              |`/api/produtos/{id}`   |Atualizar um produto       |
|`DELETE`           |`/api/produtos/{id}`   |Excluir um produto         |

    