# Tensorweb
Tensorweb is Microservices for authenticating and authorizing users which provides the Developers implemented authenication &amp; authorization system. Tensorweb follows Microservices architecture enabling Developers to integrate with other custom services. 
# Local Deployment
* To build projects and package to jar file, run the following command from the root of the project. This tutorial assumes you have Maven & Java installed
```
./build_microservice
```
* Tensorweb uses Docker-Compose for local deployment & testing purpose
* Run the following command from the root of the project to build and run microservices
```
sudo docker compose up --build
```
* To just only run the Microservices without building
```
sudo docker compose up
```

