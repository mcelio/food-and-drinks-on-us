Intercom test application

#Cloning

git clone ---------------

THE TEST

Customer Records
We have some customer records in a text file (customers.txt) -- one customer per line, JSON lines
formatted. We want to invite any customer within 100km of our Dublin office for some food and drinks
on us. Write a program that will read the full list of customers and output the names and user ids of
matching customers (within 100km), sorted by User ID (ascending).

You can use the first formula from this Wikipedia article to calculate distance. Don't forget, you'll
need to convert degrees to radians.
The GPS coordinates for our Dublin office are 53.339428, -6.257664.
You can find the Customer list here.

The project is based on a small web service which uses the following technologies:

* Java 1.8
* Spring MVC with Spring Boot
* Database H2 (In-Memory)
* Maven


Resources:

customers.txt - https://s3.amazonaws.com/intercom-take-home-test/customers.txt

Great-circle distance - https://en.wikipedia.org/wiki/Great-circle_distance


#Running the application:

mvn spring-boot:run -Dserver.port=8081

Application runs on:

For accessing Swagger: http://localhost:8081/swagger-ui.html

#Frontend
Build from sources
shop
cd foods-and-drinks-on-us/frontend
npm install --build-from-source

Running frontend

npm run start

For accessing frontend application: http://localhost:8080
