package dev.zhulidov.labrab6_8.service;

import dev.zhulidov.labrab6_8.dao.DisciplineDao;
import dev.zhulidov.labrab6_8.entity.Discipline;
import dev.zhulidov.labrab6_8.excptn.DisciplineNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class DisciplineService {
    private final DisciplineDao dao;

    public Set<Discipline> getAllByStudent(Long studentId){
        return dao.getAllDisciplinesByStudent(studentId);
    }

    public Discipline get(Long id){
        return dao.getDiscipline(id).orElseThrow(()-> new DisciplineNotFoundException("Discipline not found"));
    }
    @Transactional
    public Discipline save(Discipline discipline){
        return dao.save(discipline);
    }

    @Transactional
    public void delete(Long id){
        dao.deleteDisc(id);
    }
}
