package com.sky.controller.admin;

import com.sky.annotation.Loggable;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api("店铺相关接口")
@Slf4j
public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置营业状态
     * @return status
     */
    @PutMapping("/{status}")
    @ApiOperation("设置营业状态")
    @Loggable
    public Result<String> status(@PathVariable Integer status){
        log.info("设置营业状态为：{}", status == 1 ? "营业中" : "打烊中");
        redisTemplate.opsForValue().set(KEY, status.toString());
        return Result.success();
    }

    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    @Loggable
    public Result<Integer> getStatus(){
        Object value = redisTemplate.opsForValue().get(KEY);
        Integer status = (value == null) ? 0 : Integer.parseInt(value.toString());

        // 使用 Objects.equals 比较，避免 NPE
        log.info("获取到店铺的营业状态为：{}", Objects.equals(status, 1) ? "营业中" : "打烊中");

        return Result.success(status);
    }
}
