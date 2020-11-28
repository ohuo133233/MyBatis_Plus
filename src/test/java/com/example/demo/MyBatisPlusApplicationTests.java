package com.example.demo;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = new User();
        user.setName("1111");
        user.setEmail("1111");
        user.setAge(1);
        int insert = userMapper.insert(user);
        System.out.println("insert: "+insert);
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
