FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/kaddem-SNAPSHOT-0.1.jar /DevSECOPS.jar
ENTRYPOINT ["java","-jar","DevSECOPS.jar"]