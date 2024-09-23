package com.empleado.ejercicio_clase.service;

import com.empleado.ejercicio_clase.dto.EmployeDTO;
import com.empleado.ejercicio_clase.entity.Employe;
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

    public Optional<Employe> findById(long id){
        return employeRepository.findById(id);
    }

    public List<Employe> findAll(){
        return employeRepository.findAll();
    }

    public Employe save(EmployeDTO employeDTO){
        Employe employeInfo = new Employe();
        employeInfo.setName(employeDTO.getName());
        employeInfo.setLastName(employeDTO.getLastName());
        employeInfo.setAge(employeDTO.getAge());
        return employeRepository.save(employeInfo);
    }

    public Employe update(long id, EmployeDTO employeDTO) {
        Optional<Employe> employeOptional = employeRepository.findById(id);
        if (employeOptional.isPresent()) {
            Employe employe = employeOptional.get();
            employe.setName(employeDTO.getName());
            employe.setLastName(employeDTO.getLastName());
            employe.setAge(employeDTO.getAge());
            return employeRepository.save(employe);
        } else {
            throw new EntityNotFoundException("Empleado no encontrado con el ID: " + id);
        }
    }

    public void deleteById(long id){
        employeRepository.deleteById(id);
    }
}


