package com.sky.controller.admin;

import com.sky.annotation.Loggable;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/category")
@Slf4j
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * 新增分类
     *
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类")
    @Loggable
    public Result save(@RequestBody CategoryDTO categoryDTO){
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    @Loggable
    public Result page(CategoryPageQueryDTO categoryPageQueryDTO){
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据id删除分类
     * @param categoryDTO
     * @return
     */
    @DeleteMapping
    @ApiOperation("根据id删除分类")
    @Loggable
    public Result delete(CategoryDTO categoryDTO){
        categoryService.deleteById(categoryDTO);
        return Result.success();
    }

    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改分类")
    @Loggable
    public Result update(@RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * 启用或禁用分类
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用或禁用分类")
    @Loggable
    public Result startOrStop(@PathVariable Integer status, Long id){
        categoryService.startOrStop(status, id);
        return Result.success();
    }
}
