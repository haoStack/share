package cn.rmonkey.service.impl;

import cn.rmonkey.commons.blogenum.BlogEnum;
import cn.rmonkey.commons.response.RespResult;
import cn.rmonkey.entity.BlogUser;
import cn.rmonkey.mapper.BlogUserMapper;
import cn.rmonkey.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author Zhaozihao (Zack)
 * @Description
 * @date 2022/5/12 16:09
 */
@Service
@Log4j2
public class UserserviceImpl implements UserService {
    @Autowired
    private BlogUserMapper userMapper;

    /**
     * @param conditions
     * @return
     */
    @Override
    public RespResult findUserList(Map<String, Object> conditions) {
        QueryWrapper<BlogUser> queryWrapper = new QueryWrapper<>();

        if (!Objects.isNull(conditions.get("nickname"))) {
            queryWrapper.like("nickname", conditions.get("nickname"));
        }
        if (!Objects.isNull(conditions.get("introduce"))) {
            queryWrapper.like("introduce", conditions.get("introduce"));
        }
        if (!Objects.isNull(conditions.get("sex"))) {
            queryWrapper.eq("sex", conditions.get("sex"));
        }
        if (!Objects.isNull(conditions.get("city"))) {
            queryWrapper.eq("city", conditions.get("city"));
        }
        if (!Objects.isNull(conditions.get("country"))) {
            queryWrapper.eq("country", conditions.get("country"));
        }
        if (!Objects.isNull(conditions.get("status"))) {
            queryWrapper.eq("status", conditions.get("status"));
        }
        if (!Objects.isNull(conditions.get("creatdTimeBetween"))) {
            Map<String, Object> creatdTimeBetween = (HashMap<String, Object>) conditions.get("creatdTimeBetween");
            queryWrapper.between("created_time", creatdTimeBetween.get("start"), creatdTimeBetween.get("end"));
        }
        if (!Objects.isNull(conditions.get("modifiedTimeBetween"))) {
            Map<String, Object> modifiedTimeBetween = (HashMap<String, Object>) conditions.get("creatdTimeBetween");
            queryWrapper.between("modified_time", modifiedTimeBetween.get("start"), modifiedTimeBetween.get("end"));
        }
        if (!Objects.isNull(conditions.get("modifiedTimes"))) {
            queryWrapper.gt("modified_times", conditions.get("modifiedTimes"));
        }

        return RespResult.Success.success("success!", userMapper.selectList(queryWrapper));
    }

    @Override
    public RespResult insertUser(BlogUser user) {
        //根据openid 查询数据库有没有这个用户
        BlogUser oldUser = findUserByOpenid(user.getOpenid());
        if (!Objects.isNull(oldUser)) {
            if (oldUser.getStatus().equals(BlogEnum.StatusEnum.ALIVE)) {
                return RespResult.Failure.failure("您已经注册过，请不要重复注册");
            }
            if (oldUser.getCount() >= 0) {
                oldUser.setStatus(BlogEnum.StatusEnum.ALIVE);
                RespResult respResult = updateUser(oldUser);
                return RespResult.Success.success("注册成功！您剩余的取关次数为{" + oldUser.getCount() + "}次，请不要在再次取关哦！");
            }
            return RespResult.Failure.failure("您的注册权限已用完！");
        }
        log.info("新增用户" + user.getNickname());
        int insert = userMapper.insert(user);
        return RespResult.Success.success("注册成功!");
    }

    @Override
    public RespResult updateUser(BlogUser user) {
        UpdateWrapper<BlogUser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("openid", user.getOpenid());
        int update = userMapper.update(user, updateWrapper);
        return RespResult.Success.success("处理成功");
    }

    @Override
    public RespResult deleteUser(BlogUser user) {
        //先从数据库找到这用户，再软删除
        BlogUser oldUser = findUserByOpenid(user.getOpenid());
        oldUser.setStatus(BlogEnum.StatusEnum.DESTROY);
        oldUser.setCount(oldUser.getCount() - 1);
        RespResult respResult = updateUser(oldUser);
        return respResult;
    }

    @Override
    public BlogUser findUserByOpenid(String openid) {
        QueryWrapper<BlogUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid", openid);
        return userMapper.selectOne(queryWrapper);
    }
}
