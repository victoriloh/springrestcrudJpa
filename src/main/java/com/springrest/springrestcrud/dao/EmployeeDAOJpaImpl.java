package com.springrest.springrestcrud.dao;

import com.springrest.springrestcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query theQuery = entityManager.createQuery("from Employee");
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee = entityManager.find(Employee.class,theId);
        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId",theId);
        query.executeUpdate();
    }
}
