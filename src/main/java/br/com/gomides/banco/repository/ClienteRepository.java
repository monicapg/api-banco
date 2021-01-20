package br.com.gomides.banco.repository;

import br.com.gomides.banco.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    List<Cliente> findByCpf(String cpf);
    List<Cliente> findByEmail(String email);

}
