package com.example.sse3.controllers;

import com.example.sse3.model.Product;
import com.example.sse3.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  public void addProduct(@RequestBody Product p) {
    productService.addProduct(p);
  }

  @GetMapping
  public List<Product> getProducts() {
    return productService.getProducts();
  }
}
