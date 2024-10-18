package com.crudapp.crudapp.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudapp.crudapp.Model.Client;
import com.crudapp.crudapp.Repository.ClientRepo;




@RestController
@RequestMapping("/rest/client")
public class ClientRestController {

    @Autowired
    ClientRepo clientRepo;


    @GetMapping("")
    public List<com.crudapp.crudapp.Model.Client> getAll() {
        return clientRepo.findAll();
    }

    @PostMapping
    public Client postMethodName(@RequestBody Client client) {        
        return clientRepo.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteMethodName(@PathVariable Long id) {
        clientRepo.deleteById(id);
    }

    @GetMapping("/{id}")
    public void getById(@PathVariable Long id) {
        clientRepo.findById(id);
    }

    
    
    
}
