package com.cput.project.service;


import com.cput.project.entity.Textbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cput.project.repository.TextbookRepository;

import java.util.List;

@Service
@Transactional
public class TextbookService {

    @Autowired
    private TextbookRepository repo;

    public List<Textbook> listAll() {
        return repo.findAll();
    }

    public void save(Textbook textbook) {
        repo.save(textbook);
    }

    public Textbook get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

}
