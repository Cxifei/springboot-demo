package com.cxf.springbootdemo.mapper;

import com.cxf.springbootdemo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title
 * @description
 * @author chen2ko
 * @updateTime 2020/2/29 13:42
 */
//@Mapper
public interface UserMapper {

//    如果觉得下面这种注解形式不方便，可以用xml形式配置
//    @Insert("insert into user values(null,#{name},#{sex})")
    void insertUser(User user);

    List<User> selectAll();

    User selectById(Long id);

    void update(User user);

    void deleteById(Long id);
}
