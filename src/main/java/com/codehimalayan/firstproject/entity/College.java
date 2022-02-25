package com.codehimalayan.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.sound.midi.Sequence;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="college")

public class College {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name="student_name")
    private String studentName;

    @Column(name="phone_number")
    private String phoneNumber;



    private String faculty;

    @OneToOne(mappedBy = "college", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "college")
    private List<Department> department = new ArrayList<>();
}
