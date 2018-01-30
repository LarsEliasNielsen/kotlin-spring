# kotlin-spring

This project is a prototype of a RESTful API written in Kotlin. The application is build on Spring Boot with Redis caching.


## Setup
Copy the repository and follow one of the suggested methods; Running as Java application or Docker container.

### Java
Copy the repository and run:
```
$ gradlew bootRun
```

Or download the JAR and run:
```
$ java -jar kotlin-rest-service-1.0.2.jar
```

The application is available at `localhost:8080/`

Swagger docs are available at `localhost:8080/swagger-ui.html`


### Docker
Build Spring application:
```
$ gradlew build
```

Run Spring application on OpenJDK by building a container from the Dockerfile:
```
$ docker build -t jdk-spring .
```

You can also specify the JAR path:
```
$ docker build --build-arg JAR_FILE=build/libs/kotlin-rest-service-1.0.2.jar -t jdk-spring .
```

Run the container:
```
$ docker run -it jdk-spring
```

Get container id of the jdk-spring image we created earlier:
```
$ docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS               NAMES
5ea067f23f49        jdk-spring          "java -Djava.securit…"   20 minutes ago      Up 20 minutes                           some_weird_name
```

Use the container id to look for the IP address:
```
$ docker inspect -f "{{ .NetworkSettings.IPAddress }}" 5ea067f23f49
```

The IP address of the container should be returned from the `docker inspect` command, use this address to access your application:

The application is available at `<CONTAINER_IP_ADDRESS>:8080/`

Swagger docs are available at `<CONTAINER_IP_ADDRESS>:8080/swagger-ui.html`

## Resources

[Developing Spring Boot applications with Kotlin](https://spring.io/blog/2016/02/15/developing-spring-boot-applications-with-kotlin)

[Creating a RESTful Web Service with Spring Boot](https://kotlinlang.org/docs/tutorials/spring-boot-restful.html)

[Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)