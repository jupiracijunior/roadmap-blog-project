# Blog API
![Static Badge](https://img.shields.io/badge/status-completed-red)

Criar uma API RESTful simples com operações básicas de CRUD para uma plataforma de blog pessoal. Sem implementar paginação, autenticação ou autorização para este projeto, focando na funcionalidade principal.

:walking:Como usar?
---

Baixe o projeto de alguma forma. Recomendo por [git clone](https://git-scm.com/docs/git-clone) ou zip clicando [aqui](https://github.com/jupiracijunior/roadmap-blog-project/archive/refs/heads/master.zip).

Execute o projeto em uma IDE ou por build na linha de comando.

:point_right:Endpoints
---
#### \> **Base_url:** http://localhost:8080/api/v1


```java
GET {{base_url}}/posts

// Retorna todos os posts
```

```java
GET {{base_url}}/posts/1

// Retorna um post pelo id
```
```java
GET {{base_url}}/posts?term=tech

// Busca posts por termo (tags) de busca
```
```java
POST {{base_url}}/posts

{
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"]
}

// Cria um novo post
```
```java
PUT {{base_url}}/posts/1

{
  "title": "My Updated Blog Post",
  "content": "This is the updated content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"]
}

// Atualiza um post pelo id com o json enviado
```
```java
DELETE {{base_url}}/posts/1

// Deleta um post pelo id
```

:floppy_disk:Tecnologias & Ferramentas
---

![My Skills](https://skillicons.dev/icons?i=java,spring,maven,mysql,git,postman,idea,github&perline=8)

Referências
---
[Blogging Platform API](https://roadmap.sh/projects/blogging-platform-api) in roadmap.sh