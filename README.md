# ArticleRevSys
Assignment for a fourth year CS Course (CSci 483 - Interactive Programming in Java)


## Project Requirements
- [JDK 11](https://java.com/en/)
- [NetBeans IDE](https://netbeans.apache.org/download/index.html)
- Payara Server (*Installed using NetBeans IDE*)
- [MongoDB Community Server](https://www.mongodb.com/try/download/community)

To be able to connect this JSF project to the Mongo Database, you will need the Maven MongoDB Java Driver added to the pom.xml file.
```xml
<dependencies>
    <dependency>
        <groupId>org.mongodb</groupId>
        <artifactId>mongo-java-driver</artifactId>
        <version>2.12.3</version>
    </dependency>
</dependencies>
```

To be able to share the local Mongo database to another system, you will need to run the following commands:
*To dump database to output directory*
```mongodump --db DatabaseName -o ./DirectoryName```
*After copying that directory to another machine*
```mongorestore --db DBName ./DirectoryName``` 

## How To Run
Easiest way to run this project after cloning this repo is to open up the project folder in NetBeans IDE.

## Demo Screenshots
*To be later added as more features are implemented*
