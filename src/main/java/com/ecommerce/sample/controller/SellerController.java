package com.ecommerce.sample.controller;

import com.ecommerce.sample.entity.Product;
import com.ecommerce.sample.entity.Seller;
import com.ecommerce.sample.services.service.ProductService;
import com.ecommerce.sample.services.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/seller")
public class SellerController {

    private SellerService sellerService;
    public SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @PostMapping("/create")
    public  String CreateSeller(@RequestBody Seller seller){
        return sellerService.createSeller(seller);

    }
    @DeleteMapping("/delete/{sellerId}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long sellerId){
        sellerService.deleteSeller(sellerId);
        return  ResponseEntity.noContent().build();
    }
    @GetMapping("/allSeller")
    public  ResponseEntity<List<Seller>> getAllSeller(){
        return ResponseEntity.ok(sellerService.getAll());
    }
    @PostMapping("/createProduct")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        return ResponseEntity.ok(sellerService.createProductBySeller(product));
    }
}
