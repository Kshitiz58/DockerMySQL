#Use an officail OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

#Set the working directory inside the container
WORKDIR /docker

#Copy the Spring book application's jar file into the container
ADD target/DockerLogin-0.0.1-SNAPSHOT.jar app.jar

#Make port 80 available to the world outside this container
EXPOSE 8585

#Run the application
ENTRYPOINT [ "java", "-jar", "/docker/app.jar"]