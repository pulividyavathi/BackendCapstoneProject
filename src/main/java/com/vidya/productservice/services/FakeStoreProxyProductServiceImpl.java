package com.vidya.productservice.services;

import com.vidya.productservice.dtos.FakeStoreProductDto;
import com.vidya.productservice.dtos.GenericProductDto;
import com.vidya.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("FakeStoreProxyProductService")
public class FakeStoreProxyProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl="https://fakestoreapi.com/products/{id}";

    private String getAllProductsRequestUrl="https://fakestoreapi.com/products/";


    private String createProductRequestUrl="https://fakestoreapi.com/products";

    private String deleteProductRequestUrl="https://fakestoreapi.com/products/{id}";


    public GenericProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response=restTemplateBuilder.build().postForEntity(createProductRequestUrl,
                product, GenericProductDto.class);

        return response.getBody();
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response=
                restTemplate.getForEntity(getAllProductsRequestUrl,FakeStoreProductDto[].class);
//        response.getStatusCode();
        FakeStoreProductDto[] fakeStoreProducts=response.getBody();

        List<GenericProductDto> result=new ArrayList<>();

        for(FakeStoreProductDto fakeProduct:fakeStoreProducts){
            GenericProductDto genericProduct=new GenericProductDto();
            genericProduct.setId(fakeProduct.getId());

            genericProduct.setImage((fakeProduct.getImage()));
            genericProduct.setDescription((fakeProduct.getDescription()));
            genericProduct.setTitle((fakeProduct.getTitle()));

            result.add(genericProduct);

        }

//
//        product.setImage(fakeStoreProductDto.getImage());
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setTitle(fakeStoreProductDto.getTitle());

return result;
//        return product;
//        return Arrays.asList(response.getBody());
    }

    @Override
    public void deleteProduct(Long id) {

//        Rest template to send and receive data in different formats
//        FakeStoreProxyProductServiceImpl fakeStoreProxyProductService=new FakeStoreProxyProductServiceImpl();
        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> response=
//                restTemplate.getForEntity(deleteProductRequestUrl,FakeStoreProductDto.class,id);
//        response.getStatusCode();
        Map<String, String> params = new HashMap<>();

        // adding "id" as parameter
        // similarly you can add Authrization token, if required.
        params.put("id", String.valueOf(id));

        restTemplate.delete(deleteProductRequestUrl,params);
//        FakeStoreProductDto fakeStoreProductDto=response.getBody();
//        GenericProductDto product=new GenericProductDto();
//       product.setId(fakeStoreProductDto.getId());
//        product.setImage(fakeStoreProductDto.getImage());
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setTitle(fakeStoreProductDto.getTitle());


//        return product;

//        return null;
    }

    public FakeStoreProxyProductServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public GenericProductDto getProductById(Long id) {

//        Rest template to send and receive data in different formats
//        FakeStoreProxyProductServiceImpl fakeStoreProxyProductService=new FakeStoreProxyProductServiceImpl();
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=
                 restTemplate.getForEntity(getProductRequestUrl,FakeStoreProductDto.class,id);
//        response.getStatusCode();
        FakeStoreProductDto fakeStoreProductDto=response.getBody();
   GenericProductDto product=new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());

   product.setImage(fakeStoreProductDto.getImage());
   product.setDescription(fakeStoreProductDto.getDescription());
   product.setTitle(fakeStoreProductDto.getTitle());


        return product;

    }


 }
