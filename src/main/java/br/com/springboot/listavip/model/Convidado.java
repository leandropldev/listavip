package br.com.springboot.listavip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name= "convidado")
public class Convidado {

	@Id
    @GeneratedValue
    private Long id;
	
	@NotNull
	@Size(min=2, max=30)
    private String nome;
	@NotNull
    private String email;
	@NotNull
    private String telefone;

    public Convidado(){}

    public Convidado(String nome, String email, String telefone){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
