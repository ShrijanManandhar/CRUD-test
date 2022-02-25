package com.codehimalayan.firstproject.service.impl;


import com.codehimalayan.firstproject.dto.AddressDto;
import com.codehimalayan.firstproject.dto.CollegeRequestDTO;
import com.codehimalayan.firstproject.dto.CollegeResponseDTO;
import com.codehimalayan.firstproject.dto.DepartmentDto;
import com.codehimalayan.firstproject.entity.Address;
import com.codehimalayan.firstproject.entity.College;
import com.codehimalayan.firstproject.entity.Department;
import com.codehimalayan.firstproject.repository.CollegeRepo;
import com.codehimalayan.firstproject.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    CollegeRepo collegeRepo;

    @Override
    public CollegeResponseDTO addCollege(CollegeRequestDTO collegeRequestDTO) {
        College college = new College();
        college.setStudentName(collegeRequestDTO.getStudentName());
        college.setPhoneNumber(collegeRequestDTO.getPhoneNumber());
        college.setFaculty(collegeRequestDTO.getFaculty());


        Address address= new Address().builder()
        .city(collegeRequestDTO.getAddressDto().getCity())
                .state(collegeRequestDTO.getAddressDto().getState())
                .college(college)
                .build();
        List<Department> departmentList = collegeRequestDTO.getDepartmentDtoList()
                .stream()
                .map(departmentDto -> new Department().builder()
                        .departmentName(departmentDto.getDepartmentName())
                        .lecturerName(departmentDto.getLecturerName())
                        .subject(departmentDto.getSubject())
                        .college(college)
                        .build()).collect(Collectors.toList());

        college.setAddress(address);
        college.getDepartment().clear();
        college.getDepartment().addAll(departmentList);

        College college1 = collegeRepo.save(college);

        return new CollegeResponseDTO(college1);
    }

    @Override
    public List<CollegeResponseDTO> getAllCollege() {
        List<College> colleges=collegeRepo.findAll();
        List<CollegeResponseDTO> collegeResponseDTOS= colleges.stream()
                .map(college -> {
                    CollegeResponseDTO dto = new CollegeResponseDTO(college);
                    dto.setAddressDto(
                            new AddressDto()
                                    .setCity(college.getAddress().getCity())
                                    .setState(college.getAddress().getState())
                    );
                    dto.getDepartmentDtoList().clear();
                    dto.getDepartmentDtoList().addAll(
                            college.getDepartment().stream()
                                    .map(department -> new DepartmentDto()
                                            .setDepartmentName(department.getDepartmentName())
                                            .setLecturerName(department.getLecturerName())
                                            .setSubject(department.getSubject())).collect(Collectors.toList())
                    );
                    return dto;
                }).collect(Collectors.toList());

        return collegeResponseDTOS;
    }

    @Override
    public CollegeResponseDTO getOne(Integer id) {
        College college=collegeRepo.getById(id);
        return new CollegeResponseDTO(college);
    }

    @Override
    public CollegeResponseDTO updateCollege(CollegeRequestDTO collegeRequestDTO, Integer id) {
        Optional<College> optionalCollege= collegeRepo.findById(id);
        if(optionalCollege.isPresent()){
            College college = new College();

            college.setId(id);
            college.setStudentName(collegeRequestDTO.getStudentName());
//            college.setAddress(collegeRequestDTO.getAddress());
            college.setPhoneNumber(collegeRequestDTO.getPhoneNumber());
            college.setFaculty(collegeRequestDTO.getFaculty());

            College college1 = collegeRepo.save(college);

            return new CollegeResponseDTO(college1);
        }

        throw new NullPointerException("The Student Entity doesn't exist");
    }

    @Override
    public String deleteCollege(Integer id) {
        Optional<College> optionalCollege = collegeRepo.findById(id);
        if (optionalCollege.isPresent()) {
            collegeRepo.deleteById(id);
            return "The Student is deleted";
        }

        throw new NullPointerException("The Student Entity doesn't exist");
    }

//    @Override
//    public void catchEx(CollegeRequestDTO collegeRequestDTO) {
//        addCollege(collegeRequestDTO);
//        throw new NullPointerException("Bad luck");


}