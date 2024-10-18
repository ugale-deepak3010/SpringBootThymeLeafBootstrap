package com.crudapp.crudapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapp.crudapp.Model.Client;


public interface ClientRepo extends JpaRepository<Client, Long> {

   public Client findByEmail(String email);
}
