package com.codehimalayan.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CollegeRequestDTO {
    private Integer id;
    private String studentName;
    private AddressDto addressDto;
    private String phoneNumber;
    private String faculty;
    private List<DepartmentDto> departmentDtoList;
}
