package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    /**
     * 根据Openid查询用户
     * @param openid
     * @return
     */
    User getByOpenid(@Param("openid") String openid);

    /**
     * 新增用户
     * @param user
     */
    void insert(User user);
}
