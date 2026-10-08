package dev.zhulidov.labrab6_8.controller;

import dev.zhulidov.labrab6_8.entity.Discipline;
import dev.zhulidov.labrab6_8.service.DisciplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DisciplineController {

    private final DisciplineService service;

    @GetMapping("/disciplines/{studentId}")
    public ResponseEntity<Set<Discipline>> getAll(@PathVariable("studentId")Long studentId){
        return ResponseEntity.ok(service.getAllByStudent(studentId));
    }

    @GetMapping("/disciplines/{discId}")
    public ResponseEntity<Discipline> getDisc(@PathVariable Long discId){
        return ResponseEntity.ok(service.get(discId));
    }

    @PostMapping("/disciplines")
    public ResponseEntity<Discipline> saveDsc(@RequestBody Discipline discipline){
        return ResponseEntity.ok(service.save(discipline));
    }

    @PutMapping("/disciplines")
    public ResponseEntity<Discipline> updateDsc(@RequestBody Discipline discipline){
        return ResponseEntity.ok(service.save(discipline));
    }

    @DeleteMapping("/disciplines/{discId}")
    public ResponseEntity<Void> deleteDsc(@PathVariable Long discId){
        service.delete(discId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
