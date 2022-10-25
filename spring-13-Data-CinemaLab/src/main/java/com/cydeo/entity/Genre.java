package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Genre extends BaseEntity{

    private String name;
}
