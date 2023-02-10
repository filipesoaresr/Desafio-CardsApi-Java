package com.javatest.restapi.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.javatest.restapi.services.ResponseService;

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
    public Card create(@RequestBody Card card){
        return repository.save(card);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @RequestBody Card card){
       
        ResponseService responseService = new ResponseService();

       if(repository.existsById(id)){
        card.setId(id);
        repository.save(card);
        return responseService.success("Cartão Atualizado com sucesso!", HttpStatus.OK);
       }
       else {
        return responseService.error("Cartão não encontrado!", HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id){

        ResponseService responseService = new ResponseService();

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return responseService.success("Cartão deletado com sucesso!", HttpStatus.OK);
        }
        else {
            return responseService.error("Cartão não encontrado!", HttpStatus.NOT_FOUND);
        }
    }
}
