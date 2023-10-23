package com.example.app.SpringBootWebShop.repository;

import com.example.app.SpringBootWebShop.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
