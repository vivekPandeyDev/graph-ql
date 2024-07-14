# Stage 1: Build the application with Maven
FROM maven:3.8.5-openjdk-17 AS build

# Copy the Maven project descriptor files
COPY pom.xml .

# Copy the rest of the source code
COPY src ./src

# Build the application
RUN mvn clean install -DskipTests

# Stage 2: Create a lightweight image with the JAR file
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /target/graph-ql-1.0.0.jar ./app.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
