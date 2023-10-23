package com.example.app.SpringBootWebShop.repository;

import com.example.app.SpringBootWebShop.entity.Fruit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FruitRepository extends CrudRepository<Fruit, Long> {
    List<Fruit> findAll();
}
