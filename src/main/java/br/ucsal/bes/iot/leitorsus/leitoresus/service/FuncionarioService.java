package br.ucsal.bes.iot.leitorsus.leitoresus.service;

import br.ucsal.bes.iot.leitorsus.leitoresus.dto.FuncionarioDto;
import br.ucsal.bes.iot.leitorsus.leitoresus.model.Funcionario;
import br.ucsal.bes.iot.leitorsus.leitoresus.repository.FuncionarioRepository;
import br.ucsal.bes.iot.leitorsus.leitoresus.util.EncriptaDecriptaRC4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FuncionarioService {

    private String senhaCriptografada;
    @Autowired
    private FuncionarioRepository repository;

    public void save (FuncionarioDto funcionarioDto) {
        EncriptaDecriptaRC4 rc4 = new EncriptaDecriptaRC4("esus1");
        Funcionario funcionario = new Funcionario();
        funcionario.setUsername(funcionarioDto.getUsername());
        char[] senhaCriptografada = rc4.criptografa(funcionarioDto.getSenha().toCharArray());
        String senhaSalva = new String(senhaCriptografada);
        funcionario.setSenha(senhaSalva);
        repository.save(funcionario);
    }
}
