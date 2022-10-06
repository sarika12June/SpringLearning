package com.srikanth.rest.webservices.restfulwebservices.user;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users =new ArrayList<>();
    private static int userCount =0;
    static{
        users.add(new User(++userCount,"Srikanth", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Sarika", LocalDate.now().minusYears(28)));

    }

    public  List<User> getUsers() {
        return users;
    }

    public User Save(User user) {
    return null;
    }
    public User findOne(int id){
        return users.stream().filter(user ->user.getId().equals(id)).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id){
        users.removeIf(user ->user.getId().equals(id));
    }
}
