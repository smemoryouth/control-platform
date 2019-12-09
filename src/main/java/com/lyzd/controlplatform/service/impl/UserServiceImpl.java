package com.lyzd.controlplatform.service.impl;

import com.github.pagehelper.PageHelper;
import com.lyzd.controlplatform.model.User;
import com.lyzd.controlplatform.dao.IUserMapper;
import com.lyzd.controlplatform.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**description：
* @author 阿劼
* @data 2019/11/19 8:37
*/
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserMapper userMapper;

    @Override
    public void removeByPrimaryKey(String userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int add(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User queryByPrimaryKey(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void modifyByPrimaryKey(User record) {
        userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.selectAll();
    }

    /**
     * 这里使用分页插件
     * @param num 当前页数
     * @param size 每页信息数
     * @return 用户列表
     */
    @Override
    public List<User> queryPage(int num, int size) {
        PageHelper.startPage(num, size);
        return userMapper.selectAll();
    }

    @Override
    public int queryAllCount() {
        return userMapper.selectAllCount();
    }

}
