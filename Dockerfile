FROM gradle:6.0-jdk11 AS build
USER gradle
RUN mkdir /home/gradle/project
WORKDIR /home/gradle/project
ADD --chown=gradle:gradle build.gradle .
COPY --chown=gradle:gradle src src
RUN gradle --no-daemon build
FROM adoptopenjdk/openjdk11
EXPOSE 8080
COPY --from=build /home/gradle/project/build/libs/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]