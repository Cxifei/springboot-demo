package com.cxf.springbootdemo.dao;

import com.cxf.springbootdemo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    List<User> findByName(String name);

    List<User> findByNameAndSex(String name,String sex);

    // select * from user where name =:name or sex = :sex
    List<User> findByNameOrSex(String name,String sex);

    // select * from user where name like :name
    List<User> findByNameLike(String name);
}
