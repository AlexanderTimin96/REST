FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

COPY target/REST-0.0.1-SNAPSHOT.jar myApp.jar

CMD ["java","-jar","myApp.jar"]