package com.cxf.springbootdemo.service.impl;

import com.cxf.springbootdemo.dao.UserDao;
import com.cxf.springbootdemo.dto.UserDTO;
import com.cxf.springbootdemo.mapper.UserMapper;
import com.cxf.springbootdemo.pojo.User;
import com.cxf.springbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Acer
 * @CreateTime 2020/3/1 1:57
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;
    private final UserDao userDao;


    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserDao userDao) {
        this.userMapper = userMapper;
        this.userDao = userDao;
    }

    /**
     * @title save
     * @description 保存用户
     * @author chen2ko
     * @updateTime 2020/3/1 2:01
     * @param dto
     * @return void
     * @throws
     */
    @Override
    public void save(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setSex(dto.getSex());
        userMapper.insertUser(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }



    @Override
    public User findById(Long id) {
        return userMapper.selectById(id);
    }

    /**
     * @title update
     * @description 根据ID修改用户信息
     * @author chen2ko
     * @updateTime 2020/3/1 17:22
     * @param userDTO
     * @return void
     * @throws
     */
    @Override
    public void update(UserDTO userDTO) {
        User user = userMapper.selectById(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSex(userDTO.getSex());
        userMapper.update(user);
    }

    /**
     * @title delete
     * @description 根据ID删除用户
     * @author chen2ko
     * @updateTime 2020/3/1 17:45
     * @param id
     * @return void
     * @throws
     */
    @Override
    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public Page<User> findAllByPage(int page, int size) {
        //从page条数据开始，每页显示size条，根据ID进行倒序
        Pageable pageable = PageRequest.of(page,size, Sort.by(Sort.Order.asc("id")));

        //搜索条件
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //创建列表
                List<Predicate> list = new ArrayList<>();
                if (list.size() > 0){
                    Predicate[] predicates = new Predicate[list.size()];
                    return criteriaBuilder.and(predicates);
                }
                return null;
            }
        };

        //执行查询
        Page<User> users = userDao.findAll(specification, pageable);
        return users;

    }
}
