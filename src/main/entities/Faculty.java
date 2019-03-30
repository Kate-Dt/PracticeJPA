package src.main.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name="faculty")
@Cacheable(true)
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_faculty")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "faculty")
    private Set<Lecture> lectures;

    public Faculty(){}

    public Faculty(String name, Lecture... lectures){
        this.name = name;
        this.lectures = Stream.of(lectures).collect(Collectors.toSet());
        this.lectures.forEach(x -> x.setFaculty(this));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }
}
