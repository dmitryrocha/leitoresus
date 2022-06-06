package br.ucsal.bes.iot.leitorsus.leitoresus.controller;

import br.ucsal.bes.iot.leitorsus.leitoresus.dto.FuncionarioDto;
import br.ucsal.bes.iot.leitorsus.leitoresus.model.Funcionario;
import br.ucsal.bes.iot.leitorsus.leitoresus.repository.FuncionarioRepository;
import br.ucsal.bes.iot.leitorsus.leitoresus.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioDto> list() {
        List<Funcionario> funcionarios = repository.findAll();
        return FuncionarioDto.conversor(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDto> detalhes(@PathVariable Long id) {
        Optional<Funcionario> funcionario = repository.findById(id);
        if(funcionario.isPresent()) {
            Funcionario funcionarioEncontrado = funcionario.stream().findFirst().orElse(null);
            return ResponseEntity.ok(FuncionarioDto.conversorIndividual(funcionarioEncontrado));
        }
        return ResponseEntity.notFound().build();

    }
    
    public ResponseEntity<FuncionarioDto> login(@PathVariable String username, @PathVariable String password) {
    	Funcionario funcionario = repository.findByUsername(username);
    	if(funcionario != null) {
    		FuncionarioDto aux = FuncionarioDto.conversorIndividual(funcionario);
    		if(aux.getSenha().equals(password)) {
    			return ResponseEntity.ok(aux);
    		}
    		return ResponseEntity.badRequest().build();
    	}
    	return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public void save(@RequestBody FuncionarioDto funcionarioDto) {
        service.save(funcionarioDto);
    }
}
