package src.main;

import org.springframework.beans.factory.annotation.Autowired;
import src.main.entities.Lecture;

import java.util.List;

public class LecturesWorker {

    @Autowired
    LecturesDao lecturesDao;

    public List<Lecture> getFacultyLectures(String facultyName){
        List<Lecture> result = lecturesDao.getFacultyLectures(facultyName);
        System.out.println("Inside getFacultyLectures()");
        return result;
    }

    public Lecture addLecture(Lecture lecture){
        lecture = lecturesDao.addLecture(lecture);
        System.out.println(lecture);
        return lecture;
    }
}
