# Campmap

## Local develop setting


### application-local.properties

spring.datasource.url

spring.datasource.username

spring.datasource.password

### start the server 

mvn spring-boot:run -Dspring-boot.run.profiles=local


## Sample API with curl 

*POST /sample/create*

``` shell
curl -X POST http://localhost:8088/sample/insert \
-H "Content-Type: application/json" \
-d '{
"id": "3",
"name": "Alice",
"age": 22
}'
```

*GET /sample/{id}*

``` shell
curl -X GET http://localhost:8088/sample/3
```


*GET /sample/queryAll*

``` shell
curl -X GET http://localhost:8088/sample/queryAll
```

*DELETE /sample/{id}*

``` shell
curl -X DELETE http://localhost:8088/sample/{id}
```