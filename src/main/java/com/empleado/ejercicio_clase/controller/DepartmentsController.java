package com.empleado.ejercicio_clase.controller;

import com.empleado.ejercicio_clase.entity.Departments;
import com.empleado.ejercicio_clase.dto.DepartmentsDTO;
import com.empleado.ejercicio_clase.service.DepartmentsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;

    // Obtener todos los departamentos
    @GetMapping
    public List<Departments> getAllDepartments() {
        return departmentsService.findAll();
    }

    // Obtener un departamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Departments> getDepartmentsById(@PathVariable long id) {
        Optional<Departments> departments = departmentsService.findById(id);
        return departments.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo departamento
    @PostMapping
    public ResponseEntity<Departments> createDepartment(@RequestBody @Valid DepartmentsDTO departmentsDTO) {
        Departments newDepartment = departmentsService.save(departmentsDTO);
        return ResponseEntity.ok(newDepartment);
    }

    // Actualizar un departamento existente
    @PutMapping("/{id}")
    public ResponseEntity<Departments> updateDepartment(@PathVariable long id, @RequestBody  @Valid DepartmentsDTO departmentsDTO) {
        Optional<Departments> existingDepartment = departmentsService.findById(id);
        if (existingDepartment.isPresent()) {
            Departments updatedDepartment = departmentsService.update(id, departmentsDTO);
            return ResponseEntity.ok(updatedDepartment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un departamento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartments(@PathVariable long id) {
        if (departmentsService.findById(id).isPresent()) {
            departmentsService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}