package com.springapi.log.logapi.domain.service;

import javax.transaction.Transactional;

import com.springapi.log.logapi.domain.exception.NegocioException;
import com.springapi.log.logapi.domain.model.Cliente;
import com.springapi.log.logapi.domain.repository.ClienteRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
    private ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteId) {
        return clienteRepository.findById(clienteId)
        .orElseThrow(()->new NegocioException("Cliente não encontrado"));
        
    }

    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso=clienteRepository.findByEmail(cliente.getEmail())
        .stream()
        .anyMatch(clienteExistente->!clienteExistente.equals(cliente));
        if(emailEmUso){
            throw new NegocioException("Email ja cadastrado");
        }

        return clienteRepository.save(cliente);

    }

    @Transactional
    public void deletar(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

}
