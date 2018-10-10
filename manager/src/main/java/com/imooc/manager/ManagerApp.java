package com.imooc.manager;

import com.imooc.swagger.EnableMySwagger;
import com.imooc.swagger.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理端启动类
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.imooc.entity"})
public class ManagerApp {
    public static void main(String[] args) {
        //SpringApplication.run(ManagerApp.class);

        List<String> strs = new ArrayList<String>();
        strs.add("dlq");
        strs.add("zzz");
        strs.add("hello world");

        Object b =  strs.toArray();
        System.out.println(b);
    }
}
