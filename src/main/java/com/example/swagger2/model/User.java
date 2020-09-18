package com.example.swagger2.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 项目用户表
 * @author LIFULIN
 * @className UsersEntity
 * @description TODO
 * @date 2020/9/8-17:54
 */
@Data
@ApiModel(value = "项目用户实体类")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;


	@ApiModelProperty(value = "用户表ID，默认提交时不需要填写，由系统生成")
	private String id;

	@ApiModelProperty(value = "用户名")
	private String usersAccount;

	@ApiModelProperty(value = "密码")
	private String usersPwd;

	@ApiModelProperty(value = "姓名")
	private String usersName;

	@ApiModelProperty(value = "性别")
	private String sex;

	@ApiModelProperty(value = "年龄")
	private Integer age;

	@ApiModelProperty(value = "部门")
	private String section;

	@ApiModelProperty(value = "职务")
	private String duty;

	@ApiModelProperty(value = "电话")
	private String usersPhone;

	@ApiModelProperty(value = "邮件")
	private String mail;

	@ApiModelProperty(value = "盐值")
	private String salt;

	@ApiModelProperty(value = "锁定（0锁定；1未锁定）")
	private Integer usersLock;

}
