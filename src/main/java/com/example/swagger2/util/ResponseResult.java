package com.example.swagger2.util;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果的类
 *
 * @author LIFULIN
 * @className R
 * @description TODO
 * @date 2020/9/7-10:53
 */
@Data
@ApiModel(value = "统一返回结果的类")
public class ResponseResult {

    /**
     * 返回结果是否成功
     */
    @ApiModelProperty(value = "结果是否成功")
    private Boolean isSuccess;

    /**
     * 返回结果的返回码
     */
    @ApiModelProperty(value = "返回的响应码")
    private Integer code;

    /**
     * 返回结果的提示消息
     */
    @ApiModelProperty(value = "返回的提示消息")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回的数据")
    private Map<String, Object> data = new HashMap<>();

    /**
     * 把构造方法私有
     */
    private ResponseResult() {
    }

    /**
     * 成功静态方法
     */
    public static ResponseResult ok() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setIsSuccess(true);
        responseResult.setCode(Constant.SUCCESS.getCode());
        responseResult.setMessage(Constant.SUCCESS.getMessage());
        return responseResult;
    }

    /**
     * 失败静态方法
     */
    public static ResponseResult error() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setIsSuccess(false);
        responseResult.setCode(Constant.ERROR.getCode());
        responseResult.setMessage(Constant.ERROR.getMessage());
        return responseResult;
    }

    public ResponseResult isSuccess(Boolean success) {
        this.setIsSuccess(success);
        return this;
    }

    public ResponseResult message(String message) {
        this.setMessage(message);
        return this;
    }

    public ResponseResult code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ResponseResult data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public ResponseResult data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

}
