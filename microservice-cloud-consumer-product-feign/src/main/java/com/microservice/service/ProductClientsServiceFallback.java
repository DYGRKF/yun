package com.microservice.service;
import com.microservice.domain.Product;
import org.springframework.stereotype.Component;
import java.util.List;

//熔断器
@Component
public class ProductClientsServiceFallback implements ProductClientService {

    @Override
    public boolean add(Product product) {
        return false;
    }

    @Override
    public Product get(Long id) {
        return new Product(id,"id="+id+"无数据","无有效数据");
    }

    @Override
    public List<Product> list() {
        return null;
    }
}