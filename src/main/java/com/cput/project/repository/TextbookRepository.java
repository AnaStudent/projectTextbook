package com.cput.project.repository;

import com.cput.project.entity.Textbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextbookRepository extends JpaRepository<Textbook, Long> {
}
