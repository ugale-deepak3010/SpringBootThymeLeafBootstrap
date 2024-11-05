package com.crudapp.crudapp.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crudapp.crudapp.Model.Client;
import com.crudapp.crudapp.Model.ClientDto;
import com.crudapp.crudapp.Repository.ClientRepo;

import jakarta.validation.Valid;





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

    @PostMapping("/add")
    public String postMethodName(@Valid @ModelAttribute ClientDto clientDto, BindingResult bindingResult) {
        
        if (clientRepo.findByEmail(clientDto.getEmail())!=null) {
           
            // Manuall duplicate check checked 
            bindingResult.addError(
                new FieldError("clientDto", "email", "Email is already present")
            );
        }

        if (bindingResult.hasErrors()) {
            return "client/create";
        }

        Client client= new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setPhone(clientDto.getPhone());
        client.setEmail(clientDto.getEmail());
        client.setAddress(clientDto.getAddress());
        client.setStatus(clientDto.getStatus());
        client.setCreatedAt(LocalDate.now());
        clientRepo.save(client);
       
        return "redirect:/client"; //returning client home page.
    }


    @GetMapping("/edit")
    public String getMethodName(Model model,@RequestParam Long id) {

        Client client= clientRepo.findById(id).orElse(null);
    
        System.out.println("here is CreatedAT "+client.getCreatedAt()+" \n\n\n\n");

        if (client==null) 
            return "redirect:/client";  //wrong id.
        
        
        ClientDto clientDto= new ClientDto(client.getId(), client.getFirstName(), client.getLastName(), client.getEmail(), client.getPhone(), client.getAddress(), client.getStatus(), client.getCreatedAt());
        model.addAttribute("clientDto", clientDto);

        return "client/update";
    }



    
    
    
    
}
