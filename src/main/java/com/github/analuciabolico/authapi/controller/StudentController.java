package com.github.analuciabolico.authapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.analuciabolico.authapi.model.Student;
import com.github.analuciabolico.authapi.repository.StudentRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/students")
public class StudentController {

    private final StudentRepository repository;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody final Student student) {
        return ResponseEntity.ok(this.repository.save(student)
                                                .getRegistration());
    }

}
