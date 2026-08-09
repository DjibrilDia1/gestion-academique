package sn.supdeco.gestion_academique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supdeco.gestion_academique.entity.Etudiant;
import sn.supdeco.gestion_academique.service.EtudiantService;

@Controller
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public String listEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantService.findAll());
        return "etudiant/liste";
    }

    @GetMapping("/nouveau")
    public String showCreateForm(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "etudiant/form";
    }

    @PostMapping("/enregistrer")
    public String saveEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantService.save(etudiant);
        return "redirect:/etudiants";
    }

    @GetMapping("/modifier/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Etudiant etudiant = etudiantService.findById(id);
        if (etudiant != null) {
            model.addAttribute("etudiant", etudiant);
            return "etudiant/form";
        }
        return "redirect:/etudiants";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteById(id);
        return "redirect:/etudiants";
    }
}
