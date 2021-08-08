/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.learn.mapper;

import com.learn.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * #:自动添加''
     * $:需要自己添加''
     */
    @Select(" SELECT  * FROM user_info where userName='${userName}' and password='${password}'")
    List<UserEntity> login1(UserEntity userEntity);

    @Select(" SELECT  * FROM user_info where userName=#{userName} and password=#{password}")
    List<UserEntity> login2(UserEntity userEntity);

    UserEntity login(UserEntity userEntity);
}
