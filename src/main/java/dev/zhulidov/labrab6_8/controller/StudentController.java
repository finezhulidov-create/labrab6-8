package dev.zhulidov.labrab6_8.controller;

import dev.zhulidov.labrab6_8.entity.Student;
import dev.zhulidov.labrab6_8.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;



    @GetMapping("students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id")Long id){
        return ResponseEntity.ok(service.getStudent(id));
    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return ResponseEntity.ok(service.saveStudent(student));
    }

    @PutMapping("/students")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return ResponseEntity.ok(service.saveStudent(student));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id")Long id){
        service.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
