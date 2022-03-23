package com.example.sse3.services;

import com.example.sse3.model.Product;
import com.example.sse3.repositories.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  /*
  @PreAuthorize
  @PostAuthorize
  @PreFilter
  @PostFilter
   */

  @PreAuthorize("hasAuthority('write')")
  public void addProduct(Product p) {
    productRepository.addProduct(p);
  }

  @PreAuthorize("hasAuthority('read')")
  public List<Product> getProducts() {
    return productRepository.getProducts();
  }
}
