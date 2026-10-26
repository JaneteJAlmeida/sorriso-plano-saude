# Sorriso Plano de Saúde — API REST

Projeto baseado na avaliação anexada: cadastro de beneficiários, documentoos, listagem, atualização, exclusão, banco relacional, Swagger e instruções de build. Foram adicionados Spring Data JPA, Spring Security, testes JUnit/Mockito, Postman e separação em microserviços/feature packages.

## Arquitetura
- `beneficiario-service` (porta 8081): cadastro e consulta de beneficiários.
- `documentoo-service` (porta 8082): cadastro e consulta de documentoos associados a um `beneficiarioId`.
- Cada serviço tem banco H2 próprio e autenticação HTTP Basic.
- Pacotes organizados por feature (`beneficiario`, `documento`) com camadas controller/service/repository/dto.
- Swagger: `/swagger-ui.html`; OpenAPI: `/v3/api-docs`.

> Para manter o escopo executável e fácil de estender, os serviços estão desacoplados por API REST. O cadastro de documentoos é feito diretamente no documentoo-service. Uma próxima evolução recomendada é adicionar gateway e comunicação orquestrada para criação de beneficiário + documentoos em uma única operação distribuída.

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
Altere as credenciais antes de qualquer uso fora do ambiente local.

## Endpoints — beneficiario-service (8081)
- `POST /api/beneficiaries` — cadastrar beneficiário
- `GET /api/beneficiaries` — listar todos
- `GET /api/beneficiaries/{id}` — obter por ID
- `PUT /api/beneficiaries/{id}` — atualizar cadastro
- `DELETE /api/beneficiaries/{id}` — remover

Exemplo:
```json
{"nome":"Maria Silva","telefone":"73999990000","email":"maria@example.com"}
```

## Endpoints — documentoo-service (8082)
- `POST /api/documentoos` — cadastrar documentoo
- `GET /api/documentoos/beneficiario/{beneficiarioId}` — listar documentoos do beneficiário
- `DELETE /api/documentoos/{id}` — remover documentoo

Exemplo:
```json
{"beneficiarioId":1,"documentoType":"CPF","documentoNumber":"12345678900"}
```

## Postman
Importe `postman/Sorriso-Plano-Saude.postman_collection.json`. A coleção inclui chamadas principais para os dois serviços; autenticação configurada como Basic Auth.

## Banco H2
- Beneficiários: `http://localhost:8081/h2-console`
- Documentoos: `http://localhost:8082/h2-console`
- JDBC URLs: `jdbc:h2:mem:beneficiariodb` e `jdbc:h2:mem:documentodb`.

## Observações
Os campos do diagrama da avaliação não estavam legíveis/disponíveis no texto extraído do PDF. Por isso, o modelo inicial usa `nome`, `telefone`, `email` para beneficiário e `beneficiarioId`, `documentoType`, `documentoNumber` para documentoo. Ajuste os atributos conforme o diagrama original, se necessário.
