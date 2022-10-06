package com.learn.jpa.hibernate.learnjpahibernate.springjpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepoistry  {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(CourseDetails course){
        entityManager.merge(course);
    }

    public void deleteById(long id){
        CourseDetails course= entityManager.find(CourseDetails.class,id);
        entityManager.remove(course);

    }

    public CourseDetails findById(long id){
        return entityManager.find(CourseDetails.class,id);
    }
}
