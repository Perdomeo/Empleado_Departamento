package com.empleado.ejercicio_clase.service;

import com.empleado.ejercicio_clase.dto.EmployeDTO;
import com.empleado.ejercicio_clase.entity.Departments;
import com.empleado.ejercicio_clase.entity.Employe;
import com.empleado.ejercicio_clase.repository.DepartmentsRepository;
import com.empleado.ejercicio_clase.repository.EmployeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private DepartmentsRepository departmentsRepository;

    public Optional<Employe> findById(long id){
        return employeRepository.findById(id);
    }

    public List<Employe> findAll(){
        return employeRepository.findAll();
    }

    public Employe save(EmployeDTO employeDTO) {
        Employe employeInfo = new Employe();

        // Asignar los datos del empleado
        employeInfo.setName(employeDTO.getName());
        employeInfo.setLastName(employeDTO.getLastName());
        employeInfo.setAge(employeDTO.getAge());

        // Buscar el departamento por ID desde el DepartmentsDTO
        Departments departments = departmentsRepository.findById(employeDTO.getDepartmentsDTO().getId())
                .orElseThrow();
        // Asignar el departamento al empleado
        employeInfo.setDepartments(departments);

        // Guardar el nuevo empleado en la base de datos
        return employeRepository.save(employeInfo);
    }

    public Employe update(long id, EmployeDTO employeDTO) {
        Optional<Employe> employeOptional = employeRepository.findById(id);
        if (employeOptional.isPresent()) {
            Employe employe = employeOptional.get();
            employe.setName(employeDTO.getName());
            employe.setLastName(employeDTO.getLastName());
            employe.setAge(employeDTO.getAge());
            Departments departments = departmentsRepository.findById(employeDTO.getDepartmentsDTO().getId()).orElse(null);
            employe.setDepartments(departments);
            return employeRepository.save(employe);
        } else {
            throw new EntityNotFoundException("Empleado no encontrado con el ID: " + id);
        }
    }

    public void deleteById(long id){
        employeRepository.deleteById(id);
    }

}


