package com.demo.service;

import com.demo.domain.User;
import com.demo.enums.CommonEnums;
import com.demo.exception.CommonException;
import com.demo.mapper.UserMapper;
import com.demo.utils.CommonDateTime;
import com.demo.utils.CommonPage;
import com.demo.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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

        Map<String, Object> map = new HashMap<String, Object>();

        commonPage.setTotal(userMapper.countAll(user, commonDateTime));

        List<User> allUser = userMapper.findAll(commonPage, user, commonDateTime);

        map.put("list", allUser);
        map.put("page", commonPage);

        if (allUser.size() == 0) {
            return CommonResult.isNull(map);
        } else {
            return CommonResult.success(map);
        }
    }

    /*
    * 新增/编辑一个用户
    * @params user
    * */
    @Transactional
    public CommonResult setOne(User user) {

        if (user.getId() != null) {
            user.setUpdateTime(new Date());
            userMapper.updateOne(user);

            return CommonResult.success("");
        } else {
            if (user.getUserName() == null || user.getUserSex() == null || user.getUserAge() == null) {
                return CommonResult.error(CommonEnums.PARAMS.getCode(), CommonEnums.PARAMS.getMsg());
            } else {
                user.setCreateTime(new Date());
                userMapper.insertOne(user);

                return CommonResult.success("");
            }
        }
    }

    /*
    * 删除
    * @params user
    * */
    public CommonResult deleteOne(User user) {
        if (user.getId() == null) {
            return CommonResult.error(CommonEnums.PARAMS.getCode(), CommonEnums.PARAMS.getMsg());
        } else {
            userMapper.deleteOne(user);

            return CommonResult.success("");
        }
    }
}
