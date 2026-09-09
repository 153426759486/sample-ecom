package com.ecommerce.sample.services.service;

import com.ecommerce.sample.entity.Product;
import com.ecommerce.sample.entity.Seller;

import java.util.List;

public interface SellerService {
    public String createSeller(Seller seller);
    void deleteSeller(Long sellerId);
    List<Seller> getAll();
    public String createProductBySeller(Product product);

}
