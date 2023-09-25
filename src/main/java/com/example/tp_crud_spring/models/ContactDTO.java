package com.example.tp_crud_spring.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
