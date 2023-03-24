package com.xunim.praticas.repository;

import com.xunim.praticas.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmailRepository extends JpaRepository <EmailModel, Long> {
}
