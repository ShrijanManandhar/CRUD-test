package com.codehimalayan.firstproject.dto;

import com.codehimalayan.firstproject.entity.College;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CollegeResponseDTO {
    private Integer id;
    private String studentName;
    private String address;
    private String phoneNumber;
    private String faculty;

    public CollegeResponseDTO(College college)
    {
        this.id=college.getId();
        this.address=college.getAddress();
        this.faculty=college.getFaculty();
        this.phoneNumber=college.getPhoneNumber();
        this.studentName=college.getStudentName();
    }
}
