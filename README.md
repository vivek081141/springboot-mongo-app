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

```bash
### Step 1: Clone the Repository


git clone <repository-url>
cd <repository-directory>

### Step 2: Build the Spring Boot Application
- mvn clean package

### Step 3: Build the Docker Image
- docker build -t my-springboot-mongo-app:latest .

### Step 4: Run the Application with Docker Compose
- docker-compose up
```

## Accessing the Application
Once the containers are running, the Spring Boot application will be accessible at http://localhost:18012.

## Additional Information
**MongoDB Data Persistence**: MongoDB data is persisted in the host folder /Users/XXXX/DOCKER/mongo/db 
mapped to /data/db in the MongoDB container.

**Spring Boot Application**: The application is packaged as a JAR file and copied into the Docker image.
Cleaning Up
To stop the running containers, use:
    
```bash
docker-compose down
```
This command stops and removes the containers defined in the docker-compose.yml file.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Contributing
Feel free to submit issues, fork the repository, and send pull requests.