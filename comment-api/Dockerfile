FROM openjdk:17
ARG JAR_FILE=build/libs/comment-api-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} comment-api-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/comment-api-1.0-SNAPSHOT.jar"]