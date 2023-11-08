# Use an openJDK runtime as a base image for Java 17
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Jar file into the container at the defined working directory
COPY build/libs/Kube-app-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port the application runs on
EXPOSE 8080

# Define the command to run your application when the container starts
CMD ["java","-jar","app.jar"]