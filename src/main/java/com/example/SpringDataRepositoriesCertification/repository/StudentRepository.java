package com.example.SpringDataRepositoriesCertification.repository;

import com.example.SpringDataRepositoriesCertification.core.Person;
import com.example.SpringDataRepositoriesCertification.core.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "student", path = "enrollments", excerptProjection = Person.class)
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT student FROM Student student where student.dept = :dept")
    Collection<Student> findByDept(@Param("dept") String department);
}
