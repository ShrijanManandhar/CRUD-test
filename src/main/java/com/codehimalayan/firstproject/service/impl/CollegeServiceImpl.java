package com.codehimalayan.firstproject.service.impl;


import com.codehimalayan.firstproject.dto.CollegeRequestDTO;
import com.codehimalayan.firstproject.dto.CollegeResponseDTO;
import com.codehimalayan.firstproject.entity.College;
import com.codehimalayan.firstproject.repository.CollegeRepo;
import com.codehimalayan.firstproject.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    CollegeRepo collegeRepo;

    @Override
    public CollegeResponseDTO addCollege(CollegeRequestDTO collegeRequestDTO) {
        College college = new College();
        college.setStudentName(collegeRequestDTO.getStudentName());
        college.setAddress(collegeRequestDTO.getAddress());
        college.setPhoneNumber(collegeRequestDTO.getPhoneNumber());
        college.setFaculty(collegeRequestDTO.getFaculty());

        College college1 = collegeRepo.save(college);

        return new CollegeResponseDTO(college1);
    }

    @Override
    public List<CollegeResponseDTO> getAllCollege() {
        List<College> colleges=collegeRepo.findAll();
        List<CollegeResponseDTO> collegeResponseDTOS= new ArrayList<>();
        for(College college: colleges)
        {
            collegeResponseDTOS.add(new CollegeResponseDTO(college));
        }
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
            college.setAddress(collegeRequestDTO.getAddress());
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