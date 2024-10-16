<h1 align="center" style="font-weight: bold;">Blog API 💻</h1>

<p align="center">
    <b>Esta é uma API de blog desenvolvida com Java e Spring Boot, projetada para gerenciar postagens de um blog de maneira eficiente e escalável.</b>
</p>

<h2 id="technologies">💻 Tecnologias</h2>

- Java
- Spring Boot
- Spring Web
- JPA
- H2 Database
- Lombok

<h2 id="started">🚀 Iniciando o projeto</h2>
<h3>Pré Requisitos</h3>
- [Java](https://github.com/)

<h3>Clonando</h3>

```bash
git clone https://github.com/hendrickm97/blog-api.git
```
<h3>Navegue até o diretório</h3>

```bash
cd nome-do-repositorio
```

-Executando Projeto:

```bash
mvn spring-boot:run
```

<h2 id="routes">📍 API Endpoints</h2>
​

<h3 id="get-auth-detail">GET /posts</h3>

**RESPONSE**

```json
{
  "id": 1,
  "title": "Test Post",
  "content": "This is just a test",
  "author": "Jon Doe",
  "postDate": "2024-10-16T16:07:50.351281"
}
```
<h3 id="get-auth-detail">GET /posts/{id} [ex: id = 2]</h3>

**RESPONSE**

```json
{
  "id": 2,
  "title": "Test Post 2",
  "content": "This is just a another test",
  "author": "Jane Doe",
  "postDate": "2024-10-16T16:10:40.830661"
}
```


<h3 id="post-auth-detail">POST /product</h3>

**REQUEST**

```json
{

  "title": "Test Post",
  "content": "This is just a test",
  "author": "Jon Doe"
}
```

**RESPONSE**

```json
{
  
  "id": 1,
  "title": "Test Post",
  "content": "This is just a test",
  "author": "Jon Doe",
  "postDate": "2024-10-16T16:07:50.351281"
}
```
<h3 id="get-auth-detail">DELETE /posts/{id}</h3>
- Nessa rota a api vai pegar o post pela id, apagar esse post se ele existir e retornar a lista com todos os posts

<h3 id="get-auth-detail">PUT /posts/{id}</h3>
- Nessa rota a api vai pegar o post pela id, atualizar esse post se ele existir e retornar a lista com todos os posts