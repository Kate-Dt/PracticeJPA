package src.main;

import org.springframework.stereotype.Repository;
import src.main.entities.Lecture;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class LectureDaoImpl implements LecturesDao{

    @PersistenceContext
    private EntityManager em;

    public Lecture addLecture(Lecture lecture) {
        em.persist(lecture);
        return lecture;
    }

    public Lecture getLecture(int id) {
        return em.find(Lecture.class, id);
    }

    public void saveLecture(Lecture lecture) {
        em.merge(lecture);
    }
}
