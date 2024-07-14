package com.vivek.learn.graph_ql.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UpdateSalaryInput {

    @Id
    private Integer employeeId;
    private String salary;
}
