package com.sky.service;


import com.sky.dto.DishDTO;

public interface DishService{

    /**
     * 文件上传
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);
}
