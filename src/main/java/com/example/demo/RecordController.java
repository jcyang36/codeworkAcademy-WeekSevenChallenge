package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


/**
 * Created by student on 6/23/17.
 */
@Controller
public class RecordController {





        @Autowired
        private RecordRepository recordRepository;

        @Autowired
        private UserRepository userRepository;




    @RequestMapping(value = "/createresume")
    public String gocreateresume(@ModelAttribute Record record, Model model) {
        recordRepository.save(record);
        model.addAttribute("recordList", recordRepository.findAll());
        return "resumelist";
    }
    @RequestMapping(value = "/resumelist")
        public String goResumeList(@ModelAttribute Record record, Model model) {

            model.addAttribute("recordList",recordRepository.findAll());
            return "resumelist";
        }

    @RequestMapping("/")
    public String goindex( Model model){
        model.addAttribute(new Record());

        return "index";
    }
    @RequestMapping("/search")
    public String gosearch( Model model){
        model.addAttribute(new Record());

        return "search";
    }



@RequestMapping ("/dosearchbyfirst")
public String doSearchByFirst(@RequestParam("first") String first, Model model) {
        model.addAttribute(recordRepository.findAllByFirst(first));

    return "resume";
}
    @RequestMapping ("/dosearchbylast")
    public String doSearchByLast(@RequestParam("last") String last, Model model) {
        model.addAttribute(recordRepository.findAllByLast(last));

        return "resume";
    }


    @RequestMapping ("/dosearchbyschool")
    public String doSearchBySchool(@RequestParam("school") String school, Model model) {
        model.addAttribute(recordRepository.findAllBySchool(school));
        return "resume";
    }

    @RequestMapping ("/dosearchbycompany")
    public String doSearchByCompany(@RequestParam("company") String company, Model model) {
        model.addAttribute(recordRepository.findAllByCompany(company));
        return "resume";
    }


    @RequestMapping ("/dosearchbyskill")
    public String doSearchBySkill(@RequestParam("skill") String skill, Model model) {
        model.addAttribute(recordRepository.findAllBySkill(skill));
        return "resume";
    }








}