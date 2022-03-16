package br.com.micael.rs.exceptions.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.micael.rs.exceptions.dto.PessoaDTO;
import br.com.micael.rs.exceptions.entities.Pessoa;
import br.com.micael.rs.exceptions.exceptions.EntityNotCreatedException;
import br.com.micael.rs.exceptions.exceptions.EntityNotFoundException;
import br.com.micael.rs.exceptions.repositories.PessoaRepo;

@Service
public class PessoaService {
    
    @Autowired
    PessoaRepo pessoaRepo;

    public List<PessoaDTO>findAll(){
        List<Pessoa>listPessoa = pessoaRepo.findAll();
        List<PessoaDTO>listPessoaDTO = listPessoa.stream().map(e->new PessoaDTO(e)).collect(Collectors.toList());
        return listPessoaDTO;
    }

    public PessoaDTO findById(Long id){
        Pessoa pessoa = pessoaRepo.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Id not found " + id));
        PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
        return pessoaDTO;
    }

    public PessoaDTO save(PessoaDTO pessoaDTO){
        try{ 
            Pessoa pessoa = pessoaRepo.save(new Pessoa(pessoaDTO));
            pessoaDTO.setId(pessoa.getId());
            return pessoaDTO;
        } catch (Exception e){
            throw new EntityNotCreatedException("Erro ao salvar nova pessoa");
        }
        
    }

    public String delete(Long id){
        if(pessoaRepo.existsById(id)){
            pessoaRepo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Id not found " + id);
        }       
        return "Pessoa deletada com sucesso!";
    }
}
