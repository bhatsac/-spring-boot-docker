FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD	target/netflix-zuul-api-gateway-server.jar netflix-zuul-api-gateway-server.jar
EXPOSE 8765
ENTRYPOINT ["java","-jar","netflix-zuul-api-gateway-server.jar"]