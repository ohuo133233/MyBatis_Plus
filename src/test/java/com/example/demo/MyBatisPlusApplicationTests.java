package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MyBatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    // 查询全部的User
    @Test
    void selectALlList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    // 分页查询
    @Test
    public void testSelectPage() {
        Page<User> userPage = new Page<>(2, 3);
        Page<User> selectPage = userMapper.selectPage(userPage, null);
        selectPage.getRecords().forEach(System.out::println);
    }

    // 按照主键查询
    @Test
    public void selectById() {
        User user = userMapper.selectById(6L);
        System.out.println(user);
    }

    // 多条件查询
    @Test
    public void selectMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "1111");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    // mapper 查询
    @Test
    public void selectMapper() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 判断name不等于null，age等于null,判断id等于5,email不等于666
        // id大于4，大于对于4
        userQueryWrapper.isNotNull("name")
                .isNull("age")
                .eq("id", 5)
                .ne("email", "666")
                .gt("id", 4)
                .ge("id", 4);

        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        maps.forEach(System.out::println);
    }

    // 插入
    @Test
    public void insert() {
        User user = new User();
        user.setName("666");
        user.setEmail("666");
        user.setAge(6);
        userMapper.insert(user);
        selectALlList();
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
        selectALlList();
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
        selectALlList();
    }
}
