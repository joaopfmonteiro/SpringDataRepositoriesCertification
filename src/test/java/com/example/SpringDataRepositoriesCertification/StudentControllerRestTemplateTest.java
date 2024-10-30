package com.example.SpringDataRepositoriesCertification;

import com.example.SpringDataRepositoriesCertification.core.Course;
import com.example.SpringDataRepositoriesCertification.core.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentControllerRestTemplateTest {
    @Test
    void testPost() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", MediaType.APPLICATION_JSON_VALUE);
        Student student = new Student();
        student.setDept("History");
        student.setFirstName("Fred");
        student.setLastName("Flintstone");
        student.setFess(122.00);
        Course course = new Course();
        course.setLocation("University of Miami");
        course.setStudent(student);
        course.setTitle("History of Carthage");
        student.getCourses().add(course);
        ResponseEntity<String> response = new RestTemplate().postForEntity("http://localhost:8080/student", new HttpEntity(student, headers), String.class);
        String url = response.getHeaders().get("location").get(0);
        Student attendee = new RestTemplate().getForObject("http://localhost:8080/" + url, Student.class);
        System.out.println(attendee);
    }

    @Test
    void testPostNegative() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Student student = new Student();
        student.setDept("History");
        student.setFirstName("Barney");
        student.setLastName("Rubble");
        student.setFess(201.00);

        Course course = new Course();
        course.setLocation("University of Miami");
        course.setTitle("History of Carthage");
        course.setStudent(student);
        student.getCourses().add(course);

        HttpClientErrorException exception = Assertions.assertThrows(HttpClientErrorException.class, () -> {
            new RestTemplate().postForEntity(
                    "http://localhost:8080/student",
                    new HttpEntity<>(student, headers),
                    String.class
            );
        });

        assertThat(exception.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
