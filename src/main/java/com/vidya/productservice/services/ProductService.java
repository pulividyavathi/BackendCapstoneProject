package com.vidya.productservice.services;

import com.vidya.productservice.dtos.GenericProductDto;
import com.vidya.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
     GenericProductDto getProductById(Long id);

     GenericProductDto createProduct(GenericProductDto product);

     List<GenericProductDto> getAllProducts();

     void deleteProduct(Long id);
}
