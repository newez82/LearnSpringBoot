package com.tutorial.springboot.LearnSpringBoot.persistences;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

// @Entity annotation will let Spring JPA knows this class is going
// to be a database table
@Entity
// @Data will generate getter, setter, hardcode, toString and constructor
@Data
// @Builder build object in an esay way using the design pattern
@Builder
public class Student {

    // @Id annotation to specify this field is a primary key
    @Id
    // @GeneratedValue will generate the Id automatically incremented sequence.
    // GenerationType.Auto will tell the Spring Data JPA choose whatever
    // approach you think is the best.
    // GenerationType.IDENTITY will use dastabase identity column, it is recommended
    // to use in MySQL
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    private String firstName;
    private String lastName;
    // set email as unique using @Column annotation,
    // it will set the unqiue constraint on email column
    @Column(unique = true)
    private String email;

    public Student() {
    }

    public Student(String id, String firstName, String lastName, String email) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
