package br.com.gomides.banco.controller;

import br.com.gomides.banco.domain.Cliente;
import br.com.gomides.banco.dto.ClienteRequest;
import br.com.gomides.banco.dto.ClienteResponse;
import br.com.gomides.banco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<ClienteResponse> cadastrar(@Validated @RequestBody ClienteRequest clienteRequest) throws Exception {

        Cliente cliente = clienteRequest.toEntity();

        clienteService.cadastrar(cliente);
        ClienteResponse clienteResponse = cliente.toResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);

    }
}
