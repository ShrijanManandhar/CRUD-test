package com.codehimalayan.firstproject.service;

import com.codehimalayan.firstproject.dto.CollegeResponseDTO;
import com.codehimalayan.firstproject.dto.CollegeRequestDTO;

import java.util.List;

public interface CollegeService {
    CollegeResponseDTO addCollege(CollegeRequestDTO collegeRequestDTO);
    List<CollegeResponseDTO> getAllCollege();
    CollegeResponseDTO getOne(Integer id);
    CollegeResponseDTO updateCollege(CollegeRequestDTO collegeRequestDTO, Integer id);
    String deleteCollege(Integer id);

//    void catchEx(CollegeRequestDTO collegeRequestDTO);


}
