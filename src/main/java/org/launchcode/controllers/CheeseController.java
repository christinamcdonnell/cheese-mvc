package org.launchcode.controllers;
// package org.launchcode.cheesemvc.controllers;
import org.launchcode.models.Cheese;
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
    static ArrayList<Cheese> cheeses = new ArrayList();

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
        //cheeses.add(cheeseName, cheeseDescription);
        Cheese cheeseObjToPutInAL = new Cheese();

        cheeseObjToPutInAL.setName(cheeseName);
        cheeseObjToPutInAL.setDescription(cheeseDescription);

        cheeses.add(cheeseObjToPutInAL);

        // redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "remove", method=RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        //AttributedString model;
        model.addAttribute( "cheeses", cheeses);
        model.addAttribute("title", "Remove Cheese");

        return "cheese/remove";
    }

    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String processRemoveCheeseForm(Model model, @RequestParam ArrayList<String> cheeseToRemove) {
        boolean able_to_remove = true;
        ArrayList<Cheese> elementToRemove = new ArrayList();

        for (String keyToRemove : cheeseToRemove) {
            for(Cheese curr_cheese_obj : cheeses) {
                // If the keyToRemove (name of a cheese) matches the cheese name of an Cheese element in the array
                // create an ArrayList of the Cheese objects to be removed outside the current for loop
                // to avoid the concurrent
                if ((curr_cheese_obj.getName()).equals(keyToRemove)) {
                    //break;
                    elementToRemove.add(curr_cheese_obj);
                }
            }
            cheeses.removeAll(elementToRemove);

            //able_to_remove = cheeses.remove(curr_cheese_obj);
            // if (able_to_remove == false) { REPORT an ERROR}
        }

        // redirect to /cheese
        return "redirect:";
    }
}

