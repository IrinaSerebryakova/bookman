package ru.bookman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthController {


    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        if (request.getParameter("error") != null) {
            model.addAttribute("error", "Invalid username or password");
        }

        if (request.getParameter("logout") != null) {
            model.addAttribute("message", "You have been logged out successfully");
        }
        return "login";
    }
}