package com.javatest.restapi.controller;

import java.util.List;
import java.util.Optional;

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
import com.javatest.restapi.model.Card;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardRepository repository;

    @GetMapping
    public List<Card> listAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Card> listById(@PathVariable Long id){
        return repository.findById(id);
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
}
