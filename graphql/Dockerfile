# Stage 1: Build the application
FROM maven:latest as BUILDER

# Define the version argument and set a default value
ARG VERSION=0.0.1-SNAPSHOT

# Set the working directory
WORKDIR /build/

# Copy the Maven configuration and source code
COPY pom.xml /build/
COPY src /build/src/

# Build the application
RUN mvn clean package -Pprod -X

# Copy the built JAR file using the VERSION argument
COPY target/graphql-${VERSION}.jar /build/application.jar


# Stage 2: Run the application
FROM openjdk:latest

# Set the working directory for the runtime environment
WORKDIR /app/

# Copy the JAR file from the builder stage
COPY --from=BUILDER /build/application.jar /app/

# Define the command to run the application
CMD ["java", "-jar", "/app/application.jar"]