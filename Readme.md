<h1>Projeto Conta Digital</h1> 

<p align="center">
  <img src="https://img.shields.io/static/v1?label=spring&message=framework&color=green&style=for-the-badge&logo=SPRING"/>
  <img src="http://img.shields.io/static/v1?label=Spring&message=2.5.5&color=red&style=for-the-badge&logo=spring"/>
  <img src="http://img.shields.io/static/v1?label=TESTES&message=%3E75&color=GREEN&style=for-the-badge"/>
   <img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=RED&style=for-the-badge"/>
</p>


### Tópicos

[Descrição do projeto](#descrição-do-projeto)

[Funcionalidades](#funcionalidades)

[Pré-requisitos](#pré-requisitos)

[Como rodar a aplicação](#como-rodar-a-aplicação)



## Descrição do projeto

<p align="justify">
  A aplicação aqui em desenvolvimento tem o objetivo de debitar e creditar valores nas contas dos clientes. 
</p>

## Funcionalidades

* Creditar em conta

* Debitar em conta


## Pré-requisitos

* [Docker](https://docs.docker.com/get-docker/)


## Como rodar a aplicação:

* No terminal, clone o projeto:
```
git clone https://github.com/antoniomartinszup/conta-digital.git
```

* Com o Docker iniciado:
```
docker-compose up -d
```

* Iniciar a aplicação 

* Executar as requisições para os endpoints do tipo **PUT**:
```
http://localhost:8080/contas/{id}/credita

http://localhost:8080/contas/{id}/debita
```

## Resultado Esperado

- Em caso de sucesso:
    - Retorno será um status de sucesso (200)

- Em caso de falha:
    - Retorno será um status de erro (400)

## Metricas

* Endpoints 
```
http://localhost:8080/actuator

http://localhost:8080/actuator/health

http://localhost:8080/actuator/metrics
```












# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#boot-features-validation)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#production-ready)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

