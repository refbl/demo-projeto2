package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Iterable<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getCliente(Long id) {
        return clienteRepository.findById(id);
    }

}
