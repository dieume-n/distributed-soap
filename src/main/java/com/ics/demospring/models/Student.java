package com.ics.demospring.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName, lastName;

    @ManyToOne
    private Training training;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, Training training) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.training = training;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Training getTraining() {
        return training;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + this.id +
                ", first name='" + this.firstName + '\'' +
                ", last name='" + this.lastName + '\'' +
                ", training{" +
                "id=" + this.training.getId() +
                ", name='" + this.training.getName() + '\'' +
                "}" +
                '}';
    }
}
