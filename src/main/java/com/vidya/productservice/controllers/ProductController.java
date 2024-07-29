package com.vidya.productservice.controllers;

import com.vidya.productservice.dtos.GenericProductDto;
import com.vidya.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/products")
public class ProductController {
       private ProductService productService;

       public ProductController(@Qualifier("FakeStoreProxyProductService") ProductService productService){
           this.productService=productService;
       }



//    localhost:8080/products/123
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);


    }

    @PostMapping()
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        return productService.createProduct(product);


    }


    @GetMapping
    public List<GenericProductDto> getAllProducts(){
            return productService.getAllProducts();

    }

    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") Long id){
        productService.deleteProduct(id);
//           return productService.deleteProduct(id);



    }

}
