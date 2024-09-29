package com.empleado.ejercicio_clase.dto;

import jakarta.validation.constraints.*;

public class DepartmentsDTO {

    // El ID solo debería ser obligatorio en actualizaciones, por lo tanto se podría omitir la validación @NotNull aquí para creación
    private Long id;  // ID del departamento

    @NotEmpty(message = "El nombre del departamento no puede estar vacío")  // Valida que no sea vacío
    @Size(min = 3, max = 8, message = "El nombre del departamento debe tener entre 3 y 8 caracteres")  // Longitud entre 3 y 8 caracteres
    private String departments;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }
}
