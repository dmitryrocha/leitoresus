package br.ucsal.bes.iot.leitorsus.leitoresus.dto;

import br.ucsal.bes.iot.leitorsus.leitoresus.model.Cidadao;

import java.util.List;
import java.util.stream.Collectors;

public class CidadaoDto {

    private String identificacao;
    private Boolean horarioHoje;

    public CidadaoDto() {}

    public CidadaoDto(Cidadao cidadao) {
        this.identificacao = cidadao.getIdentificacao();
        this.horarioHoje = cidadao.getHorarioHoje();
    }

    public static List<CidadaoDto> conversor(List<Cidadao> cidadoes) {
        return cidadoes.stream().map(CidadaoDto::new).collect(Collectors.toList());
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Boolean getHorarioHoje() {
        return horarioHoje;
    }

    public void setHorarioHoje(Boolean horarioHoje) {
        this.horarioHoje = horarioHoje;
    }
}
