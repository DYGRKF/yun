package com.microservice.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//自定义配置类
@Configuration
public class ConfigBean {
    // 向容器中添加 RestTemplate 组件,直接通过此组件可调用 REST 接口
    @Bean
    public RestTemplate getRestTemplate() {
     return new RestTemplate();
    }

}