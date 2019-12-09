package com.lyzd.controlplatform.web.controller;

import com.lyzd.controlplatform.model.SUser;
import com.lyzd.controlplatform.service.ISUserService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * description：
 *
 * @author 阿劼
 * @data 2019/11/26 14:59
 */
@Controller
public class AdminController {
    private final ISUserService userService;

    @Contract(pure = true)
    public AdminController(ISUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/slist")
    public String mainPage(@RequestParam(defaultValue = "1") int num,
                           @RequestParam(defaultValue = "5") int size,
                           @NotNull Model model) {
        int count = userService.queryAllCount();
        int maxPage = (int) Math.ceil((double) count / size);
        List<SUser> list = userService.queryPage(num, size);
        model.addAttribute("all", list);
        model.addAttribute("num", num);
        model.addAttribute("size", size);
        model.addAttribute("maxNum", maxPage);
        model.addAttribute("count", count);
        return "index1";
    }


//    @RequestMapping("/stoAdd")
//    public String toAdd() {
//        return "add";
//    }
//
//    @RequestMapping("/sadd")
//    public String add(SUser user) {
//        userService.add(user);
//        return "redirect:/slist";
//    }
//
//    @RequestMapping("/sdel")
//    public String del(int num, int size, int userId) {
//        userService.removeByPrimaryKey(userId);
//        return "redirect:/slist?num=" + num + "&size=" + size;
//    }
//
//    @RequestMapping("/sedit")
//    public String edit(int num, int size, int userId, @NotNull Model model) {
//        SUser user = userService.queryByPrimaryKey(userId);
//        model.addAttribute("user", user);
//        model.addAttribute("num", num);
//        model.addAttribute("size", size);
//        return "edit";
//    }
}
