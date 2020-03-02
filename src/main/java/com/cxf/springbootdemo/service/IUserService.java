package com.cxf.springbootdemo.service;

import com.cxf.springbootdemo.dto.UserDTO;
import com.cxf.springbootdemo.pojo.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {

    /**
     * @title save
     * @description 保存用户
     * @author chen2ko
     * @updateTime 2020/3/1 1:55
     * @param dto
     * @return void
     * @throws
     */
    void save(UserDTO dto);

    /**
     * @title findAll
     * @description 查询所有用户信息
     * @author chen2ko
     * @updateTime 2020/3/1 14:45
     * @param
     * @return java.util.List<com.cxf.springbootdemo.pojo.User>
     * @throws
     */
    List<User> findAll();

    /**
     * @title findById
     * @description 根据ID查询用户
     * @author chen2ko
     * @updateTime 2020/3/1 16:25
     * @param id
     * @return com.cxf.springbootdemo.pojo.User
     * @throws
     */
    User findById(Long id);

    void update(UserDTO userDTO);

    void deleteById(Long id);

    List<User> findByName(String name);

    Page<User> findAllByPage(int page,int size);
}
