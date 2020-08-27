package com.springrest.springrestcrud.service;//package com.luv2code.springboot.crud.service;


import com.springrest.springrestcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    void save(Employee theEmployee);
    void deleteById(int theId);
}
