package com.empleado.ejercicio_clase.service;

import com.empleado.ejercicio_clase.entity.Departments;
import com.empleado.ejercicio_clase.repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentsService {
    @Autowired//Singleton backwards for just one DepartmentsRepository instance
    private DepartmentsRepository departmentsRepository;

    //This method brings out every user stored in database's table departments
    public List<Departments> findAll(){
        return departmentsRepository.findAll();
    }

    //This method finds a specific departments searching by id
    public Optional<Departments> findById(long id){
        return departmentsRepository.findById(id);
    }

    //This method saves a new departments in database's table departments
    public Departments save(Departments departments){
        return departmentsRepository.save(departments);
    }

    //This method deletes a specific departments by using its id
    public void deleteById(long id){
        departmentsRepository.deleteById(id);
    }
}
