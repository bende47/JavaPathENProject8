# Start with a base image
FROM openjdk:8

# Add Maintainer Info
LABEL maintainer="Justin Bende"

#Copy all target files
COPY build/libs/tourGuide-1.0.0.jar /home/tourGuide/

EXPOSE 8090
# Run the jar file
ENTRYPOINT ["java","-jar","/home/tourGuide/tourGuide-1.0.0.jar"]
