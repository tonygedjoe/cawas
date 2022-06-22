package com.tg.cawas.controller;

import com.tg.cawas.entity.Meeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @GetMapping("/mira")
    public String miraMgmt(Model model) {

        return "miramgmt";
    }
}
