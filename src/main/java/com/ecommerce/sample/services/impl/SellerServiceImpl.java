package com.ecommerce.sample.services.impl;

import com.ecommerce.sample.entity.Product;
import com.ecommerce.sample.entity.Seller;
import com.ecommerce.sample.repository.SellerRepo;
import com.ecommerce.sample.services.service.ProductService;
import com.ecommerce.sample.services.service.SellerService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service
public class SellerServiceImpl implements SellerService {

    private SellerRepo sellerRepo;
    private ProductService productService;

    public SellerServiceImpl(SellerRepo sellerRepo, ProductService productService){

        this.sellerRepo = sellerRepo;
        this.productService = productService;
    }

    @Override
    public String createSeller(Seller seller) {
        sellerRepo.save(seller);
        return "Seller Added!";
    }

    @Override
    public void deleteSeller(Long sellerId) {
       Seller id = sellerRepo.findById(sellerId).orElseThrow();
       sellerRepo.delete(id);

    }

    @Override
    public List<Seller> getAll() {
        return sellerRepo.findAll();
    }

    @Override
    public String createProductBySeller(Product product) {
        return productService.createProduct(product);

    }
}
