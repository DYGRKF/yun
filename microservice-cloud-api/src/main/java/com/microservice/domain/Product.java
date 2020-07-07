package com.microservice.domain;
import java.io.Serializable;
//商品实体
public class Product implements Serializable {
    //主键
    private Long pid;
    // 产品名称
    private String productName;
    // 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private String dbSource;

    //无参构造器
    public Product() {
    }

    //商品名称构造器
    public Product(String productName) {
        this.productName = productName;
    }

    //有参构造器
    public Product(Long pid, String productName, String dbSource) {
        this.pid = pid;
        this.productName = productName;
        this.dbSource = dbSource;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}