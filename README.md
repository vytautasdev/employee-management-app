# employee-management-app
_A fully fledged Spring Boot application showcasing the basic CRUD operations._ <br>

### What's inside <br>
* Maven
* Spring Core
* Spring Data (Hibernate & MySQL)
* Spring MVC (Tomcat)
#
## Installation <br>
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies.
#
## Database configuration 

Create a MySQL database with the name employee_list and add the credentials to /resources/application.properties.
The default ones are :
<div />
<img src="jdbc.png"> 
<div />

#

## Project structure <br>

<img src="projectStructure.png"  >

#

## ER Diagram <br>
<div />
<img src="db.png" >

## Usage <br>
#
Run the project through the IDE or run: **mvn spring-boot:run** command in the command line and head out to Postman to check the REST endpoints.


* Create
<div /> 
<img src="createEmployee.png" >

#

* Read 
<div /> 
<img src="getAllEmployees.png" >

#

* Update
<div />  
<img src="update.png" >

#

* Delete
<div />  
<img src="delete.png">
