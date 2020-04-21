FROM openjdk:8
ARG JAR_FILE=build/libs/todo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

#ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8080


#/Users/shrawinpandey/Desktop/FullStack/Service/build/libs/todo-0.0.1-SNAPSHOT.jar