package com.nicolas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.course.entities.OrderItem;
import com.nicolas.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
