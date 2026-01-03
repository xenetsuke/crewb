# Stage 1: Build the application using Maven and OpenJDK 17
FROM maven:3.8.5-openjdk-17 AS build

# # Set the working directory in the container
# WORKDIR /app

# Copy only the pom.xml first to cache dependencies
COPY . .

# Copy the source code files into the container
# COPY src /app/src/

# Build the application using Maven (skip tests to speed up the build)
RUN mvn clean package -DskipTests

# Stage 2: Run the application using OpenJDK 17 Slim
FROM openjdk:17.0.1-jdk-slim

# Set the working directory for the runtime image
# WORKDIR /app

# Copy the built .jar file from the previous build stage
COPY --from=build /target/Blue-Collar-0.0.1-SNAPSHOT.jar Blue-Collar.jar

# Expose the port the application will run on (default for Spring Boot is 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "Blue-Collar.jar"]
