package com.learn.jpa.hibernate.learnjpahibernate.springjpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="Course_Details")
public class CourseDetails {
    @Id
    private long id;
    private String name;
    private String author;

    @Override
    public String toString() {
        return "CourseDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public CourseDetails(long id, String name, String author) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public CourseDetails() {
    }
}
