# spring-security-pattern-tester
Spring Boot application that can validate URL patterns used by Spring Security

## Building
Run `mvn clean package`

## Running
Because this is a Spring Boot application, it can be run as simply as
```
java -jar target/spring-security-pattern-tester-1.0.0.SNAPSHOT.jar
```

It is also possible to push this to a Cloud Foundry deployment, and is currently
hosted on Pivotal Web Services.

## Invoking
Make an HTTP POST call to http://host:port/testpattern with a JSON body that looks
like this:
```json
{
  "pattern": "/my/**/pattern",
  "type": "ANT",
  "testUri": "/my/passing/pattern"
}
```

It will return a body that looks like this:
```json
{
  "pattern": "/my/**/pattern",
  "type": "ANT",
  "testUri": "/my/passing/pattern",
  "timestamp": 1421860684293,
  "matched": true
}
```

The `type` parameter can currently be either `ANT` or `REGEX`.

There is also an `/alive` endpoint that can be invoked via HTTP HEAD to determine
if the service is up and running. It simply returns an HTTP 200.
