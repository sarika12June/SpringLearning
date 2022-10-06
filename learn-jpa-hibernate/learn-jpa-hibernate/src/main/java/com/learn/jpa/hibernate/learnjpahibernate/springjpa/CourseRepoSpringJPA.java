package com.learn.jpa.hibernate.learnjpahibernate.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepoSpringJPA extends JpaRepository<CourseDetails,Long> {

    public List<CourseDetails> findByAuthor(String author);
    public List<CourseDetails> findByName(String name);
}
