package com.empleado.ejercicio_clase.controller;

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

    @GetMapping
    public List<Employe> getAllEmploye() {
        return employeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable long id){
        Optional<Employe> employe = employeService.findById(id);
        return employe.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employe createDepartment(@RequestBody Employe employe){
        return employeService.save(employe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable long id, @RequestBody Employe employeDetails){
        Optional<Employe> employe = employeService.findById(id);
        if(employe.isPresent()){
            Employe updatedEmploye = employe.get();
            updatedEmploye.setDepartments(employeDetails.getDepartments());
            updatedEmploye.setAge(employeDetails.getAge());
            updatedEmploye.setName(employeDetails.getName());
            updatedEmploye.setLastName(employeDetails.getLastName());
            return ResponseEntity.ok(employeService.save(updatedEmploye));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable long id){
        if(employeService.findById(id).isPresent()){
            employeService.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
