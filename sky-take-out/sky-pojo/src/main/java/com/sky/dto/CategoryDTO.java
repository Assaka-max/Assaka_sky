package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("分类")
public class CategoryDTO implements Serializable {

    //主键
    private Long id;

    @ApiModelProperty("分类类型")
    private Integer type;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("排序")
    private Integer sort;

}
