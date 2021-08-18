package com.github.analuciabolico.authapi.controller;

import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.analuciabolico.authapi.model.Class;
import com.github.analuciabolico.authapi.model.Teacher;
import com.github.analuciabolico.authapi.repository.TeacherRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/teachers")
public class TeacherController {

    private final TeacherRepository repository;

    @GetMapping
    public ResponseEntity<List<Teacher>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody final Teacher teacher) {
        return ResponseEntity.ok(this.repository.save(teacher)
                                                .getRegistration());
    }

    @GetMapping(path = "/{registration}")
    public ResponseEntity<Teacher> findBy(@PathVariable final String registration) {
        return ResponseEntity.ok(this.repository.findById(registration)
                                                .orElseThrow(EntityNotFoundException::new));
    }

    @GetMapping(path = "/{registration}/classes")
    public ResponseEntity<Set<Class>> findByClasses(@PathVariable final String registration) {
        final Teacher teacher = this.repository.findById(registration)
                                               .orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(teacher.getClasses());
    }

}
