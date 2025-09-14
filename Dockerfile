FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar -Dspring.profiles.active=prod -Dspring.datasource.url=\"jdbc:${SPRING_DATASOURCE_URL}?currentSchema=palette_schema\" app.jar"]