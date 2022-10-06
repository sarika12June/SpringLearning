package com.srikanth.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposistryJPA extends JpaRepository<User,Integer> {
}
