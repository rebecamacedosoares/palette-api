FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "echo \"DEBUG: A URL do banco recebida é -> [$SPRING_DATASOURCE_URL]\" && java -jar -Dspring.profiles.active=prod app.jar"]