package com.vivek.learn.graph_ql.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String salary;
    @ManyToOne
    @JoinColumn(name = "department_ID")
    private Department department;
}

