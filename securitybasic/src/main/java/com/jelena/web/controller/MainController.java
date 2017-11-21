package com.jelena.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public String defaultPage(Model model) {
        System.out.println("I am in defaultPage method");
        model.addAttribute("title", "Spring security login");
        model.addAttribute("message", "This is default page!");
        return "hello";
    }

    @RequestMapping(value = { "/admin**"}, method = RequestMethod.GET)
    public String adminPage(Model model) {
        System.out.println("I am in adminPage method");
        model.addAttribute("title", "Spring security login");
        model.addAttribute("message", "This is for ROLE_ADMIN only!");
        return "admin";
    }

}
