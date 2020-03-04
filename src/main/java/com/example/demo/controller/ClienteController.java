package com.example.demo.controller;

import com.example.demo.exception.InvalidClienteReferenceException;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/")
    public Long createTransaction(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);
        return cliente.getId();
    }

    @GetMapping("/")
    public Iterable<Cliente> viewAllTransactions() {
        return clienteService.getClientes();
    }

    @GetMapping("/{id}")
    public Cliente viewTransactionById(@PathVariable("id") Long id) {
        Optional<Cliente> clienteOptional = clienteService.getCliente(id);
        if(clienteOptional.isPresent()) {
            return clienteOptional.get();
        }

        throw new InvalidClienteReferenceException("Transacao Invalida <<cliente>>");
    }
}
