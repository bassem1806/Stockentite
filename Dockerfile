From openjdk:8-alpine
copy ./target/amsdata.jar amsdata.jar
CMD ["java","-jar","amsdata.jar"]

