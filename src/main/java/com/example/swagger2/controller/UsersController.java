package com.example.swagger2.controller;

import com.example.swagger2.model.Page;
import com.example.swagger2.model.User;
import com.example.swagger2.util.ResponseResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 项目用户表
 *
 * @author LIFULIN
 * @className UsersController
 * @description TODO
 * @date 2020/9/8-17:54
 */
@RestController
@RequestMapping(value = "/users")
@Api(tags = {"项目用户操作接口"})
@ApiResponses({@ApiResponse(code = 200, message = "操作成功"), @ApiResponse(code = 201, message = "操作失败")})
public class UsersController {

    /**
     * 列表
     */
    @ApiOperation(value = "获取列表信息", notes = "把数据库所有数据读取出来，后端分页," +
            "返回的参数中，totalCount=总记录数，pageSize=每页记录数,totalPage=总页数，currPage=当前页数，list=列表数据")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    public ResponseResult list(@RequestBody Page page) {

        //模拟失败
        if (page.getSize() == 0 || page.getCurrPage() == 0) {
            return ResponseResult.error().data("list",page);
        }
        return ResponseResult.ok().data("list",page);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "根据ID查询数据", notes = "前端点击单选按钮获取当前数据的ID传送给后端，后端返回相应的数据填写到修改表中")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "当前信息id", required = true)})
    @RequestMapping(value = "/info", method = {RequestMethod.POST})
    public ResponseResult info(@RequestBody String id) {
        if (id == null) {
            return ResponseResult.error();
        }
        return ResponseResult.ok().data("user",  new User());
    }

    /**
     * 保存
     */
    @ApiOperation(value = "新增数据", notes = "前端点击新增按钮，填写数据保存到数据库,模拟操作失败是姓名不输入")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public ResponseResult save(@RequestBody User user) {
        if (!(user.getUsersName() == null)) {
            return ResponseResult.ok();
        }
        return ResponseResult.error();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改数据", notes = "前端点击修改按钮，填写数据保存到数据库,模拟操作失败是姓名不输入")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public ResponseResult update(@RequestBody User user) {
        if (!(user.getUsersName() == null)) {
            return ResponseResult.ok();
        }
        return ResponseResult.error();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据", notes = "前端点击删除按钮，删除数据库数据")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public ResponseResult delete(@RequestBody List<String> ids) {

        //模拟失败
        if (ids == null) {
            return ResponseResult.error();
        }else {
            return ResponseResult.ok();
        }

    }

}
