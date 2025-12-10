package com.adamidis.learning.portfolio.controller;

import com.adamidis.learning.portfolio.model.ContactForm;
import com.adamidis.learning.portfolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/contact")
    public String contactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@ModelAttribute ContactForm contactForm, Model model) {
        emailService.sendContactEmail(contactForm.getName(), contactForm.getEmail(), contactForm.getMessage());
        model.addAttribute("successMessage", "Your message has been sent successfully!");
        return "contact";
    }
}
