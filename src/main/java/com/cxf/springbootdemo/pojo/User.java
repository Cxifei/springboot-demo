package com.cxf.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @ClassName User
 * @Description 用户
 * @Author Acer
 * @CreateTime 2020/2/29 13:24
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //声明类为实体或表
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键自增
    private Long id;
    @Column(length = 20) //字符长度
    private String name;
    @Column(length = 2)
    private String sex;

    public User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

}
