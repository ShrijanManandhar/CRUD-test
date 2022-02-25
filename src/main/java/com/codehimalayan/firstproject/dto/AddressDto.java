package com.codehimalayan.firstproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Access;

@Setter
@Getter
@Accessors(chain = true)
public class AddressDto {

    private String city;
    private String state;
}
