package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.Accident;
import org.example.service.AccidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AcidentController {
    private final AccidentService accidentService;

    @GetMapping("/allAccidents")
    public String getPage(Model model) {
        model.addAttribute("accidents",accidentService.findAllAccident());
        return "accidents/pageAccident ";
}

    @GetMapping("/createAccident")
    public String getPageCreate() {
        return "accidents/createAccidentPage";
    }


    @PostMapping("/saveAccidents")
    public String save(@ModelAttribute Accident accident) {
        accidentService.saveAccident(accident);
        return "redirect:/allAccidents";
    }


}
