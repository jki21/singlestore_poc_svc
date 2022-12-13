FROM openjdk:11-jdk-alpine
ARG JAR_FILE=target/*.jar
ARG DB_URL
ARG DB_USER
ARG DB_PWD
ENV DB_URL=${DB_URL}
ENV DB_USER=${DB_USER}
ENV DB_PWD=${DB_PWD}
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]