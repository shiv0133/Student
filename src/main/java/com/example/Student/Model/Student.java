package com.example.Student.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "new_student_table")
public class Student {
    @Id
    @GeneratedValue
    Long id;
    String Name;
    Integer Age;
    String Sub;
    Integer Marks;

    public Student() {
    }

    public Student(String name, Integer age, String sub, Integer marks) {
        Name = name;
        Age = age;
        Sub = sub;
        Marks = marks;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getSub() {
        return Sub;
    }

    public void setSub(String sub) {
        Sub = sub;
    }

    public Integer getMarks() {
        return Marks;
    }

    public void setMarks(Integer marks) {
        Marks = marks;
    }
}
