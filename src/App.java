package src;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import src.main.entities.Lecture;
import src.main.LecturesWorker;

public class App {

    public static void main(String[] args){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringBeans.xml");
        Lecture lecture = new Lecture();
        lecture.setName("Introduction to Spring");
        lecture.setCredits(2.5);
        LecturesWorker worker =
                (LecturesWorker)context.getBean("lectureWorker");
        System.out.println(lecture.getCredits());
        worker.addLecture(lecture);
    }
}
