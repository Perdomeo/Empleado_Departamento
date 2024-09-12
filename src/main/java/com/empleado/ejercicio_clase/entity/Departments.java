package com.empleado.ejercicio_clase.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "departments", length = 8)
    private String departments;

    @OneToMany(mappedBy = "departments")
    private List<Employe> employe;

    public Departments(){
        super();
    }

    public Departments(String departments, long id) {
        this.departments = departments;
        this.id = id;
    }

    public Departments(String departments) {
        this.departments = departments;
    }

    public List<Employe> getEmploye() {
        return employe;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public long getId() {
        return id;
    }

}
