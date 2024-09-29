package com.empleado.ejercicio_clase.dto;

import jakarta.validation.constraints.*;

public class EmployeDTO {

    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 60, message = "El nombre debe tener entre 3 y 60 caracteres")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "El nombre debe comenzar con una letra mayúscula y contener solo letras")
    private String name;

    @NotEmpty(message = "El apellido no puede estar vacío")
    @Size(min = 3, max = 60, message = "El apellido debe tener entre 3 y 60 caracteres")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "El apellido debe comenzar con una letra mayúscula y contener solo letras")
    private String lastName;

    @NotNull(message = "La edad no puede ser nula")
    @Min(value = 18, message = "La edad debe ser mayor o igual a 18")
    @Max(value = 100, message = "La edad debe ser menor o igual a 100")
    private Integer age;

    @NotNull(message = "El departamento no puede ser nulo")
    private DepartmentsDTO departmentsDTO;  // Aquí usarías el DepartmentsDTO

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public DepartmentsDTO getDepartmentsDTO() {
        return departmentsDTO;
    }

    public void setDepartmentsDTO(DepartmentsDTO departmentsDTO) {
        this.departmentsDTO = departmentsDTO;
    }
}


