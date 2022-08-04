# employee-management-app
_A fully fledged Spring
Boot application showcasing the basic CRUD operations on Employee entity._
#

#### What's inside <br>
* Maven
* Spring Core
* Spring Data (Hibernate & MySQL)
* Spring MVC (Tomcat)
#
#### Installation <br>
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies.
#
#### Database configuration <br>
#
Create a MySQL database with the name employee_list and add the credentials to /resources/application.properties.
The default ones are :
<div />
<img src="jdbc.png"> 
<div />


#### Project structure <br>

<img src="projectStructure.png" width="400" height="400" >

#

ER Diagram
<div />
<img src="db.png" width="400" height="400" >

#### Usage <br>
#
Run the project through the IDE or run: **mvn spring-boot:run** command in the command line and head out to Postman to check the rest endpoints.


* Create
<img src="createEmployee.png" width="400" height="400"> 

* Read
<img src="getAllEmployees.png" width="400" height="400"> 

* Update
<img src="update.png" width="400" height="400"> 

* Delete
<img src="delete.png" width="400" height="400"> 

