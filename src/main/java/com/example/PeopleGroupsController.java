package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Eric on 3/17/17.
 */

@RestController
public class PeopleGroupsController {

    @Autowired
    UserRepository users;


    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> readUser() {
        return (List<User>) users.findAll();
    }
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public void createUser(@RequestBody User user) {
        users.save(user);
    }
    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        users.save(user);
    }
    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id) {
        users.delete(id);
    }
    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id) {
        return users.findOne(id);
    }

    @PostConstruct
    public void init() {
        if (users.count() == 0) {
            User user = new User();
            user.username = "Zach";
            user.address = "123 hunter lane";
            user.email = "zach@gmail.com";
            user.groups = "groups1";  //possibly have to list several group objects here
            users.save(user);
        }
    }

}
