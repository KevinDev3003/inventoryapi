package com.api.inventory.inventoryapi.service;


import com.api.inventory.inventoryapi.model.Product;
import com.api.inventory.inventoryapi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }
}