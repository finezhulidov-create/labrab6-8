package dev.zhulidov.labrab6_8.dao;

import dev.zhulidov.labrab6_8.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface StudentDao {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Optional<Student> getStudent(Long id);

    void deleteStudent(Long id);
}
