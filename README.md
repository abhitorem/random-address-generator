# Random Address Generator

Spring Boot Random Address Generator is a library to generate Mocked Address Data. Which will be evolving going forward.

It's easy to generate Random Addresses.


## Generating Address

Let's generate a random Address with below GET Rest Endpoint.  

```
http://localhost:8081/randomizer/address
```

If you use Jackson to serialize a person, you'll see something like this:

```
{
  "house" : "Apt. 889",
  "street" : "7397 Ullrich Divide",
  "city" : "Sauermouth",
  "county" : "Harberfort",
  "state" : "Louisiana",
  "stateCode" : "NH",
  "country" : "Netherlands",
  "countryCode" : "CA",
  "postalCode" : "45870",
  "fullAddress" : "Apt. 889, 7397 Ullrich Divide, Sauermouth, Harberfort, Louisiana, Netherlands, 45870"
}
``` 

## Build & Deployment

Below are Steps to Build and Deploy to Embedded Tomcat:
```
mvn clean
mvn install
```
## To Run Application

Below are Steps to run App in Terminal Root path:
```
spring-boot:run
```  

## Licence

Apache Version 2.0