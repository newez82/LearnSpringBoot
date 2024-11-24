package com.tutorial.springboot.LearnSpringBoot;

import org.springframework.stereotype.Component;

// Annotate this class as a spring bean to have spring boot create the
// object for us by using @Component. Sprint boot will detect this
// annotation to know know this is managed by spring boot and inject
// it into the application.
@Component
public class Calculator {

    public int calculateSum(int a, int b) {
        return a + b;
    }
}
