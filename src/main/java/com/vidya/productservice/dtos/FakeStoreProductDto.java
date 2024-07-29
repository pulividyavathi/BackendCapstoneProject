package com.vidya.productservice.dtos;

import com.vidya.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private Long id;

    private String title;

    private String description;

    private double price;

    private String category;

    private String image;
}
