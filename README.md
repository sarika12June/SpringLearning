# SpringLearning
#Web Services :
   1) Designed for  application to application interaction
	  *Create the request from any application  to webservice and then webservice the sents the response to application
   2)Should be interoperable-not platform dependent
     *Request format and Response format should be platform independent , this can achieved by xml and 
	 
   3) Should allow communication over network
   *Any Web service has service definition =>    request/reponse format => Request Structure =>Response Structure =>Enpoint
   
#Key terminology
 *Request and Response =>input and output of webservice
 *Message Exchange format=> format of req and response
    *Xml and Json
 *Service provider or server :Webservice(host web service)
 *Service consumer or client :requestor of webservice
 *Service Defination:contract/format  and url of webservice
 *Transport
   *Http(url) and MQ(queue =>topic)

#SOAP(Simple object access portocol):
*it posses restriction on request(XML) and response(xml)
*it has specfic format soap-env:header(metadata=> auth, auto),body:(req and res content)
Format - SOAP XML Request - SOAP XML Response
Transport
	SOAP over MQ
	SOAP over HTTP
Service Definition
	WSDL =>(endpoint, all api,  req and res struture)



#Rest(Resprenational State transfer):only http 
*Architectural approach
*It is devloped by roy feilding who devloped http portcol
*Over the web req and res format defined by http methods and know the response by http status 
*Swagger =>Service defination
*Resource req and res => html ,xml and json
*Can be communicated to web service using uri
   example:
        */user/srikanth/todos/1
		*/user/srikanth/todos
		*/user/srikanth
		
#Difference between Rest and SOAP
=>Restrictions vs Architectural Approach
=>Data Exchange Format=>XML/{html, json, xml,etc}
=>Service Definition=> WSDL/Swagger
=>Transport=>html.mq/Html
=>Ease of implementation


#Documentation(springdoc-openapi):
	Open API
#Content negotition (jackson-dataformat-xml) :
	different content type ,different language =>(request -header) consumer has set accept-header with mime type of xml and accept-language -english.
#II18N -accept-language -english.Message resource =>LocaleContextHolder

#HateOAS:hypermedia as the engine of Application state
    it gives reference for an subsequent action for that particular rest api => it gives links for reference
	*Implementation =>Custom format and impl(response entity)2)=>use standard  implementation =>HAL (JSON hypertext application links) _links
	
	*EnitityModel and webmvclinkbuilder
	*HAL EXPORLER-groupid :data artificatid :spring-data-hal-exporler

#Filtering :customizing the response which returned jackson framework.
@jsonProperty("define_atributename")
static :if u do not want return the password a cross all the resp api =>JsonIgnore .JsonignoreProperties
dynamic :custom filtering for diffrent api =>MappingJackosonValue,SimpleBeanPropertyFilter,FilterProvide
          define filterName on Bean =>@JsonFilter
		  
#Spring  Acutator

   Provides production ready featurs like monitor and manage ur application in production
Impl: add acutator to pom.xml and  it provides of end point beans , health, metrics,and mapping

#Versioning 

*url,request parameter,header,media type

	URI Versioning

		V1: http://localhost:8080/v1/person

		@GetMapping("/v1/person")

		V2: http://localhost:8080/v2/person

		@GetMapping("/v2/person")

	Request Param Versioning

		V1: http://localhost:8080/person?version=1

		@GetMapping(path = "/person", params = "version=1")

		V2: http://localhost:8080/person?version=2

		@GetMapping(path = "/person", params = "version=2")

Header Versioning

		V1: http://localhost:8080/person/header

		HEADER - X-API-VERSION:1

		@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")

		V2: http://localhost:8080/person/header

		HEADER - X-API-VERSION:2

		@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")

Content Negotiation Versioning

		V1: http://localhost:8080/person/accept

		HEADER - Accept:application/vnd.company.app-v1+json

		@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")

		V2: http://localhost:8080/person/accept

		HEADER - Accept:application/vnd.company.app-v1+json

		@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")

		V1 Response

		{
		  "name": "Bob Charlie"
		}
		V2 Response

		{
		  "name": {
			"firstName": "Bob",
			"lastName": "Charlie"
		  }

















#Docker :

Launch MySQL as Docker Container
docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=social-media-user --env MYSQL_PASSWORD=dummypassword --env MYSQL_DATABASE=social-media-database --name mysql --publish 3306:3306 mysql:8-oracle

break down above cmd:

docker run --detach
--env MYSQL_ROOT_PASSWORD=dummypassword 
--env MYSQL_USER=social-media-user 
--env MYSQL_PASSWORD=dummypassword 
--env MYSQL_DATABASE=social-media-database 
--name mysql(container name)
--publish 3306:3306 
mysql:8-oracle(image name)

 

mysqlsh commands
mysqlsh
\connect social-media-user@localhost:3306
\sql
use social-media-database
select * from user_details;
select * from post;
\quit


/pom.xml Modified
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
</dependency> 


/src/main/resources/application.properties Modified
#spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.show-sql=true
spring.datasource.url=jdbc:mysql://localhost:3306/social-media-database
spring.datasource.username=social-media-user
spring.datasource.password=dummypassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   
#Spring Security 

Filter chain all request auth with username and password  
CRSF => post , put

for rest api we will use http basic auth 
disable CRSF

impl
Create Spring Configuaration
Bean Filter Chain 






	
	