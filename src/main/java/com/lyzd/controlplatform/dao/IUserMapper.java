package com.lyzd.controlplatform.dao;


import com.lyzd.controlplatform.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**description：
* @author 阿劼
* @data 2019/11/19 8:37
*/
@Mapper
public interface IUserMapper {

    /**
     * 删除
     * @param userId 用户id
     * @return rows
     */
    int deleteByPrimaryKey(String userId);

    /**
     * 添加
     * @param record User实例
     * @return rows
     */
    int insert(User record);

    /**
     * 查询单条
     * @param userId 用户id
     * @return user实例
     */
    User selectByPrimaryKey(String userId);

    /**
     * 修改
     * @param record 用户实例
     * @return rows
     */
    int updateByPrimaryKey(User record);

    /**
     * 查询全部数据
     * @return 用户列表
     */
    List<User> selectAll();

    /**
     * 查询记录数
     * @return rows
     */
    int selectAllCount();
}