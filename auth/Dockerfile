FROM openjdk:11
ARG JAR_FILES=target/*.jar
COPY ${JAR_FILES} auth.jar
ENTRYPOINT ["java", "-jar","auth.jar"]
EXPOSE 8080
