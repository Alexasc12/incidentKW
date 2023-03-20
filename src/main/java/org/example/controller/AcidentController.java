package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.Accident;
import org.example.model.AccidentType;
import org.example.model.Rule;
import org.example.service.AccidentService;
import org.example.service.AccidentTypeService;
import org.example.service.RuleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@AllArgsConstructor
public class AcidentController {
    private final AccidentService accidentService;

    private final AccidentTypeService accidentTypeService;

    private final RuleService ruleService;

    @GetMapping("/allAccidents")
    public String getPage(Model model) {
        model.addAttribute("accidents",accidentService.findAllAccident());
        return "accidents/listAccident";
}

    @GetMapping("/createAccident")
    public String getPageCreate(Model model) {
        model.addAttribute("types", accidentTypeService.getAllAccidentType());
        model.addAttribute("rules", ruleService.getAll());


        return "accidents/formCreate";
    }


    @PostMapping("/saveAccidents")
    public String save(@ModelAttribute Accident accident, @RequestParam ("type.id") int typeId,
                       @RequestParam ("rIds") List<Integer> rIdsList, Model model) {
        Optional<AccidentType> optional = accidentTypeService.getAccidentTypeByID(typeId);
        Set<Rule> rule = ruleService.getRuleByID(rIdsList);
        boolean isCreate = accidentService.saveAccident(accident, optional, rule);
        if (!isCreate) {
            model.addAttribute("messege", "не сщхраненно");
            return "errors/404";
        }

        return "redirect:/allAccidents";
    }


}
