FROM openjdk:8u232-jre AS base
WORKDIR /products-api
EXPOSE 8080

FROM maven:3.5-jdk-8 as maven
RUN mvn clean install package

FROM base AS final
COPY --from=maven target/products-api-1.0.0-SNAPSHOT.jar ./
#ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "products-api-1.0.0-SNAPSHOT.jar"]