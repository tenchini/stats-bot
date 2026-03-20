FROM eclipse-temurin:21-jdk-alpine

ENV DISCORD_TOKEN=""
ENV STEAM_API_KEY=""

COPY target/statsbot-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
