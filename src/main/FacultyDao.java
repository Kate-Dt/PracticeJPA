package src.main;

import src.main.entities.Faculty;

public interface FacultyDao {
    Faculty addFaculty(Faculty teacher);
    Faculty getFacultyById(int id);
    void saveFaculty(Faculty teacher);
}