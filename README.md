# Spring Boot MongoDB Application

This is a Spring Boot application that connects to a MongoDB database. The application and database are containerized using Docker, and the setup is managed through Docker Compose.

## Technologies Used

- **Spring Boot**: Java-based framework used to create stand-alone, production-grade Spring applications.
- **MongoDB**: NoSQL database used to store the application's data.
- **Docker**: Platform used to develop, ship, and run applications inside containers.
- **Docker Compose**: Tool for defining and running multi-container Docker applications.

## Prerequisites

- Docker installed on your local machine.
- Docker Compose installed on your local machine.
- Maven installed on your local machine.

## Application Structure

- **Dockerfile**: Defines the Docker image for the Spring Boot application.
- **docker-compose.yml**: Defines the Docker Compose setup for running the Spring Boot application and MongoDB in separate containers.
- **pom.xml**: Maven configuration file for building the Spring Boot application.

## Setup Instructions

### Step 1: Clone the Repository

```bash
git clone <repository-url>
cd <repository-directory>

### Step 2: Build the Spring Boot Application
- mvn clean package

### Step 3: Build the Docker Image
- docker build -t my-springboot-mongo-app:latest .

### Step 4: Run the Application with Docker Compose
- docker-compose up
