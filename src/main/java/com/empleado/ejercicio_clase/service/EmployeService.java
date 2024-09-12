package com.empleado.ejercicio_clase.service;

import com.empleado.ejercicio_clase.entity.Employe;
import com.empleado.ejercicio_clase.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    @Autowired//Singleton backwards for just one UserRepository instance
    private EmployeRepository employeRepository;

    //This method brings out every user stored in database's table user
    public List<Employe> findAll(){
        return employeRepository.findAll();
    }

    //This method finds a specific user searching by id
    public Optional<Employe> findById(long id){
        return employeRepository.findById(id);
    }

    //This method saves a new user in database's table user
    public Employe save(Employe employe){
        return employeRepository.save(employe);
    }

    //This method deletes a specific user by using its id
    public void deleteById(long id){
        employeRepository.deleteById(id);
    }
}
