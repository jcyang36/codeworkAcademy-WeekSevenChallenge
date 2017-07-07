package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


/**
 * Created by student on 6/23/17.
 */
@Controller
public class JobController {




        @Autowired
        private JobRepository jobRepository;
        @Autowired
        private RecordRepository recordRepository;
        @Autowired
        private UserRepository userRepository;
    @RequestMapping("/notifications")
    public String notify( Model model, Principal principal){

        String username = principal.getName();
        User user_current = userRepository.findByUsername(username);
        model.addAttribute("skill", user_current.getSkill());
        model.addAttribute("jobList", jobRepository.findJobsWithPartOfSkills(user_current.getSkill()));
        return "notifications";
    }
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

    @RequestMapping(value = "/create")
    public String goNewJob(@ModelAttribute Record record, Model model) {
        recordRepository.save(record);
        model.addAttribute(new Job());
        return "create";
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
