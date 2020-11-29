package com.example.demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
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


    @Test
    // 分页查询
    public void testSelectPage() {
        Page<User> userPage = new Page<>(2, 3);
        Page<User> selectPage = userMapper.selectPage(userPage, null);
        selectPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(6L);
        System.out.println(user);
    }

    // 插入
    @Test
    public void insert() {
        User user = new User();
        user.setName("666");
        user.setEmail("666");
        user.setAge(6);
        int insert = userMapper.insert(user);
        System.out.println("insert: " + insert);
        selectList();
    }

    // 更新
    @Test
    public void update() {
        User user = new User();
        user.setName("333");
        user.setEmail("444");
        user.setAge(4);
        user.setId(1L);
        int updateById = userMapper.updateById(user);
        System.out.println("updateById: " + updateById);
        selectList();
    }

    // 乐观锁
    @Test
    public void testOptimisticLockerInnerInterceptor() {
        User user = new User();
        user.setName("333");
        user.setEmail("444");
        user.setAge(4);
        user.setId(3L);

        User user1 = new User();
        user1.setName("555");
        user1.setEmail("666");
        user1.setAge(5);
        user1.setId(3L);
        int updateById1 = userMapper.updateById(user1);
        int updateById = userMapper.updateById(user);
        System.out.println("updateById1: " + updateById1);
        System.out.println("updateById: " + updateById);
        selectList();
    }

    @Test
    // 多条件查询
    public void testSelectMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "1111");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }


    // 删除
    @Test
    public void delete() {
        int i = userMapper.deleteById(2L);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        userMapper.deleteBatchIds(list);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "333");
        userMapper.deleteByMap(map);
    }

    // 逻辑删除
    @Test
    public void logicDelete() {
        int i = userMapper.deleteById(6L);
        System.out.println("logicDelete ID: " + i);
    }
}
