package com.sky.mapper;

import com.sky.dto.GoodsSalesDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    /**
     * 新增订单
     * @param orders
     */
    void insert(Orders orders);

    /**
     * 根据订单号和用户id查询订单
     * @param orderNumber
     * @param userId
     * @return
     */
    @Select("select * from orders where number = #{orderNumber} and user_id= #{userId}")
    Orders getByNumberAndUserId(String orderNumber, Long userId);

    /**
     * 修改订单信息
     * @param orders
     */
    void update(Orders orders);

    /**
     * 根据状态和下单时间查询订单
     * @param status
     * @param orderTime
     * @return
     */
    @Select("select * from orders where status = #{status} and order_time < #{orderTime}")
    List<Orders> getByStatusAndOrdertimeLT(Integer status, LocalDateTime orderTime);

    /**
     * 根据动态条件统计营业额
     * @param map
     */
    Double sumByMap(Map map);

    /**
     * 当日新用户数
     * @param begin
     * @param end
     * @return
     */
    @Select("select count(*) from user where create_time >= #{begin} and create_time <= #{end}")
    Integer getNewUser(LocalDateTime begin, LocalDateTime end);

    /**
     * 当日总用户数
     * @param end
     * @return
     */
    @Select("select count(*) from user where create_time <= #{end}")
    Integer getSumUser(LocalDateTime end);

    /**
     * 订单总数
     * @return
     */
    @Select("select count(*) from orders")
    Integer getTotal();

    /**
     * 有效订单总数
     * @param status
     * @return
     */
    @Select("select count(*) from orders where status = #{status}")
    Integer getValidTotal(@Param("status") Integer status);

    /**
     * 得到当日订单总数
     * @param map
     * @return
     */
    @Select("select count(*) from orders where order_time >= #{map.begin} and order_time <= #{map.end}")
    Integer getOrderCount(@Param("map") Map map);

    /**
     * 得到当日有效订单总数
     * @param map
     * @return
     */
    @Select("select count(*) from orders where order_time >= #{map.begin} and order_time <= #{map.end} and status = #{map.status}")
    Integer getValidCount(@Param("map") Map map);

    /**
     * 商品排名top10
     * @param begin
     * @param end
     * @return
     */
    List<GoodsSalesDTO> getSalesTop10(LocalDateTime begin, LocalDateTime end);

    /**
     * 得到当日营业额
     * @param map
     * @return
     */
    @Select("select sum(amount) from orders where order_time >= #{map.begin} and order_time <= #{map.end} and status = #{map.status}")
    Double getTurnover(@Param("map") Map map);

    /**
     * 根据条件统计套餐数量
     * @param map
     * @return
     */
    Integer countByMap(Map map);
}
