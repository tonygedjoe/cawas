package com.tg.cawas.controller;

import com.tg.cawas.entity.Meeting;
import com.tg.cawas.service.MeetingService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    MeetingService meetingService;

    @Value("${cawas.pdf-locations:/cawas/pdf}")
    private String filePath;

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/events")
    public String event(Model model) {

        List<Meeting> meetingList = meetingService.getNextMeetings();
        model.addAttribute("events", meetingList);
        return "events";
    }

    @GetMapping("/mira")
    public String mira() {
        return "mira";
    }


    @GetMapping(value = "/mira/{id}")
    public void return_mira(HttpServletResponse response, @PathVariable int id ) throws IOException {

        String fileName = "MIRA" + id + ".pdf";
        String path = filePath + fileName;

        System.out.println("Looking for file path: " + path);
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);

        response.setContentType("application/pdf");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "inline;filename=\"" + fileName + "\"");

        FileCopyUtils.copy(inputStream, response.getOutputStream());

    }

    @GetMapping(value = "/skynotes/{id}")
    public void return_skynotes(HttpServletResponse response, @PathVariable int id ) throws IOException {


        String fileName = "SkyNotes" + id + ".pdf";
        String path = "/Users/anthonygreen/code/tg/cawas_content/skynotes/" + fileName;

        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);

        response.setContentType("application/pdf");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "inline;filename=\"" + fileName + "\"");

        FileCopyUtils.copy(inputStream, response.getOutputStream());

    }


    @GetMapping("/history")
    public String history() {

        return "history";
    }

    @GetMapping("/contact")
    public String contact() {

        return "contact";
    }


}
