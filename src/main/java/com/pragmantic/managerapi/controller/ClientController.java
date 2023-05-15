package com.pragmantic.managerapi.controller;

import com.pragmantic.managerapi.entity.Client;
import com.pragmantic.managerapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    // get all clients
    @GetMapping
    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    // get client by id
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable(value = "id") Integer clientId) {
        return this.clientRepository.findById(clientId)
                .orElseThrow();
    }

    // create client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return this.clientRepository.save(client);
    }

    // update client
    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable ("id") Integer clientId) {
        Client existingClient = this.clientRepository.findById(clientId)
                .orElseThrow();
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        return this.clientRepository.save(existingClient);
    }

    // delete client by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable ("id") Integer clientId){
        Client existingClient = this.clientRepository.findById(clientId)
                .orElseThrow();
        this.clientRepository.delete(existingClient);
        return ResponseEntity.ok().build();
    }
}
