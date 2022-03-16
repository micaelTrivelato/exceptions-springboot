package br.com.micael.rs.exceptions.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.micael.rs.exceptions.dto.PessoaDTO;
import br.com.micael.rs.exceptions.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    
    @Autowired
    PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll(){
        try{
            return ResponseEntity.ok().body(pessoaService.findAll());
        }catch(InvalidDataAccessResourceUsageException e){
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(pessoaService.findById(id));
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<PessoaDTO> save(@Valid @RequestBody PessoaDTO pessoaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.delete(id));
    }
}
