package com.example.tp_crud_spring.services;

import com.example.tp_crud_spring.models.ContactDTO;
import entities.Contact;
import lombok.RequiredArgsConstructor;
import mappers.ContactMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import repositories.ContactRepository;

import java.util.List;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    private final ContactMapper contactMapper;



    public List<ContactDTO> getContacts() {
        return contactRepository
                .findAll()
                .stream()
                .map(contactMapper::contactToContactDto)
                .toList();
    }

    public ContactDTO addContact(ContactDTO dto) {
        Contact contact = contactMapper.contactDtoToContact(dto);
        Contact savedContact = contactRepository.save(contact);
        ContactDTO savedDto = contactMapper.contactToContactDto(savedContact);
        return savedDto;
    }

    public void deleteContactById(UUID contactId) {
        contactRepository.deleteById(contactId);
    }
}


