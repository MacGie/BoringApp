package com.example.boringapp.controllers;

import com.example.boringapp.client.Activity;
import com.example.boringapp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActivityController {
    ActivityService activityService;
    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

        @RequestMapping("/index")
    public String showActivity(Model model)
    {
        model.addAttribute("actives",activityService.getActivity());
        return "index";
    }
    @PostMapping("/save")
    public String saveActivity(@ModelAttribute("actives") Activity activity)
    {
        activityService.saveActivity(activity);
        System.out.println(activity.activity);
        return"redirect:/showAll";
    }
    @GetMapping("/showAll")
    public String getAllSavedActivity(Model model)
    {
     model.addAttribute("actives",activityService.fall());
        return "showAll";
    }
    @GetMapping("/activity/type")
    public String getActivityByType(@RequestParam String type,Model model)
    {
        model.addAttribute("actives",activityService.getActivityByType(type));
        return "index";

    }
    @RequestMapping("/main")
      public String requestMain()
    {
        return "main";
    }


}
