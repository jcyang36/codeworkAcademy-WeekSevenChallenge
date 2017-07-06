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

    @RequestMapping("/myjobs")
    public String home( Model model) {

        model.addAttribute(new Job());
        return "myjobs";
    }

    @RequestMapping(value = "/joblist")
    public String goUserList(Model model) {

        model.addAttribute("jobList", jobRepository.findAll());

        return "joblist";
    }

    @RequestMapping(value = "/newjob")
    public String goNewJob(Model model) {

        model.addAttribute(new Job());
        return "NewJob";
    }

   /* @RequestMapping ("/dosearchbyskills")
    public String doSearchBySkills(@RequestParam("skills") String skills, Model model) {
        model.addAttribute("jobList", jobRepository.findAllBySkills(skills));
        return "job";
    }*/

  @RequestMapping ("/dosearchbyskills")
    public String doSearchBySkills(@RequestParam("skills") String skills, Model model) {
        model.addAttribute("jobList", jobRepository.findJobsWithPartOfSkills(skills));
        return "job";
    }





}
