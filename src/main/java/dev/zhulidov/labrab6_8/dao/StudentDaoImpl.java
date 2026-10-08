package dev.zhulidov.labrab6_8.dao;

import dev.zhulidov.labrab6_8.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Slf4j
@Repository
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {
    private final EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        Query query = entityManager.createQuery("from students");
        List<Student> allStudents = query.getResultList();
        log.info("getAllStudents: {}", allStudents);
        return allStudents;
    }

    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Optional<Student> getStudent(Long id) {
        return Optional.of(entityManager.find(Student.class,id));
    }

    @Override
    public void deleteStudent(Long id) {
        Query query = entityManager.createQuery("delete from student "
        + " where id =:studentID");
        query.setParameter("studentId", id);
        query.executeUpdate();
    }
}
