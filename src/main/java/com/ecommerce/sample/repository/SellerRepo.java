package com.ecommerce.sample.repository;

import com.ecommerce.sample.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller, Long> {
}
