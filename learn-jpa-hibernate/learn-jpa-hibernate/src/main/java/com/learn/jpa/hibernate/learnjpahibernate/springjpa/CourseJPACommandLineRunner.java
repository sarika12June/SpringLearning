package com.learn.jpa.hibernate.learnjpahibernate.springjpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJPACommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseRepoSpringJPA courseRepoistry;
    @Override
    public void run(String... args) throws Exception {
        /*System.out.println("JPA ");
        courseRepoistry.insert(new CourseDetails(1,"Learn AWS JPA Now","Srikanth_SoftSol"));
        courseRepoistry.insert(new CourseDetails(2,"Learn Docker JPA Now","Srikanth_SoftSol"));
        courseRepoistry.insert(new CourseDetails(3,"Learn Kubenrates  JPA Now","Srikanth_SoftSol"));

        courseRepoistry.deleteById(2);
        System.out.println("Check here "+courseRepoistry.findById(3));
*/
        System.out.println("--------------------");

        courseRepoistry.save(new CourseDetails(1,"Learn AWS SpringJPA Now","Srikanth_SoftSol"));
        courseRepoistry.save(new CourseDetails(2,"Learn Docker SpringJPA Now","Srikanth_SoftSol"));
        courseRepoistry.save(new CourseDetails(3,"Learn Kubenrates  SpringJPA Now","Srikanth_SoftSol"));

        courseRepoistry.deleteById(2l);
        System.out.println("Count "+courseRepoistry.count());
        System.out.println("find all "+courseRepoistry.findAll());
        System.out.println("Check here "+courseRepoistry.findById(3l));
        System.out.println("findByAuthor "+courseRepoistry.findByAuthor("Srikanth_SoftSol"));
        System.out.println("findByName "+courseRepoistry.findByName("Learn Kubenrates  SpringJPA Now"));
        System.out.println("findByName "+courseRepoistry.findByName("Learn dassdad  SpringJPA Now"));

    }
}
