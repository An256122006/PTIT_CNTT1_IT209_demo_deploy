FROM eclipse-temurin:21-jre
WORKDIR /app
COPY build/libs/demo1-0.0.1-SNAPSHOT.jar demo1-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo1-0.0.1-SNAPSHOT.jar"]