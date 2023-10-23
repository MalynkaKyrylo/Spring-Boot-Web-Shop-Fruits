package com.example.app.SpringBootWebShop.repository;

import com.example.app.SpringBootWebShop.entity.Fruit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FruitRepository extends CrudRepository<Fruit, Long> {

}
