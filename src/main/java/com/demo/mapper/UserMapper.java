package com.demo.mapper;

import com.demo.domain.User;
import com.demo.utils.CommonDateTime;
import com.demo.utils.CommonPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    /*
    * 查询所有 + 条件分页
    * */
    public List<User> findAll(
            @Param("commonPage") CommonPage commonPage,
            @Param("user") User user,
            @Param("commonDateTime") CommonDateTime commonDateTime
    );

    /*
    *查询总数
    * */
    public Integer countAll(
            @Param("user") User user,
            @Param("commonDateTime") CommonDateTime commonDateTime
    );

    /*
    * 新增
    * */
    public void insertOne(User user);

    /*
    * 编辑
    * */
    public void updateOne(User user);

    /*
    * 删除
    * */
    public void deleteOne(User user);
}
