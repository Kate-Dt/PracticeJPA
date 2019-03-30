package src.main.entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "selectFacultyLectures",
                 query= "SELECT DISTINCT lectures.name " +
                        "FROM lectures INNER JOIN faculty " +
                        "ON lectures.id_faculty=faculty.id_faculty " +
                        "WHERE faculty.name  = :name")
})
@Entity
@Table(name="lectures")
@Cacheable(true)
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
}