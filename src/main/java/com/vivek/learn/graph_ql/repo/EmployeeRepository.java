package com.vivek.learn.graph_ql.repo;

import com.vivek.learn.graph_ql.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Iterable<Employee> findByNameIgnoreCase(String name);
}
