package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by student on 6/23/17.
 */
@Controller
public class JobController {




        @Autowired
        private JobRepository jobRepository;


    @RequestMapping(value = "/joblist")
    public String goUserList(Model model) {

        model.addAttribute(new Job());
        return "joblist";
    }

    @RequestMapping(value = "/newjob")
    public String goNewJob(Model model) {

        model.addAttribute(new Job());
        return "NewJob";
    }






}
