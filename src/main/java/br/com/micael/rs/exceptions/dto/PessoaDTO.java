package br.com.micael.rs.exceptions.dto;

import br.com.micael.rs.exceptions.entities.Pessoa;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class PessoaDTO {
    
    private Long id;

    @NotNull @NotEmpty @NotBlank
    private String nome;

    @NotNull
    private Integer idade;

    private String email;

    public PessoaDTO(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.idade = pessoa.getIdade();
    }
}
