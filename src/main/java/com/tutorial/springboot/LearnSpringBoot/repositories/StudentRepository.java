package com.tutorial.springboot.LearnSpringBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tutorial.springboot.LearnSpringBoot.persistences.Student;

// @Repository interface responsible for data access.
// The goal is to abstract everything which reduces
// the amount of boilerplate code required to implement
// data access layers for various persistence stores.

// @Repository annotation will convert this interface into a repository that
// can be used for communication with the database.
// Repository interface is provided by Spring Data JPA tat makes it easy
// to communicate with database.
@Repository
// Repository extends JPARepository for JPA methods, flush and batch.
// JPARepository extends PagingAndSortingRepository for pagination and sorting.
// PagingAndStoringRepository extends CrudRepository for CRUD functions.
// we passed in Student Type and data type of Primary Key ID, which is Long
public interface StudentRepository extends JpaRepository<Student, String> {

    Student findByEmail(String email);

    // @Query annotation to write custom query
    @Query("SELECT s from Student s WHERE s.email LIKE %:domain")
    List<Student> findByDomain(@Param("domain") String domain);

}
