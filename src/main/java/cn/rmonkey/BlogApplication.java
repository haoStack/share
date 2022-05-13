package cn.rmonkey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Zhaozihao (Zack)
 * @Description
 * @date 2022/5/12 14:45
 */
@SpringBootApplication
@MapperScan("cn.rmonkey.mapper")
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class , args);
    }
}
