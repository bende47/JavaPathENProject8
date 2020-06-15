# Start with a base image
FROM openjdk:8

# Add Maintainer Info
LABEL maintainer="Justin Bende"

#Copy all target files
COPY build/libs/tourGuideTrip-1.0.0.jar /home/tourGuideTrip/

EXPOSE 8093
# Run the jar file
ENTRYPOINT ["java","-jar","/home/tourGuideTrip/tourGuideTrip-1.0.0.jar"]
