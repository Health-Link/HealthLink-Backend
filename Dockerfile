FROM openjdk:17
VOLUME /tmp
ADD target/myapp.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]