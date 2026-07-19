package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 批量删除口味
     * @param ids
     */
    void deleteBatchByDishIds(@Param("ids") List<Long> ids);

    /**
     * 根据id查询口味
     * @param id
     * @return
     */
    List<DishFlavor> getByDishId(Long id);
}
