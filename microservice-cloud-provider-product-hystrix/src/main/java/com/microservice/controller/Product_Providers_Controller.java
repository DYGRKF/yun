package com.microservice.controller;

import com.microservice.domain.Product;
import com.microservice.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//产品提供者控制层
@RestController
public class Product_Providers_Controller {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    //fallbackMethod 指定get方法出现异常时，将要调用的处理方法
    @HystrixCommand(fallbackMethod = "getFallBack")
    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        Product product = productService.get(id);
        if (product == null) {
            throw new RuntimeException("ID-无效");
        }
        return product;
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.list();
    }

    public Product getFallBack(@PathVariable("id") Long id) {

        return new Product(id, "HystrixCommand", "无法找到数据库");
    }


}