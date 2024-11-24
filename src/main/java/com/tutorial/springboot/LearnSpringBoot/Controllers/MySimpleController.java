package com.tutorial.springboot.LearnSpringBoot.Controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springboot.LearnSpringBoot.Calculator;

/*
 * A key difference between a traditional MVC controller and the RESTful web service controller 
 * shown earlier is the way that the HTTP response body is created. Rather than relying on a 
 * view technology to perform server-side rendering of the greeting data to HTML, this RESTful 
 * web service controller populates and returns a Greeting object. The object data will be 
 * written directly to the HTTP response as JSON.
 * 
 * This code uses Spring @RestController annotation, which marks the class as a controller 
 * where every method returns a domain object instead of a view. It is shorthand for including 
 * both @Controller and @ResponseBody.
 */

// @RestController tells spring boot that this class is going to be handling
// the rest API functions. We will create a simple endpoint of what should
// happen when we go into localhost:8080

// this class object, linked to this to any other functions, it will be managed by 
// Spring boot automatically through the annotation at controller, this is a convention 
// over configuration, it has configured a lot of things in the back end, so nothing 
// extra needs to be done.
@RestController // handle HTTP resquest
// @Profile annotation to link this class to a profile and customize which
// contorllers to use for different environment based on the prfoile that is
// active in application-properties file.
@Profile("prod")
public class MySimpleController {

    // using @Autowired on the attribure, this is a field injection
    // becuase the dependency injector inject value into calculator field.
    // it is not recommeded, it is better to use constructor injection
    // to wire up dependencies and @ComponentScan to find beans
    // instead of field injection.
    // field be marked as final, indicating that it cannot be subsequently changed.
    private final Calculator calculator;

    // when providing the constructor, spring boot will automatically identify
    // it as something i need to inject and use it
    // If a bean has more than one constructor, you will need to mark the one you
    // want Spring to use with @Autowired
    public MySimpleController(Calculator calculator) {
        this.calculator = calculator;
    }

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
        return "Hello World";
    }

    // instead of using @ReqestMapping, Spring boot make it easier for us by using
    // other shorthand way of writing the mapping request with
    // annotation like GetMapping, which is equivalent to
    // @RequestMapping(value = {"/"}, method=RequestMethod.GET)
    @GetMapping("/getmapping")
    public String getHome() {
        return "Hello World Get";
    }

    @PostMapping("/postmapping")
    public String postHome() {
        return "Hello World Post";
    }

    @PutMapping("/putmapping")
    public String putHome() {
        return "Hello World Put";
    }

    @DeleteMapping("/deletemapping")
    public String deleteHome() {
        return "Hello World Delete";
    }

    // pass in 2 parameter and return the sum of 2 values
    // localhost:8080/sum?a=6&b=7
    @GetMapping("/sum")
    public String sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        // we will have spring create the class for us instead of manually
        // create a new Calcuator object using dependency injection
        return calculator.calculateSum(a, b) + "";
    }
}
