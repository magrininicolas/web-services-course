package com.nicolas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.course.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
