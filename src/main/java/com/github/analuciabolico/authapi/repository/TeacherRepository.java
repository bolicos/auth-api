package com.github.analuciabolico.authapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.analuciabolico.authapi.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
