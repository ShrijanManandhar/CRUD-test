package com.codehimalayan.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CollegeRequestDTO {
    private Integer id;
    private String studentName;
    private String address;
    private String phoneNumber;
    private String faculty;

}
