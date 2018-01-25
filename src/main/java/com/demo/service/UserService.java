package com.demo.service;

import com.demo.domain.User;
import com.demo.mapper.UserMapper;
import com.demo.utils.CommonDateTime;
import com.demo.utils.CommonPage;
import com.demo.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /*
    * 查询所有
    * @params commonPage
    * @params user
    * @params commonDateTime
    * */
    public CommonResult getList(CommonPage commonPage, User user, CommonDateTime commonDateTime) {

        commonPage.isNull(commonPage);

        List<User> allUser = userMapper.findAll(commonPage, user, commonDateTime);

        if (allUser.size() == 0) {
            return CommonResult.isNull(allUser);
        } else {
            return CommonResult.success(userMapper.findAll(commonPage, user, commonDateTime));
        }
    }
}
