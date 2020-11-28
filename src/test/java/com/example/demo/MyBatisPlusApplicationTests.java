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
    // 查询
    @Test
    void selectList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    // 插入
    @Test
    public void insert() {
        User user = new User();
        user.setName("1111");
        user.setEmail("1111");
        user.setAge(1);
        int insert = userMapper.insert(user);
        System.out.println("insert: " + insert);
        selectList();
    }
    // 更新
    @Test
    public void update() {
        User user = new User();
        user.setName("222");
        user.setEmail("222");
        user.setAge(2);
        user.setId(1L);
        int updateById = userMapper.updateById(user);
        System.out.println("updateById: " + updateById);
        selectList();
    }
    // 删除
    @Test
    public void delete(){
        userMapper.deleteById(3L);
        selectList();
    }
}
