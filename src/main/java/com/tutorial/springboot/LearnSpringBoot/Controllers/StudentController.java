package com.tutorial.springboot.LearnSpringBoot.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springboot.LearnSpringBoot.persistences.Student;
import com.tutorial.springboot.LearnSpringBoot.repositories.StudentRepository;

@RestController
public class StudentController {

    /*
     * Starting with Spring 4.3, if a class, which is configured as a Spring
     * bean, has only one constructor, the @Autowired annotation can be omitted
     * and Spring will use that constructor and inject all necessary
     * dependencies.
     */
    // Use dependence injection as much as possible for student service.
    // to tell compiler to inject Student Service variable into the constructor
    // for us instead by calling @Autowired annotation
    // @Autowired

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // @RequestBody to send Student Object, when sending a post request,
    // we can send a request to body along with it.
    @PostMapping("/student/save")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // @RequestParam to send Student Object, when sending a Get request,
    // there is only a request parameter, it doesn't have any request body.
    @GetMapping("/student/findByEmail")
    public Student findStudent(@RequestParam("email") String email) {
        return studentRepository.findByEmail(email);
    }

    // @PatchMapping to perform partial update the entity
    // @PutMapping to perform entire update / replace on entity
    @PatchMapping("/student/update")
    public Student findStudent(@RequestParam("student_id") String id, @RequestParam("new_email") String email) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student studentObj = student.get();
            studentObj.setEmail(email);
            return studentRepository.save(studentObj);
        }
        return null;
    }

    @GetMapping("/student/findByEmailDomain")
    public List<Student> findStudentByDomain(@RequestParam("domain") String domain) {
        return studentRepository.findByDomain(domain);
    }

}
