package com.tutorial.springboot.LearnSpringBoot.Controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController tells spring boot that this class is going to be handling
// the rest API functions. We will create a simple endpoint of what should
// happen when we go into localhost:8080

// this class object, linked to this to any other functions, it will be managed by 
// Spring boot automatically through the annotation at controller, this is a convention 
// over configuration, it has configured a lot of things in the back end, so nothing 
// extra needs to be done.
@RestController
// @Profile annotation to link this class to a profile and customize which
// contorllers to use for different environment based on the prfoile that is
// active in application-properties file.
@Profile("dev")
public class MySimpleDevController {

    // when the page is loaded, it will automatically go to this function
    // In the web, it has different type of mapping like GetMapping, PostMapping
    // DeleteMapping, etc.
    // @RequestMapping allow any kind of HTTP request, if we want some retricted
    // request, we use parameter method = specific method type like DELETE, GET,
    // POST,
    // PUT, etc. If we use method = RequestMethod.GET, only the Get HTTP request
    // will
    // call this function.
    @RequestMapping(value = { "/home" })
    public String home() {
        return "Hello Dev World";
    }

    // instead of using @ReqestMapping, Spring boot make it easier for us by using
    // other shorthand way of writing the mapping request with
    // annotation like GetMapping, which is equivalent to
    // @RequestMapping(value = {"/"}, method=RequestMethod.GET)
    @GetMapping("/getmapping")
    public String getHome() {
        return "Hello Dev World Get";
    }

    @PostMapping("/postmapping")
    public String postHome() {
        return "Hello Dev World Post";
    }

    @PutMapping("/putmapping")
    public String putHome() {
        return "Hello Dev World Put";
    }

    @DeleteMapping("/deletemapping")
    public String deleteHome() {
        return "Hello Dev World Delete";
    }

}
