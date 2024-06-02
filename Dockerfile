#Use an officail OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

#Set the working directory inside the container
WORKDIR /docker

#Copy the Spring book application's jar file into the container
ADD target/DockerLogin-0.0.1-SNAPSHOT.jar app.jar

#Make port 80 available to the world outside this container
EXPOSE 80

#Set the environment variable for the default profile
ENV SPRING_PROFILES_ACTIVE=default

#Set the environment variable for the database connection
ENV SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/dockerlogin
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASURCE_PASSWORD=

#Run setup for dependencies injection and static file management
RUN apk update && apk add --no-cache curl

#RUN app-get update && app-get install -y \
#curl \
#&& rm -rf /var/lib/apt/lists/*

#Run the application
ENTRYPOINT [ "java", "-jar", "/docker/app.jar"]