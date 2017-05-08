# Integration Project

The prototype that use REST APIs to do Member CRUD and Relationship CRUD operations.

### REST API Framework
* Dropwizard

### Build Project

* `mvn clean install`

### Build Database if you don't have

* `java -jar target\integration-0.1-SNAPSHOT.jar db migrate integration.yaml`

### Run this application

* `java -jar target\integration-0.1-SNAPSHOT.jar server integration.yaml`

### Reference
* http://www.dropwizard.io/1.1.0/docs/getting-started.html#running-your-application

#### Insert Member

`curl -H "Content-Type: application/json" -d '{"nameReal": "Tom Cruise","nameChanged": "Hey Tom","namePassport": "TOM CRUISE PASS","country": "TAIWAN","church": "LordsLight","department": "FAMILY","birthday": "2017-05-08","baptismday": "2017-05-08"}' http://localhost:8080/api/v1/member`

`curl -H "Content-Type: application/json" -d '{"nameReal": "Brian Adams","nameChanged": "Hey Brian","namePassport": "BRIAN ADAMS HELLO","country": "USA","church": "Wish","department": "CAREER","birthday": "2017-05-08","baptismday": "2017-05-08"}' http://localhost:8080/api/v1/member`

#### Get Member

`curl http://localhost:8080/api/v1/member/1`

`curl http://localhost:8080/api/v1/member/2`

#### Update Member

`curl -X PUT -H "Content-Type: application/json" -d '{"id": 2,"nameReal": "Brian Adams123","nameChanged": "Hey Brian","namePassport": "BRIAN ADAMS HELLO","country": "USA","church": "Wish","department": "CAREER","birthday": "2017-05-08","baptismday": "2017-05-08"}' http://localhost:8080/api/v1/member`

#### Delete Member
`curl -X DELETE http://localhost:8080/api/v1/member/1`