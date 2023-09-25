package com.example.tp_crud_spring.controllers;

import com.example.tp_crud_spring.exceptions.ExeptionNotFound;
import com.example.tp_crud_spring.models.ContactDTO;
import com.example.tp_crud_spring.services.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/contact")
@RequiredArgsConstructor
@Slf4j
public class ContactController {


    private final ContactService contactService;

    @GetMapping
    public String listContacts(Model model, @RequestParam(value = "phoneNumber", defaultValue = "") String filterByPhoneNumber) {
        List<ContactDTO> contacts = contactService.getContacts();

        if (!filterByPhoneNumber.isEmpty() && !filterByPhoneNumber.isBlank()) {
            contacts = contacts.stream().filter(d -> d.getPhoneNumber().startsWith(filterByPhoneNumber)).toList();
        }
        model.addAttribute("contacts", contacts);

        return "contacts/list";
    }

    /*@GetMapping("/{contactId}")
    public String getContactFounded(@PathVariable("contactId") UUID id, Model model) {
        Optional<ContactDTO> findContact = contactService.getContactById(id);

        if (findContact.isPresent()) {
            model.addAttribute("findContact", findContact.get());
            model.addAttribute("mode", "details");


            return "contacts/details";
        }

        throw new ExeptionNotFound();
    }
    @GetMapping ("/delete/{contactId}")
    public String deleteContactById(@PathVariable("contactId") UUID id) {
        boolean deleted = contactService.deleteContactById(id);
        if (deleted) {
            return "redirect:/contact";
        } else {

            return "error/user";
        }
    }


    @GetMapping("/add")
    public String getDContactForm(Model model, @RequestParam(value = "exemple", defaultValue = "default") String addContact) {
        log.debug("add Contact: " + addContact);

        model.addAttribute("contact", ContactDTO.builder().build());
        model.addAttribute("mode", "add");

        return "contacts/contactForm";
    }

    @PostMapping("/add")
    public String addContactHandler(ContactDTO newContact) {
        contactService.addContact(newContact);
        return "redirect:/contact";
    }


*/
}
