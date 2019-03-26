package src.main;

import org.springframework.beans.factory.annotation.Autowired;
import src.main.entities.Faculty;
import src.main.entities.Lecture;

public class FacultyWorker {

    @Autowired
    FacultyDao facultyDao;

    public Faculty addFaculty(Faculty faculty){
        faculty = facultyDao.addFaculty(faculty);
        System.out.println(faculty);
        return faculty;
    }
}
