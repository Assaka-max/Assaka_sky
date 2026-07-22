package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.vo.DishItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐
     * @param setmeal
     * @return
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据套餐id查询包含的菜品
     * @param id
     * @return
     */
    List<DishItemVO> getDishItemById(@Param("id") Long id);

    /**
     * 分页查询套餐
     * @param setmealPageQueryDTO
     * @return
     */
    Page pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    Setmeal getById(@Param("id") Long id);
}
