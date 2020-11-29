package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;

import javax.xml.crypto.Data;

public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Data create_time;
    private Data update_time;
    @Version //乐观锁
    private Integer version;
    @TableLogic //逻辑删除
    private Integer deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setCreate_time(Data create_time) {
        this.create_time = create_time;
    }

    public Data getCreate_time() {
        return create_time;
    }

    public void setUpdate_time(Data update_time) {
        this.update_time = update_time;
    }

    public Data getUpdate_time() {
        return update_time;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getDeleted() {
        return deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", version=" + version +
                ", deleted=" + deleted +
                '}';
    }
}
