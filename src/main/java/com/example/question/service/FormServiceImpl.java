package com.example.question.service;

import com.example.question.form.Form;
import com.example.question.repository.FormRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    private FormRepository formRepo;

    public void setFormRepo(FormRepository formRepo) {
        this.formRepo = formRepo;
    }

    @Override
    @Transactional
    public void addForm(Form f) {
        this.formRepo.addForm(f);
    }

    @Override
    @Transactional
    public void updateForm(Form f) {
        this.formRepo.updateForm(f);
    }

    @Override
    @Transactional
    public List<Form> listForms() {
        return this.formRepo.listForms();
    }

    @Override
    @Transactional
    public Form getFormById(Long id) {
        return this.formRepo.getFormById(id);
    }

    @Override
    @Transactional
    public void removeForm(Long id) {
        this.formRepo.removeForm(id);
    }

}

