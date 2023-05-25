FROM openjdk:17-alpine3.14

COPY build/libs/otrocliente-0.0.1-SNAPSHOT.jar /app/otrocliente.jar

WORKDIR /app

EXPOSE 9090

CMD ["java", "-jar", "otrocliente.jar", "--server.port=9090"]