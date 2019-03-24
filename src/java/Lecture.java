package java;

import javax.persistence.*;

@Entity
@Table(name="Lectures")
public class Lecture {

    @Id
    @GeneratedValue
    @Column(name ="ID")
    private int id;
    private String name;
    private double credits;

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
}
