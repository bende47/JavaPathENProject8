# Start with a base image
FROM openjdk:8

# Add Maintainer Info
LABEL maintainer="Justin Bende"

#Copy all target files
COPY build/libs/tourGuideGps-1.0.0.jar /home/tourGuideGps/

EXPOSE 8092
# Run the jar file
ENTRYPOINT ["java","-jar","/home/tourGuideGps/tourGuideGps-1.0.0.jar"]
