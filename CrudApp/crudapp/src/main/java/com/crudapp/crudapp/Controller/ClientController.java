package com.crudapp.crudapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudapp.crudapp.Model.Client;
import com.crudapp.crudapp.Model.ClientDto;
import com.crudapp.crudapp.Repository.ClientRepo;



@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepo clientRepo;

    @GetMapping("")
    public String getAllClients(Model model) {

        List<Client> clients= clientRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("clients", clients);

        return "/client/index";
    }
    
    @GetMapping("/create")
    public String getCreateClient(Model model) {

        ClientDto clientDto= new ClientDto();
        model.addAttribute("clientDto", clientDto);

        return "/client/create";
    }
    
}
