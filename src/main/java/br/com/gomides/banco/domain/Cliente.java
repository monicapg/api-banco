package br.com.gomides.banco.domain;

import br.com.gomides.banco.dto.ClienteResponse;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.CPF; //omitindo os imports
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    @CPF
    @NotBlank
    private String cpf;
    @NotNull
    private LocalDate dataDeNascimento;

    //Construtor
    public Cliente(@NotBlank String nome, @Email String email, @CPF String cpf, @NotNull LocalDate dataDeNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }

    //Construtor vazio
    @Deprecated
    Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public ClienteResponse toResponse() {
        return new ClienteResponse(this.id, this.nome);
    }
}
