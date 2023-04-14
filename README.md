# java-spark-docker
- How to build the docker image 
  - ```docker build -t java-spark-docker-app .```
- How to run the container
  - ```docker run --rm -it -v ${PWD}:/app --user 1000:1000 java-spark-docker-app bash```
- Compiles the project
  - `mvn clean package`
- How to run the code
  - ```/opt/spark-3.2.1-bin-hadoop3.2/bin/spark-submit --class com.example.App target/java-docker-eclipse-project-1.0-SNAPSHOT.jar```
