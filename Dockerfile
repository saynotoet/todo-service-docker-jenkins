# Build a JAR File
FROM maven:3.8.2-openjdk-11-slim AS stage1
WORKDIR /home/app
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package


# Create an Image
FROM adoptopenjdk:11-jre-hotspot-bionic
EXPOSE 5000
COPY --from=stage1 /home/app/target/TodoService-0.0.5RELEASE.jar TodoService-0.0.5RELEASE.jar
COPY --from=stage1 /home/app/src/main/webapp/ /app/src/main/webapp/

ENTRYPOINT ["sh", "-c", "java -jar /TodoService-0.0.5RELEASE.jar"]
