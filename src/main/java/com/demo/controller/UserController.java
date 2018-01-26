package com.demo.controller;


import com.demo.domain.User;
import com.demo.service.UserService;
import com.demo.utils.CommonDateTime;
import com.demo.utils.CommonPage;
import com.demo.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    * 查询所有
    * @params commonPage
    * @params user
    * @params commonDateTime
    * */
    @GetMapping(value = "/getList")
    public CommonResult getList(CommonPage commonPage, User user, CommonDateTime commonDateTime) {

        return userService.getList(commonPage, user, commonDateTime);
    }

    /*
    * 新增/编辑一个用户
    * @params user
    * */
    @PostMapping(value = "/setOne")
    public CommonResult setOne(User user) {

        return userService.setOne(user);
    }

    /*
    * 删除一个用户
    * @params user
    * */
    @GetMapping(value = "deleteOne")
    public CommonResult deleteOne(User user) {

        return userService.deleteOne(user);
    }

}
