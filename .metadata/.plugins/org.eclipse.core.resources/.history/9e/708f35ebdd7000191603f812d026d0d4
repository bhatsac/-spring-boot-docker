FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD	target/currency-exchange-service.jar currency-exchange-service.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","currency-exchange-service.jar"]