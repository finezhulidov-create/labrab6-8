package dev.zhulidov.labrab6_8.service;

import dev.zhulidov.labrab6_8.dao.StudentDao;
import dev.zhulidov.labrab6_8.entity.Student;
import dev.zhulidov.labrab6_8.excptn.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDao studentDao;

    public List<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }

    @Transactional
    public Student saveStudent(Student student){
        return studentDao.saveStudent(student);
    }

    public Student getStudent(Long id){
        return studentDao.getStudent(id)
                .orElseThrow(()-> new StudentNotFoundException("Student not found"));
    }

    @Transactional
    public void deleteStudent(Long id){
        studentDao.deleteStudent(id);
    }
}
