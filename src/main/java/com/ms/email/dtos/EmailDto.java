package com.ms.email.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data  // Getters, Setters, Construct
public class EmailDto {

    @NotBlank   // Campo Obrigatório
    private String ownerRef;
    @NotBlank
    @Email  // verificar email valido
    private String emailFrom;
    @NotBlank
    @Email
    private String emailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;
}
