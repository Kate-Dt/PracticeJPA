package src.main;

import src.main.entities.Lecture;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface LecturesDao {

    Lecture addLecture(Lecture lecture);
    Lecture getLecture(int id);
    List<Lecture> getFacultyLectures(String facultyName);
    void saveLecture(Lecture lecture);
}
