package com.example.sse3.repositories;

import com.example.sse3.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

  private final List<Product> product = new ArrayList<>();

  public void addProduct(Product p) {
    product.add(p);
  }

  public List<Product> getProducts() {
    return product;
  }
}
