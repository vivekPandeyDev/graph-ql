package com.vivek.learn.graph_ql.repo;

import com.vivek.learn.graph_ql.domain.Department;
import com.vivek.learn.graph_ql.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    Iterable<Department> findByNameIgnoreCase(String name);
}
