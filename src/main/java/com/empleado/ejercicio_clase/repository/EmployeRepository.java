package com.empleado.ejercicio_clase.repository;

import com.empleado.ejercicio_clase.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{
}
