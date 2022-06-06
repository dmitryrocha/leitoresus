package br.ucsal.bes.iot.leitorsus.leitoresus.dto;

import br.ucsal.bes.iot.leitorsus.leitoresus.model.Funcionario;
import br.ucsal.bes.iot.leitorsus.leitoresus.util.EncriptaDecriptaRC4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FuncionarioDto {

    private String username;
    private String senha;

    public FuncionarioDto() {}

    public FuncionarioDto(Funcionario funcionario) {
        this.username = funcionario.getUsername();
        this.senha = funcionario.getSenha();
    }

    public static List<FuncionarioDto> conversor(List<Funcionario> funcionarios) {
        return funcionarios.stream().map(FuncionarioDto::new).collect(Collectors.toList());
    }

    public static FuncionarioDto conversorIndividual(Funcionario funcionario) {
        FuncionarioDto funcionarioDto = new FuncionarioDto();
        EncriptaDecriptaRC4 rc4 = new EncriptaDecriptaRC4("esus1");
        funcionarioDto.setUsername(funcionario.getUsername());
        char[] senhaDescriptografada = rc4.decriptografa(funcionario.getSenha().toCharArray());
        String senhaRecuperada = new String(senhaDescriptografada);
        funcionarioDto.setSenha(senhaRecuperada);

        return funcionarioDto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
