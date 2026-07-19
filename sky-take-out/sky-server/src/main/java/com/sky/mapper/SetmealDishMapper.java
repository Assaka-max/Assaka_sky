package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品id获取套餐总数
     * @param ids
     * @return
     */
    Long getSetmealSumByDishIds(@Param("ids") List<Long> ids);
}
