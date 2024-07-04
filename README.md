# springboot-mongo-starterkit
Springboot
MongoDb
Docker
# build & push the image to docker hub
## mvn compile jib:build -Dimage=docker build -t my-springboot-mongo-app:latest .:latest
Note: Jlib has some issues with credential.
So moving back to dockerfile
## docker build -t my-springboot-mongo-app:latest .

Docker Compose
Validation and Error Handling.
