#First Step
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR ./app
copy . .
RUN mvn clean package

#Second step
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/user-service-*.jar user-service.jar
CMD ["java", "-jar", "user-service.jar"]

