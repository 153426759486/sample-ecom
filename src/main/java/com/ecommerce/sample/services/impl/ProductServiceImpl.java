package com.ecommerce.sample.services.impl;

import com.ecommerce.sample.entity.Product;
import com.ecommerce.sample.repository.ProductRepo;
import com.ecommerce.sample.services.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo;
    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    @Override
    public String createProduct(Product product) {
        productRepo.save(product);
        return "Product Created!";
    }
}
