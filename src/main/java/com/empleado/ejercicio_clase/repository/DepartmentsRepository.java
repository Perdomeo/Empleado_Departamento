package com.empleado.ejercicio_clase.repository;

import com.empleado.ejercicio_clase.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Long>{
}
