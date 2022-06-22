package com.tg.cawas.controller;

import com.tg.cawas.entity.Meeting;
import com.tg.cawas.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {


    @GetMapping({"/login"})
    public String login() {

        return "login";
    }


    @GetMapping({"/logout"})
    public String logout() {

        return "home";
    }


}
