package com.sky.mapper;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    /**
     * 根据菜品或套餐id查询购物车
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 根据菜品或套餐id更新购物车
     * @param shoppingCart
     */
    void updateById(ShoppingCart shoppingCart);

    /**
     * 新增购物车
     * @param shoppingCart
     */
    void insert(ShoppingCart shoppingCart);

    /**
     * 删除购物车中一个商品
     * @param id
     */
    void delete(@Param("id") Long id);
}
