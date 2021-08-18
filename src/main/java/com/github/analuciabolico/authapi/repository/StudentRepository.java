package com.github.analuciabolico.authapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.analuciabolico.authapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
