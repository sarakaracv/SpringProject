package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;

    private AddressType addressType;

    private StudentDTO student;

    private ParentDTO parent;

    private TeacherDTO teacher;

    private Integer currentTemperature;

}