package com.microservice.service;

import com.microservice.domain.Product;

import java.util.List;

//商品业务层接口
public interface ProductService {
    boolean add(Product product);

    Product get(Long id);

    List<Product> list();
}
