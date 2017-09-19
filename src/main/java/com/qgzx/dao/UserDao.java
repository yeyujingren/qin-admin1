package com.qgzx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.qgzx.entity.User;

@Mapper
public interface UserDao {
	/**
	 * 
	 * @author zhangzhengan
	 * @param id
	 * @return
	 * @since JDK 1.7
	 */
	@Select("select * from user where id=#{id}")
	@Results({ 
			@Result(property = "id", column = "id"),
			@Result(property = "password", column = "password"),
			@Result(property = "userName", column = "userName"),
			@Result(property = "qq", column = "qq"),
			@Result(property = "phoneNumber", column = "phoneNumber"),
	})
	User queryById(@Param("id") String id);

}
