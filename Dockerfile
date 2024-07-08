FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/spring-mongo-app-0.0.2-SNAPSHOT.jar spring-mongo-app.jar
EXPOSE 18012
ENTRYPOINT ["java","-jar","spring-mongo-app.jar"]

#docker build -t my-springboot-mongo-app:latest .