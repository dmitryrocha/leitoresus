package br.ucsal.bes.iot.leitorsus.leitoresus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidadao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identificacao;
    private Boolean horarioHoje;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
