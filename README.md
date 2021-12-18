# superhero
-----------------------------------------------------------------------
Tech Test
-----------------------------------------------------------------------

Please create an application that exposes at least two http endpoints to manage a superhero entity (Object Schema and examples provided below).

{
alias: 'Captain Marvel',
name: 'Carol Danvers',
powers: ['photon-blast', 'flight', 'super-strength', 'healing'],
weapons: [],
origin: 'Exposed to Space Stone reactor overload',
associations: ['space-stone', 'skrulls', 'photon', 'kree', 'avengers']
}

{
alias: 'Iron Man',
name: 'Tony Stark',
powers: ['genius-intelligence', 'wealth'],
weapons: ['arc-reactor', 'iron-man-suit', 'iron-legion'],
origin: 'Kidnapped in Afghanistan, created the first iron-man suit to escape.',
associations: ['war-machine', 'avengers', 'jarvis', 'thanos', 'pepper-potts']
}

Use this as a showcase of your capabilities. We are looking for well structured, well designed and easy to extend code.

At a minimum
You should be able to create new instances of the entity.
You should be able to retrieve instances of the entity,
This application should be packaged into a docker container with instructions on how to run the application and any details of any assumptions you have made to be provided in a README.md file.

Feel free to add any elements you feel would benefit this application in a real world use case.

Set up a private Git repository (do constant, small commits), and in the end git bundle
it and share it with us in a zip file.

## Deliverables:
# Setup
## App Requirements
- JVM running on your local machine
- Maven
- An IDE of your choice

### Running the app
. To run the app you can use the following maven commands

./mvnw spring-boot:run

. To run the app you can use the following docker commands  
docker build -t springboot-docker-superhero:latest .

docker run springboot-docker-superhero

##openApi: 
http://localhost:8080/api-docs/

{"openapi":"3.0.1","info":{"title":"OpenAPI definition","version":"v0"},"servers":[{"url":"http://localhost:8080/","description":"Generated server url"}],"paths":{"/Superhero/api/v1/create":{"post":{"tags":["superhero-controller"],"operationId":"add","requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/SuperheroDto"}}},"required":true},"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"type":"string"}}}}}}},"/Superhero/api/v1/retrieve/{superheroId}":{"get":{"tags":["superhero-controller"],"operationId":"getSuperhero","parameters":[{"name":"superheroId","in":"path","required":true,"schema":{"type":"integer","format":"int64"}}],"responses":{"200":{"description":"OK","content":{"*/*":{"schema":{"$ref":"#/components/schemas/SuperheroDto"}}}}}}}},"components":{"schemas":{"SuperheroDto":{"type":"object","properties":{"alias":{"type":"string"},"name":{"type":"string"},"powers":{"type":"array","items":{"type":"string"}},"weapons":{"type":"array","items":{"type":"string"}},"origin":{"type":"string"},"associations":{"type":"array","items":{"type":"string"}}}}}}}

## CURL
- add api

curl --location --request POST 'http://localhost:8080/Superhero/api/v1/create' \
--header 'Content-Type: application/json' \
--data-raw '
{
"alias": "Captain Marvel",
"name": "Carol Danvers",
"powers": ["photon-blast", "flight", "super-strengt", "healing"],
"weapons": [],
"origin": "Exposed to Space Stone reactor overloa",
"associations":["space-stone", "skrulls", "photon","kree", "avengers"]
}'
- getSuperhero api

curl --location --request GET 'http://localhost:8080/Superhero/api/v1/retrieve/1' \
--header 'Content-Type: application/json'


