package com.sky.controller.user;

import com.sky.annotation.Loggable;
import com.sky.constant.StatusConstant;
import com.sky.entity.Dish;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController("userDishController")
@RequestMapping("/user/dish")
public class DishController {

    @Autowired
    private DishService dishService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    @Loggable
    public Result<List<DishVO>> list(@RequestParam Long categoryId){
        String key = "dish_" + categoryId;
        List<DishVO> list = (List<DishVO>) redisTemplate.opsForValue().get(key);
        if(list != null && !list.isEmpty()){
            return Result.success(list);
        }
        Dish dish = new Dish();
        dish.setCategoryId(categoryId);
        dish.setStatus(StatusConstant.ENABLE);
        list = dishService.listWithFlavor(dish);
        redisTemplate.opsForValue().set(key, list);
        return Result.success(list);
    }
}
