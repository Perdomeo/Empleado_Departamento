package com.empleado.ejercicio_clase.controller;

import com.empleado.ejercicio_clase.entity.Departments;
import com.empleado.ejercicio_clase.service.DepartmentsService;
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

    @GetMapping
    public List<Departments> getAllDepartments() {
        return departmentsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departments> getDepartmentsById(@PathVariable long id){
        Optional<Departments> departments = departmentsService.findById(id);
        return departments.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Departments createDepartment(@RequestBody Departments departments){
        return departmentsService.save(departments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departments> updateDepartment(@PathVariable long id, @RequestBody Departments departmentsDetails){
        Optional<Departments> departments = departmentsService.findById(id);
        if(departments.isPresent()){
            Departments updatedDepartments = departments.get();
            updatedDepartments.setDepartments(departmentsDetails.getDepartments());
            return ResponseEntity.ok(departmentsService.save(updatedDepartments));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartments(@PathVariable long id){
        if(departmentsService.findById(id).isPresent()){
            departmentsService.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
