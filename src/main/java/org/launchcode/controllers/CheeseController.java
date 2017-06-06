package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.launchcode.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {


    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese) {
       /*
       * Spring Boot does this behind the scenes from the @ModelAttribute usage
       * newCheeese = new Cheese();  using the default constructor in Cheese.java  Cheese()noparams
       * newCheese.setName(Request.getParameter("name");
       * newCheeese.setDescription(Request.getParameter("description");
        */
        CheeseData.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "/edit/{cheeseId}", method = RequestMethod.GET) // make /cheese/edit/3 & such work
    public String displayEditForm(Model model, @PathVariable int cheeseId) {
        model.addAttribute("cheese", CheeseData.getById(cheeseId));
        model.addAttribute("title", "Edit Cheese");
        return "cheese/edit";
    }

    @RequestMapping(value = "/edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(Model model, int cheeseId, String name, String description) {
        //Cheese updateThisCheese = new Cheese(); // Cheese c = CheeseData.getById(cheeseId); ?dont make new one?

        Cheese updateThisCheese = CheeseData.getById(cheeseId);
        updateThisCheese.setName(name);
        updateThisCheese.setDescription(description);

       //  model.addAttribute("cheeses", CheeseData.getById(cheeseId));
        model.addAttribute("cheese", updateThisCheese);
        model.addAttribute("title", "Edit Cheese");
        return "redirect:..";
    }
}
