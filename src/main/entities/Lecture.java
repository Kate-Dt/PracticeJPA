package src.main.entities;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "selectFacultyLectures",
                 query= "SELECT DISTINCT l " +
                        "FROM Lecture l INNER JOIN Faculty f " +
                        "ON l.faculty.id=f.id " +
                        "WHERE f.name  = :name")
})
@Entity
@Table(name="lectures")
@Cacheable
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id_lecture")
    private int id;
    @Column(name ="name")
    private String name;
    @Column(name ="credits")
    private double credits;
    @ManyToOne
    @JoinColumn(name = "id_faculty")
    private Faculty faculty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return  Double.compare(lecture.credits, credits) == 0 &&
                Objects.equals(name, lecture.name) &&
                Objects.equals(faculty.getName(), lecture.faculty.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, credits, faculty.getName());
    }
}