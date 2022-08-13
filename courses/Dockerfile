FROM openjdk:11
ARG JAR_FILES=target/*.jar
COPY ${JAR_FILES} course.jar
ENTRYPOINT ["java", "-jar","course.jar"]
EXPOSE 8083
