package com.xunim.praticas.model;


import com.xunim.praticas.enums.StatusEmail;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table (name = "TB_EMAIL")
public class EmailModel {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long emailID;

    private String ownerRef;

    private String emailFrom;

    private String emailTo;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;

    private LocalDateTime sendDateEmail;

    private StatusEmail statusEmail;
}
