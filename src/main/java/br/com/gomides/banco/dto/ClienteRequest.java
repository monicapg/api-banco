package br.com.gomides.banco.dto; //data transfer object

import br.com.gomides.banco.domain.Cliente;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ClienteRequest {

    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    @CPF
    private String cpf;
    @NotNull
    private LocalDate dataDeNascimento;

    public Cliente toEntity() {

        return new Cliente(this.nome, this.email, this.cpf, this.dataDeNascimento);
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
}
