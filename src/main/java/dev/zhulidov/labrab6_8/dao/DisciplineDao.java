package dev.zhulidov.labrab6_8.dao;

import dev.zhulidov.labrab6_8.entity.Discipline;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DisciplineDao {

    private final EntityManager entityManager;

    public Set<Discipline> getAllDisciplinesByStudent(Long id){
       return (Set<Discipline>) entityManager.createQuery("SELECT d FROM Student s JOIN s.disciplines d WHERE s.id = :studentId")
               .setParameter("studentId",id)
               .getResultStream().collect(Collectors.toUnmodifiableSet());
    }

    public Optional<Discipline> getDiscipline(Long id){
        return Optional.of(entityManager.find(Discipline.class,id));
    }

    public Discipline save(Discipline discipline){
        return entityManager.merge(discipline);
    }

    public void deleteDisc(Long id){
        entityManager.createQuery("delete from discipline "
                + " where id =:disciplineId")
                .setParameter("disciplineId",id)
                .executeUpdate();
    }
}
