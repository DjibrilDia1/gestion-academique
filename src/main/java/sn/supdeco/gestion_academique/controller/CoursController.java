package sn.supdeco.gestion_academique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supdeco.gestion_academique.entity.Cours;
import sn.supdeco.gestion_academique.service.CoursService;

@Controller
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @GetMapping
    public String listCours(Model model) {
        model.addAttribute("cours", coursService.findAll());
        return "cours/liste";
    }

    @GetMapping("/nouveau")
    public String showCreateForm(Model model) {
        model.addAttribute("cours", new Cours());
        return "cours/form";
    }

    @PostMapping("/enregistrer")
    public String saveCours(@ModelAttribute Cours cours) {
        coursService.save(cours);
        return "redirect:/cours";
    }

    @GetMapping("/modifier/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Cours cours = coursService.findById(id);
        if (cours != null) {
            model.addAttribute("cours", cours);
            return "cours/form";
        }
        return "redirect:/cours";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteCours(@PathVariable Long id) {
        coursService.deleteById(id);
        return "redirect:/cours";
    }
}
