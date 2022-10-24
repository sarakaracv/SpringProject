package com.cydeo.spring12data.repository;

import com.cydeo.spring12data.entitiy.Payment;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
