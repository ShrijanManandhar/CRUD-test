package com.codehimalayan.firstproject.controller;

import com.codehimalayan.firstproject.dto.CollegeRequestDTO;
import com.codehimalayan.firstproject.dto.CollegeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.codehimalayan.firstproject.service.CollegeService;

import java.util.List;

@RestController
@RequestMapping("/college")

public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @PostMapping("/add")
    public String addCollege(@RequestBody CollegeRequestDTO collegeRequestDTO)
        {
            collegeService.addCollege(collegeRequestDTO);
            return"successfully saved";
        }

     @GetMapping("/all")
    public List<CollegeResponseDTO> getAllCollege(){
        return collegeService.getAllCollege();
     }

     @GetMapping("/one/{id}")
    public CollegeResponseDTO getOneCollege(@PathVariable(value = "id") final Integer id){
        return collegeService.getOne(id);
     }

     @PutMapping("/update/{id}")
    public CollegeResponseDTO updateOneCollege(@RequestBody CollegeRequestDTO collegeRequestDTO, @PathVariable(value ="id") final Integer id){
        return collegeService.updateCollege(collegeRequestDTO, id);
    }

    @DeleteMapping("/delete")
    public String deleteOneCollege(@RequestParam(value ="id") final Integer id ){
        return collegeService.deleteCollege(id);
    }
}
