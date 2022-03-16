package br.com.micael.rs.exceptions.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.micael.rs.exceptions.dto.PessoaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private Integer idade;
    private String email;

    public Pessoa(PessoaDTO pessoaDTO){
        this.id = pessoaDTO.getId();
        this.nome = pessoaDTO.getNome();
        this.idade = pessoaDTO.getIdade();
        this.email = pessoaDTO.getEmail();
    }
}
