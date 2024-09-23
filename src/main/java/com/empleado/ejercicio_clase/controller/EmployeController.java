package com.empleado.ejercicio_clase.controller;

import com.empleado.ejercicio_clase.dto.EmployeDTO;
import com.empleado.ejercicio_clase.entity.Employe;
import com.empleado.ejercicio_clase.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    // Obtener todos los empleados
    @GetMapping
    public List<Employe> getAllEmploye() {
        return employeService.findAll();
    }

    // Obtener un empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable long id) {
        Optional<Employe> employe = employeService.findById(id);
        return employe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo empleado
    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody EmployeDTO employeDTO) {
        Employe newEmploye = employeService.save(employeDTO);
        return ResponseEntity.ok(newEmploye);
    }

    // Actualizar un empleado existente
    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable long id, @RequestBody EmployeDTO employeDTO) {
        Optional<Employe> findEmploye = employeService.findById(id);
        if (findEmploye.isPresent()) {
            // Pasar el ID y el DTO al servicio para actualizar
            Employe updatedEmploye = employeService.update(id, employeDTO);
            return ResponseEntity.ok(updatedEmploye);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un empleado por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable long id) {
        if (employeService.findById(id).isPresent()) {
            employeService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

