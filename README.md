# Site Monitor
Small app to monitor the status of the site periodically for every 30 seconds

## Code Base
Written in Java 8 spring boot. Pom.xml in root directory will explain the project in details.

## Functionality
* Monitor the status of the URLs www.wikipedia.com, www.yahoo.com, www.netflix.com.
* Option available to add URLs to it
* Page refresh every 30 seconds and shows the updated status

## How to run the app
As it is in spring boot, mvn command can be used to run or package it to jar and use java command to execute the jar.

### Maven command. 
This needs to be run in the directory where pom.xml is available.
```
mvn spring-boot:run
```

### Java command.
This will compile and package the code to jar and will be placed in target folder 
```
mvn package
```
Run the jar using the below java command
```
java -jar <jarfile_name_along_with_path>
```

## Accessing the app
```http://localhost:8080```

![](https://github.com/[username]/[reponame]/blob/[branch]/image.png?raw=true)
