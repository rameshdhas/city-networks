## Contents

- [About City Connections](#about-city-connections)
- [Getting started](#getting-started)
- [Executing API calls](#executing-api-calls)
- [FAQ](#faq)
- [Swagger](#swagger)
- [License](#license)

---

## About City Connections

An application using **[SpringBoot](https://spring.io/projects/spring-boot)** & **[Java](https://www.oracle.com/java/)** (1.8 or above)
which determines if two cities are connected. Two cities are considered
connected if there’s a series of roads that can be traveled from one city
to another.

List of roads is available in a file. The file contains a list of city
pairs (one pair per line, comma separated), which indicates that there’s a
road between those cities.


### Features

- **Rest API** - REST end-point available to check two cities are connected.
- **Speedy Implementation** - Install and run the application in five minutes.
- **Data Load** - Build your data file (city.txt) with one pair per line, comma separated.
- **Customizable** - Load your own data and check the city connections.
- **Flexible back-end** - New features can be added in the MapService and exposed as REST end-points.

### Live Demo

Checkout the live demo of [City Connections](https://city-connections.herokuapp.com/connected?origin=Boston&destination=Newark).

Checkout the Swagger documentation at [API Documentation](https://city-connections.herokuapp.com/swagger-ui.html).

THe application is hosted in Heroku environment.

## Getting started

### To run (with Maven)

To run the server, run this task:

`git clone https://github.com/rameshdhas/city-networks.git`

`cd city-networks`

`mvn clean install`

`cd target`

`java -jar city-networks-0.0.1-SNAPSHOT.jar`

Tha application will start in the http port 8080


### To run test cases (with Maven)

`git clone https://github.com/rameshdhas/city-networks.git`

`cd city-networks`

`mvn test`

## Executing API calls

Tha application is deployed as a Spring Boot App and it exposes one endpoint:
http://localhost:8080/connected?origin=city1&destination=city2

The end pont will respond with ‘yes’ if city1 is connected to city2,
’no’ if city1 is not connected to city2.
Any unexpected input should result in a ’no’ response.

### For Example:
city.txt content is:

```csv
Boston, New York
Philadelphia, Newark
Newark, Boston
Trenton, Albany
```

https://city-connections.herokuapp.com/connected?origin=Boston&destination=Newark
Should return yes

https://city-connections.herokuapp.com/connected?origin=Boston&destination=Philadelphia
Should return yes

https://city-connections.herokuapp.com/connected?origin=Philadelphia&destination=Albany
Should return no

---

## FAQ

### Where can I learn more about spring boot?

The [Spring Boot](https://spring.io/projects/spring-boot) page contains several useful guides.

### Is the data stored in memory?

Yes! All the data from cities.txt is loaded into the server's memory. It's just stored in a plain java HashMap.

### Can I load my own data?

You can!

Create the data file cities.txt, one pair per line, comma separated and copy to resources folder.

Restart the application.

### Can I build my own algorithms?

Yes! Absolutely.

Currently the API supports, if two cities are connected or not using **breath first search (BFS)** algorithm. 
One nice to have feature is to implement **Dijkstra's shortest path** between two cities.

### Where do I report issues with the city-connections API?

If something is not working as expected, please open an [issue](https://github.com/rameshdhas/city-networks/issues/new).

## Swagger

Swagger UI allows anyone — be it your development team or your end consumers — to visualize and interact with the API’s resources 
without having any of the implementation logic in place. It’s automatically generated from your OpenAPI (formerly known as Swagger) Specification, 
with the visual documentation making it easy for back end implementation and client side consumption

Checkout the Swagger documentation at [API Documentation](https://city-connections.herokuapp.com/swagger-ui.html).

## License

The 2.0 version of the Apache License, approved by the ASF in 2004, helps us achieve our goal of providing reliable and long-lived software products through collaborative open source software development.
All packages produced by the ASF are implicitly licensed under the Apache License, Version 2.0, unless otherwise explicitly stated.

[Apache-2.0](https://www.apache.org/licenses/LICENSE-2.0)

Thank you!
