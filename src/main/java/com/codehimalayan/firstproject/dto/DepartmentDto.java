package com.codehimalayan.firstproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class DepartmentDto {

    private String departmentName;
    private String lecturerName;
    private  String subject;
}
