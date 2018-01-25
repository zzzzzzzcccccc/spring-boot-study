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

    List<User> findAll(
            @Param("commonPage") CommonPage commonPage,
            @Param("user") User user,
            @Param("commonDateTime") CommonDateTime commonDateTime
    );
}
