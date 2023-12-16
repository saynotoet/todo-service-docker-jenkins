# Build dependencies layer
FROM maven:3.8.2-openjdk-11-slim AS dependencies
WORKDIR /home/app
COPY ./pom.xml /home/app/
RUN mvn -f /home/app/pom.xml dependency:resolve

# Build application layer
FROM maven:3.8.2-openjdk-11-slim AS build
WORKDIR /home/app
COPY --from=dependencies /home/app/.m2 /home/app/.m2
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

# Create final image
FROM adoptopenjdk:11-jre-hotspot-bionic
EXPOSE 5000
COPY --from=build /home/app/target/TodoService-0.0.4RELEASE.jar TodoService-0.0.4RELEASE.jar
ENTRYPOINT ["sh", "-c", "java -jar /TodoService-0.0.4RELEASE.jar"]
