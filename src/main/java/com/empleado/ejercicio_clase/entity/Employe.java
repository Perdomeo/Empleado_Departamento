package com.empleado.ejercicio_clase.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "lastName", length = 60)
    private String lastName;

    @Column(name = "age", length = 4)
    private int age;

    @ManyToOne
    @JoinColumn(name = "departments_id")
    private Departments departments;

    public Employe(){
        super();
    }

    public Employe(long id, String name, String lastName, int age, Departments departments) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.departments = departments;
    }

    public Employe(String name, String lastName, int age, Departments departments) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.departments = departments;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }
}
