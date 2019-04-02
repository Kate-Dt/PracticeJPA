package src.main;

import org.springframework.stereotype.Repository;
import src.main.entities.Lecture;

import org.springframework.cache.annotation.Cacheable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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

    @Cacheable("lecturesCache")
    public List<Lecture> getFacultyLectures(String facultyName){
        return em.createNamedQuery(
                "selectFacultyLectures", Lecture.class)
                .setParameter("name", facultyName)
                .getResultList();
    }
}
