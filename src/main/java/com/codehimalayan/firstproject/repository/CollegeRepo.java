package com.codehimalayan.firstproject.repository;

import com.codehimalayan.firstproject.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepo extends JpaRepository <College,Integer> {

}
