package com.example.swagger2.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author LIFULIN
 * @className Page
 * @description TODO
 * @date 2020/9/9-11:01
 */
@Data
@ApiModel(value = "分页实体类")
public class Page {

    @ApiModelProperty(value = "每页记录数", required = true)
    Integer size;

    @ApiModelProperty(value = "当前页码", required = true)
    Integer currPage;

}
