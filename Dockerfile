FROM openjdk:11
EXPOSE 8082
ADD target/AssuranceProject.jar AssuranceProject.jar
ENTRYPOINT ["java","-jar","/AssuranceProject.jar"]
