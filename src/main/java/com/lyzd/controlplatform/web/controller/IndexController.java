package com.lyzd.controlplatform.web.controller;

import com.lyzd.controlplatform.model.User;
import com.lyzd.controlplatform.service.IUserService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

/**
 * description：
 *
 * @author 阿劼
 * @data 2019/11/26 14:57
 */
@Controller
public class IndexController {

    private final IUserService userService;

    @Contract(pure = true)
    public IndexController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public String mainPage(@RequestParam(defaultValue = "1") int num,
                           @RequestParam(defaultValue = "5") int size,
                           @NotNull Model model) {
        int count = userService.queryAllCount();
        int maxPage = (int) Math.ceil((double) count / size);
        List<User> list = userService.queryPage(num, size);
        model.addAttribute("all", list);
        model.addAttribute("num", num);
        model.addAttribute("size", size);
        model.addAttribute("maxNum", maxPage);
        model.addAttribute("count", count);
        return "index";
    }


    @RequestMapping("/toAdd")
    public String toAdd() {
        return "add";
    }

    @RequestMapping("/add")
    public String add(User user) {
        if ("".equals(user.getUserId()) || user.getUserId() == null) {
            String id = String.valueOf(UUID.randomUUID());
            user.setUserId(id);
        }
        System.out.println(user.getUserId());
        userService.add(user);
        return "redirect:/list";
    }

    @RequestMapping("/del")
    public String del(int num, int size, String userId) {
        userService.removeByPrimaryKey(userId);
        return "redirect:/list?num=" + num + "&size=" + size;
    }

    @RequestMapping("/edit")
    public String edit(int num, int size, String userId, @NotNull Model model) {

        User user = userService.queryByPrimaryKey(userId);
        model.addAttribute("user", user);
        model.addAttribute("num", num);
        model.addAttribute("size", size);
        return "edit";
    }

    @RequestMapping("/save")
    public String save(User user) {
        userService.modifyByPrimaryKey(user);
        return "redirect:/list";
    }

    @RequestMapping("/editPassword")
    public String editPassword() {
        return "updatePassword";
    }


}
