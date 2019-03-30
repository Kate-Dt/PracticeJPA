package src;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import src.main.FacultyWorker;
import src.main.entities.Faculty;
import src.main.entities.Lecture;
import src.main.LecturesWorker;

public class App {

    public static void main(String[] args){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringBeans.xml");
        Lecture lecture1 = new Lecture();
        lecture1.setName("Introduction to Spring");
        lecture1.setCredits(2.5);

        Lecture lecture2 = new Lecture();
        lecture2.setName("Metaphysics");
        lecture2.setCredits(1.5);

        Lecture lecture3 = new Lecture();
        lecture3.setName("Introduction to Java");
        lecture3.setCredits(3);

        Lecture lecture4 = new Lecture();
        lecture4.setName("Philosophy of science");
        lecture4.setCredits(2.5);

        Faculty faculty1 = new Faculty("Informatics", lecture1, lecture3);
        Faculty faculty2 = new Faculty("Philosophy", lecture2, lecture4);

        FacultyWorker fworker =
                (FacultyWorker)context.getBean("facultyWorker");
        System.out.println(lecture1.getCredits());
        fworker.addFaculty(faculty1);
        fworker.addFaculty(faculty2);

        LecturesWorker lworker =
                (LecturesWorker)context.getBean("lectureWorker");
        System.out.println(lecture1.getCredits());
        lworker.addLecture(lecture1);
        lworker.addLecture(lecture2);
        lworker.addLecture(lecture3);
        lworker.addLecture(lecture4);

    }
}
