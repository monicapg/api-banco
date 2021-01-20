package br.com.gomides.banco.service;

import br.com.gomides.banco.domain.Cliente;
import br.com.gomides.banco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente) throws Exception {

        if (existeCPF(cliente.getCpf())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já cadastrado");
        }
        if (existeEmail(cliente.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já cadastrado");
        }
        return clienteRepository.save(cliente);
    }

    public boolean existeCPF(String cpf) {

        List<Cliente> clientes = clienteRepository.findByCpf(cpf);

        if (clientes != null && !clientes.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean existeEmail(String email) {

        List<Cliente> clientes = clienteRepository.findByEmail(email);

        if (clientes != null && !clientes.isEmpty()) {
            return true;
        }
        return false;
    }

}
