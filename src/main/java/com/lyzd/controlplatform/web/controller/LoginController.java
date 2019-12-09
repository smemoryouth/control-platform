package com.lyzd.controlplatform.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lyzd.controlplatform.service.IUserService;
import org.jetbrains.annotations.Contract;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 0
 */
@Controller
public class LoginController  {
    private final IUserService userService;

    @Contract(pure = true)
    public LoginController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index() {
        return "redirect:/toLogin2";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ObjectNode loginVerification(String userName, String password){
        System.out.println(userName);
        System.out.println(password);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        // TODO: 2019/11/25  这里添加用户名&&密码验证
        if (true) {
            node.put("code", 200);
            node.put("url", "/list");
            return node;
        } else {
            node.put("code", 100);
            return node;
        }
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/toUpdatePassword")
    public String toUpdatePass(){
        return "updatePassword";
    }

    @RequestMapping("/toLogin2")
    public String toLogin2(){
        return "login2";
    }

}
