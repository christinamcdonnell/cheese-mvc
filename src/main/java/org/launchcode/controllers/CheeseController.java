package org.launchcode.controllers;
// package org.launchcode.cheesemvc.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Christy on 5/18/2017.
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {
    // static ArrayList<String> cheeses = new ArrayList<>();
    static HashMap<String, String> cheeses = new HashMap();

    // Request path /cheese because of RequestMapping above for the entire controller pkg
    @RequestMapping(value="")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method=RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        //AttributedString model;
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        cheeses.put(cheeseName, cheeseDescription);
        // redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "remove", method=RequestMethod.GET)
    public String displayRemoveCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        //AttributedString model;
        model.addAttribute("title", "Add Cheese");
        return "redirect:";
    }

    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        cheeses.put(cheeseName, cheeseDescription);
        // redirect to /cheese
        return "redirect:";
    }
}

