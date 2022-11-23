package com.ms.email.models;

import com.ms.email.enums.StatusEmail;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB-EMAIL")
public class EmailModel {
    private static final long serialVersionUID = 1L;

    @Id  // Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO) // gerar automatico
    private Long emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;

    @Column(columnDefinition = "TEXT")  // recebe mais textos
    private String text;  // corpo do email
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;;
}
