package com.codehimalayan.firstproject.dto;

import com.codehimalayan.firstproject.entity.College;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollegeResponseDTO {
    private Integer id;
    private String studentName;
    private AddressDto addressDto;
    private String phoneNumber;
    private String faculty;
    private List<DepartmentDto> departmentDtoList = new ArrayList<>();
    public CollegeResponseDTO(College college)
    {
        this.id=college.getId();
//        this.address=college.getAddress();
        this.faculty=college.getFaculty();
        this.phoneNumber=college.getPhoneNumber();
        this.studentName=college.getStudentName();
    }
}
