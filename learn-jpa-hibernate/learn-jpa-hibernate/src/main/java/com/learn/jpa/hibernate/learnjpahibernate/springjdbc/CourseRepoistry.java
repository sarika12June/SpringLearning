package com.learn.jpa.hibernate.learnjpahibernate.springjdbc;

import com.learn.jpa.hibernate.learnjpahibernate.springjdbc.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepoistry {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static String INSERT_QUERY=
           """
        insert into course(id,name,author)
        values(?,?,?);
        """;
    private static String DELETE_QUERY=
            """
                    DELETE from course
                    where id=?
                    """;
    private static String SELECT_QUERY=
            """
                    Select * from course
                    where id=?
                    """;
    public void insert(Course course){
        jdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteById(long id){
        jdbcTemplate.update(DELETE_QUERY,id);
    }

    public Course findById(long id){
        return (Course) jdbcTemplate.queryForObject(SELECT_QUERY, new Object[]{id}, new BeanPropertyRowMapper(Course.class));
    }

}
