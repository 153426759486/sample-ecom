package com.ecommerce.sample.repository;

import com.ecommerce.sample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepo extends JpaRepository<Product, Long> {

}
