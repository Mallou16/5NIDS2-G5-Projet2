FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/kaddem-SNAPSHOT-0.1.jar /devops.jar
ENTRYPOINT ["java","-jar","devops.jar"]