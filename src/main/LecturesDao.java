package src.main;

import src.main.entities.Lecture;

public interface LecturesDao {

    Lecture addLecture(Lecture lecture);
    Lecture getLecture(int id);
    void saveLecture(Lecture lecture);
}
