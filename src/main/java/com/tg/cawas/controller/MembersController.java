package com.tg.cawas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/members")
public class MembersController {

    @GetMapping("/home")
    public String memberHome(Model model) {

        return "member_upload_observation";
    }
}
