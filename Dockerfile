FROM openjdk:8-jre-alpine
MAINTAINER Hansel Ospino <hansel.ospino@globant.com>
WORKDIR /app
COPY build/libs/demo-*.jar /app/
EXPOSE $PORT
CMD ["/bin/sh","-c","java -jar demo-0.0.1-SNAPSHOT.jar"]
