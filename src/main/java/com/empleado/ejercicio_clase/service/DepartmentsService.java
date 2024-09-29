package com.empleado.ejercicio_clase.service;

import java.util.List;
import java.util.Optional;

import com.empleado.ejercicio_clase.dto.DepartmentsDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empleado.ejercicio_clase.entity.Departments;
import com.empleado.ejercicio_clase.repository.DepartmentsRepository;

@Service
public class DepartmentsService {

    @Autowired
    private DepartmentsRepository departmentsRepository;

    // Método para obtener todos los departamentos
    public List<Departments> findAll() {
        return departmentsRepository.findAll();
    }

    // Método para buscar un departamento por ID
    public Optional<Departments> findById(long id) {
        return departmentsRepository.findById(id);
    }

    // Método para crear un nuevo departamento
    public Departments save(DepartmentsDTO departmentsDTO) {
        Departments department = new Departments();
        department.setDepartments(departmentsDTO.getDepartments());
        return departmentsRepository.save(department);
    }

    // Método para actualizar un departamento existente
    public Departments update(long id, DepartmentsDTO departmentsDTO) {
        Optional<Departments> departmentsOptional = departmentsRepository.findById(id);

        if (departmentsOptional.isPresent()) {
            Departments department = departmentsOptional.get();
            department.setDepartments(departmentsDTO.getDepartments());
            return departmentsRepository.save(department);
        } else {
            throw new EntityNotFoundException("Departamento no encontrado con el ID: " + id);
        }
    }

    // Método para eliminar un departamento por ID
    public void deleteById(long id) {
        Optional<Departments> departmentsOptional = departmentsRepository.findById(id);
        if (departmentsOptional.isPresent()) {
            departmentsRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Departamento no encontrado con el ID: " + id);
        }
    }
}
