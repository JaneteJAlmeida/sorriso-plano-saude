# Sorriso Plano de Saúde — API REST
## Arquitetura
- `beneficiario-service` (porta 8081): cadastro e consulta de beneficiários.
- `documentoo-service` (porta 8082): cadastro e consulta de documentoos associados a um `beneficiarioId`.
- Cada serviço tem banco H2 próprio e autenticação HTTP Basic.
- Pacotes organizados por feature (`beneficiario`, `documento`) com camadas controller/service/repository/dto.
- Swagger: `/swagger-ui.html`; OpenAPI: `/v3/api-docs`.


## Requisitos
- JDK 17
- Maven 3.9+

## Executar
Em terminais separados, na raiz:
```bash
mvn -pl documentoo-service spring-boot:run
mvn -pl beneficiario-service spring-boot:run
```
Build e testes:
```bash
mvn clean verify
```

## Credenciais de desenvolvimento
- usuário: `sorriso`
- senha: `sorriso123`

## Endpoints — beneficiario-service (8081)
- `POST /api/beneficiaries` — cadastrar beneficiário
- `GET /api/beneficiaries` — listar todos
- `GET /api/beneficiaries/{id}` — obter por ID
- `PUT /api/beneficiaries/{id}` — atualizar cadastro

## Endpoints — documentoo-service (8082)
- `POST /api/documentoos` — cadastrar documentoo
- `GET /api/documentoos/beneficiario/{beneficiarioId}` — listar documentoos do beneficiário
- `DELETE /api/documentoos/{id}` — remover documentoo


## Postman
Importe `postman/Sorriso-Plano-Saude.postman_collection.json`. A coleção inclui chamadas principais para os dois serviços; autenticação configurada como Basic Auth.

## Banco H2
- Beneficiários: `http://localhost:8081/h2-console`
- Documentoos: `http://localhost:8082/h2-console`
- JDBC URLs: `jdbc:h2:mem:beneficiariodb` e `jdbc:h2:mem:documentodb`.
