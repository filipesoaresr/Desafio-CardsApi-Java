package com.javatest.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatest.restapi.database.CardRepository;
import com.javatest.restapi.entity.Card;

@RestController
@RequestMapping("/cards")
public class CardREST {
    @Autowired
    private CardRepository repository;

    @GetMapping
    public List<Card> listAll(){
        return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody Card card){
        repository.save(card);
    }

    @PutMapping("/{id}")
    public Card update(@PathVariable Long id, @RequestBody Card card){
       
        card.setId(id);
        return repository.save(card);
        
        
        
    }

    @DeleteMapping
    public void delete(@RequestBody Card card){
        repository.delete(card);
    }
}