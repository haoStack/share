package cn.rmonkey.controller;

import cn.rmonkey.commons.blogenum.BlogEnum;
import cn.rmonkey.commons.response.RespResult;
import cn.rmonkey.entity.BlogUser;
import cn.rmonkey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * @Author Zhaozihao (Zack)
 * @Description
 * @date 2022/5/12 16:15
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public RespResult add() {
        BlogUser blogUser = new BlogUser();
        blogUser.setOpenid("999");
        blogUser.setCity("guangdong");
        blogUser.setHeadImg("http://www.baidu.png");
        blogUser.setNickname("michel");
        blogUser.setIntroduce("hello , word!");
        blogUser.setPassword("xxxxxxx");
        blogUser.setSex(BlogEnum.SexEnum.MALE);
        blogUser.setStatus(BlogEnum.StatusEnum.ALIVE);
        blogUser.setCreatedTime(new Date());
        blogUser.setModifiedBy(11111L);
        blogUser.setModifyTimes(0);
        blogUser.setModifiedTime(new Date());
        return userService.insertEntity(blogUser);
    }

    @GetMapping("/update")
    public RespResult update() {
        BlogUser blogUser = new BlogUser();
        blogUser.setOpenid("999");
        blogUser.setCity("guangdong");
        blogUser.setHeadImg("http://www.baidu.png");
        blogUser.setNickname("haoge");
        blogUser.setIntroduce("hello , word!");
        blogUser.setPassword("xxxxxxx");
        blogUser.setSex(BlogEnum.SexEnum.MALE);
        blogUser.setStatus(BlogEnum.StatusEnum.ALIVE);
        blogUser.setCreatedTime(new Date());
        blogUser.setModifiedBy(11111L);
        blogUser.setModifyTimes(0);
        blogUser.setModifiedTime(new Date());
        return userService.updateEntity(blogUser);
    }

    @GetMapping("/getLis")
    public RespResult selectList() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("nickname", "mic");
        return userService.selectEntities(map);
    }

    @GetMapping("/getUser")
    public void selectOne() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("openid", "999");
        BlogUser blogUser = userService.selectEntity(map);
        System.out.println(blogUser.toString());
    }

    @GetMapping("/delete")
    public RespResult delete() {
        BlogUser blogUser = new BlogUser();
        blogUser.setOpenid("999");
        blogUser.setId(1525020796894470145L);
        return userService.deleteEntity(blogUser);
    }

}
