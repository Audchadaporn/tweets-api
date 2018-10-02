# Shout API

## Endpoints
The API binds at http://localhost:8080/

### /v1/shout/tweets
Retrieve the N most recent tweets of a Twitter account, limited at 20 tweets.
```
POST /v1/shout/tweets

{ "userName":"twitterapi", "numberOfTweets":3}
```

##Architecture Insights
- REST API
- Hexagonal
- Domain-Driven Design

##Design Patterns
- Singleton
- Dependency Injection

##Libraries and Frameworks
- Akka Http
- Joda Time
- ScalaTest and Mockito
- Scalacache-guava for In-memory cache
- scala-guice for Dependency Injection

##Problems I had run into
- New to Twitter APIs
- New to SprayJsonSupport
- Little knowledge about Hexagonal Architecture and DDD
- Little knowledge about Akka HTTP
- Spent very little time on coding test.
- Some difficulties when integrating a Dependency Injection framework
- Having problems with json serialization and deserialzation
- The application still does not function as expected

##Time spending
Approximately 11-12 hours, including:
- Learnt Twitter APIs
- Learnt Hexagonal and DDD 
- Learnt Akka HTTP
- Design
- Implementation
- Documentation