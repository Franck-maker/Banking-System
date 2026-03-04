# Use a Maven base image
FROM maven:3-eclipse-temurin

WORKDIR /app

COPY . .

RUN mvn compile

EXPOSE 8080

# Run the application with a specific main class
CMD ["mvn","exec:java", "-Dexec.mainClass=com.bank.banking_system.BankingSystemApplication"]
