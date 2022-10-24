package com.cydeo.spring12data.repository;

import com.cydeo.spring12data.entitiy.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
