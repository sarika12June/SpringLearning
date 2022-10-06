package com.learn.jpa.hibernate.learnjpahibernate.springjdbc;

import com.learn.jpa.hibernate.learnjpahibernate.springjdbc.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseRepoistry courseRepoistry;
    @Override
    public void run(String... args) throws Exception {
        courseRepoistry.insert(new Course(1,"Learn AWS Now","Srikanth_SoftSol"));
        courseRepoistry.insert(new Course(2,"Learn Docker Now","Srikanth_SoftSol"));
        courseRepoistry.insert(new Course(3,"Learn Kubenrates Now","Srikanth_SoftSol"));

        courseRepoistry.deleteById(2);
        System.out.println("Check here "+courseRepoistry.findById(3));

        System.out.println("--------------------");
    }
}
