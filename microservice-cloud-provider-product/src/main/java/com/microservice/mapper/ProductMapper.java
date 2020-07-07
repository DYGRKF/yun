package com.microservice.mapper;
import com.microservice.domain.Product;
import java.util.List;
//产品接口
public interface ProductMapper {
    Product findById(Long pid);

    List<Product> findAll();

    boolean addProduct(Product product);

}
