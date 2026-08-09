package sn.supdeco.gestion_academique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supdeco.gestion_academique.entity.Inscription;
import sn.supdeco.gestion_academique.service.CoursService;
import sn.supdeco.gestion_academique.service.EtudiantService;
import sn.supdeco.gestion_academique.service.InscriptionService;

@Controller
@RequestMapping("/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;
    
    @Autowired
    private EtudiantService etudiantService;
    
    @Autowired
    private CoursService coursService;

    @GetMapping
    public String listInscriptions(Model model) {
        model.addAttribute("inscriptions", inscriptionService.findAll());
        return "inscription/liste";
    }

    @GetMapping("/nouveau")
    public String showCreateForm(Model model) {
        model.addAttribute("inscription", new Inscription());
        model.addAttribute("etudiants", etudiantService.findAll());
        model.addAttribute("coursList", coursService.findAll());
        return "inscription/form";
    }

    @PostMapping("/enregistrer")
    public String saveInscription(@ModelAttribute Inscription inscription) {
        inscriptionService.save(inscription);
        return "redirect:/inscriptions";
    }

    @GetMapping("/modifier/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Inscription inscription = inscriptionService.findById(id);
        if (inscription != null) {
            model.addAttribute("inscription", inscription);
            model.addAttribute("etudiants", etudiantService.findAll());
            model.addAttribute("coursList", coursService.findAll());
            return "inscription/form";
        }
        return "redirect:/inscriptions";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteById(id);
        return "redirect:/inscriptions";
    }
}
