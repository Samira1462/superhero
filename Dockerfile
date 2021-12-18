FROM openjdk:11
EXPOSE 8080
ADD target/superhero-0.0.1-SNAPSHOT.jar springboot-docker-superhero.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-superhero.jar"]