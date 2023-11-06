FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/kaddem-SNAPSHOT-0.1.jar /devops2.jar
ENTRYPOINT ["java","-jar","devops2.jar"]