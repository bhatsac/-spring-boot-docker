FROM openjdk:8-jdk-alpine
ADD	./target/currency-conversion-service.jar currency-conversion-service.jar
EXPOSE 8100
ENTRYPOINT ["java","-jar","currency-conversion-service.jar"]