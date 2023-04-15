# java-spark-docker
- How to build the docker image 
  - ```docker build -t java-spark-docker-app .```
- How to run the container
  - ```docker run --rm -it -v ${PWD}/src:/app/src -v ${PWD}/pom.xml:/app/pom.xml java-spark-docker-app bash```
- Run the code(8s)
  - `mvn compile exec:java -Dexec.mainClass="com.example.{Filename}"`

- How to run the code(Took time like 40s)
  - ```mvn clean package && /opt/spark-3.2.1-bin-hadoop3.2/bin/spark-submit --class com.example.App target/java-docker-eclipse-project-1.0-SNAPSHOT.jar```
