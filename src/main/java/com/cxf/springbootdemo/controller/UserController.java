package com.cxf.springbootdemo.controller;

import com.cxf.springbootdemo.dto.UserDTO;
import com.cxf.springbootdemo.pojo.User;
import com.cxf.springbootdemo.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Acer
 * @CreateTime 2020/3/1 1:35
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * @title add
     * @description 跳转到添加页面
     * @author chen2ko
     * @updateTime 2020/3/1 1:39
     * @param
     * @return java.lang.String
     * @throws
     */
    @GetMapping("/add")
    public String add(){
        return "user/add";
    }

    /**
     * @title save
     * @description 保存成功后重定向到列表请求
     * @author chen2ko
     * @updateTime 2020/3/1 1:41
     * @param
     * @return java.lang.String
     * @throws
     */
    @PostMapping("/save")
    public String save(UserDTO dto){
        userService.save(dto);
        return "redirect:/user/listPage";
    }

    /**
     * @title list
     * @description 跳转到列表页面
     * @author chen2ko
     * @updateTime 2020/3/1 1:42
     * @param model
     * @return java.lang.String
     * @throws
     */
    @GetMapping("/list")
    public String list(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("list",list);
        return "user/list";
    }

    /**
     * @title listPage
     * @description 分页查询数据
     * @author chen2ko
     * @updateTime 2020/3/2 15:25
     * @param model
     * @return java.lang.String
     * @throws
     */
    @GetMapping("/listPage")
    public String listPage(@RequestParam(value = "page",defaultValue = "0",required = false) int page,
                           @RequestParam(value = "size",defaultValue = "6",required = false) int size,
                           Model model){
        Page<User> users = userService.findAllByPage(page,size);
        model.addAttribute("users",users);
        return "user/list";
    }

    /**
     * @title edit
     * @description 跳转到修改页面
     * @author chen2ko
     * @updateTime 2020/3/1 16:24
     * @param id
     * @param model
     * @return java.lang.String
     * @throws
     */
    @GetMapping("/edit")
    public String edit(@NotNull Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "user/edit";
    }

    /**
     * @title update
     * @description 修改成功后跳转到列表请求
     * @author chen2ko
     * @updateTime 2020/3/1 16:42
     * @param userDTO
     * @return java.lang.String
     * @throws
     */
    @PostMapping("/update")
    public String update(@Valid UserDTO userDTO){
        userService.update(userDTO);
        return "redirect:/user/listPage";
    }

    /**
     * @title delete
     * @description 删除成功后跳转到列表请求
     * @author chen2ko
     * @updateTime 2020/3/1 17:43
     * @param id
     * @return java.lang.String
     * @throws
     */
    @GetMapping("/del/{id}")
    public String delete(@PathVariable Long id){
        userService.deleteById(id);
        return "redirect:/user/listPage";
    }
}
