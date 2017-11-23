package com.jelena.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public String defaultPage(Model model) {
        System.out.println("I am in defaultPage method");
        model.addAttribute("title", "Spring security logging application");
        model.addAttribute("message", "Welcome. This is default page!");
        return "hello";
    }

    @RequestMapping(value = { "/admin**"}, method = RequestMethod.GET)
    public String adminPage(Model model) {
        System.out.println("I am in adminPage method");
        model.addAttribute("title", "Spring security logging application");
        model.addAttribute("message", "This is for ROLE_ADMIN only!");
        return "admin";
    }

    @RequestMapping(value = "/login/form", method = RequestMethod.GET)
    public String login(
            @RequestParam(value = "error", required = false) String error, // error bi mogao da dodje ako je doslo do /login/form?error
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {
        System.out.println("I am in login method");
        if (error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        return "login";
    }
}
