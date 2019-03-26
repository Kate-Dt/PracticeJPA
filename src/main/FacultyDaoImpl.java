package src.main;

import org.springframework.stereotype.Repository;
import src.main.entities.Faculty;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FacultyDaoImpl implements FacultyDao{

    @PersistenceContext
    private EntityManager em;

    public Faculty addFaculty(Faculty faculty) {
        em.persist(faculty);
        return faculty;
    }

    public Faculty getFacultyById(int id) {
        return em.find(Faculty.class, id);
    }

    public void saveFaculty(Faculty faculty) {
        em.merge(faculty);
    }
}
