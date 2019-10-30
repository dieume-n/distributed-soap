package com.ics.demospring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Training implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private  int duration;

    @OneToMany(mappedBy = "training")
    @JsonIgnore
    @XmlTransient
    private Collection<Student> students;

    public Training() {
    }

    public Training(Long id, String name, int duration, Collection<Student> students) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
}
