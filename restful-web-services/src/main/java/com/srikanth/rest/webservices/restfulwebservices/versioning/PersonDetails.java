package com.srikanth.rest.webservices.restfulwebservices.versioning;

public class PersonDetails  {
    @Override
    public String toString() {
        return "PersonDetails{" +
                "name=" + name +
                '}';
    }

    private Name name;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public PersonDetails(Name name) {
        super();
        this.name = name;
    }
}
