package com.codehimalayan.firstproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String departmentName;
    private String lecturerName;
    private String subject;

    @ManyToOne
    @JoinColumn(name="college_id", referencedColumnName = "id", nullable = false)
    private College college;
}
