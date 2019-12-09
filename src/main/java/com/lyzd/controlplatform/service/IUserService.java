package com.lyzd.controlplatform.service;



import com.lyzd.controlplatform.model.User;

import java.util.List;

/**
 * description：
 *
 * @author 阿劼
 * @data 2019/11/19 8:37
 */
public interface IUserService {


    /**
     * 删除
     * @param userId 用户id
     */
    void removeByPrimaryKey(String userId);

    /**
     * 添加
     * @param record Tuser实例
     * @return rows
     */
    int add(User record);

    /**
     * 查询
     * @param userId 用户id
     * @return Tuser实例
     */
    User queryByPrimaryKey(String userId);

    /**
     * 修改
     * @param record 用户id
     */
    void modifyByPrimaryKey(User record);

    /**
     * 查询所有Tuser信息
     * @return Tuser 列表
     */
    List<User> queryAll();

    /**
     * 使用插件limit查询，返回部分Tuser信息
     * @param num 当前页数
     * @param size 每页信息数
     * @return 用户列表
     */
    List<User> queryPage(int num, int size);

    /**
     * 当前表中的数据条数
     * @return 记录数
     */
    int queryAllCount();
}
