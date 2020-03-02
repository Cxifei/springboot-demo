package com.cxf.springbootdemo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName UserDTO
 * @Description 用户页面传递数据
 * @Author Acer
 * @CreateTime 2020/3/1 1:46
 * @Version 1.0
 **/
@Data
public class UserDTO {

    private Long id;

    @NotBlank(message = "名称不能为空")
    private String name;
    @NotBlank(message = "性别不能为空")
    private String sex;
}
