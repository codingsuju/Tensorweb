FROM openjdk:11
ARG JAR_FILES=target/*.jar
COPY ${JAR_FILES} accounts.jar
ENTRYPOINT ["java", "-jar","accounts.jar"]
EXPOSE 8082
