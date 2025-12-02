package com.api.inventory.inventoryapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.api.inventory.inventoryapi.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}