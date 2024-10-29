package com.example.SpringDataRepositoriesCertification.repository;

import com.example.SpringDataRepositoriesCertification.core.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "course", path = "courses")
public interface CourseRepository extends JpaRepository<Course, Long> {
}
