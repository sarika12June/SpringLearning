package com.srikanth.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionindDemo {

    @GetMapping("/v1/person")
    public Person getPersonFullName(){
        return new Person("Srikanth M");
    }

    @GetMapping("/v2/person")
    public PersonDetails getPersonInDetails(){
        return new PersonDetails(new Name("Srikanth","Madu"));
    }

    @GetMapping(path="person",params="version-1")
    public PersonDetails getPersonWithRequestParam(){
        return new PersonDetails(new Name("Srikanth","Madu"));
    }

    @GetMapping(path="person/header",headers="X-API-VERSION=1")
    public PersonDetails getPersonWithHeadertParam(){
        return new PersonDetails(new Name("Srikanth","Madu"));
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonDetails getPersonWithAcceptParam(){
        return new PersonDetails(new Name("Srikanth","Madu"));
    }
}
