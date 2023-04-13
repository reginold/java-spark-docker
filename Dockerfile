# Use the official OpenJDK image as the base image
FROM openjdk:11-jdk

# Set the working directory inside the container
WORKDIR /app

# Install necessary tools and libraries for Spark
RUN apt-get update && \
    apt-get install -y wget unzip

# Download and extract Apache Spark
ARG SPARK_VERSION=3.2.1
ARG HADOOP_VERSION=3.2
RUN wget -q https://archive.apache.org/dist/spark/spark-${SPARK_VERSION}/spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}.tgz && \
    tar -xzf spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}.tgz -C /opt && \
    rm spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}.tgz
ENV SPARK_HOME=/opt/spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}
ENV PATH=$SPARK_HOME/bin:$PATH

# Copy the Maven project files into the container
COPY . .

# Install Maven inside the container
RUN apt-get install -y maven

# Compile the Maven project
# RUN mvn clean compile
RUN mvn clean package

# Expose any ports your app might use (optional)
# EXPOSE 8080

# Replace the ENTRYPOINT command with an interactive shell (e.g., bash)
CMD ["bash"]