FROM openjdk:21-jdk
LABEL com.example.image.authors="mikko.vierma@gmail.com"
COPY target/eventshuffle-0.0.1-SNAPSHOT.jar eventshuffle-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/eventshuffle-0.0.1-SNAPSHOT.jar"]