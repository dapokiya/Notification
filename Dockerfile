FROM openjdk:17

# Set working directory
WORKDIR /app

# Copy jar file
COPY target/Notification-1.0-SNAPSHOT.jar app.jar

# Expose Spring Boot port
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]