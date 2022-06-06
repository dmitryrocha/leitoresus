package br.ucsal.bes.iot.leitorsus.leitoresus.service;

import br.ucsal.bes.iot.leitorsus.leitoresus.dto.CidadaoDto;
import br.ucsal.bes.iot.leitorsus.leitoresus.model.Cidadao;
import br.ucsal.bes.iot.leitorsus.leitoresus.repository.CidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadaoService {

    @Autowired
    private CidadaoRepository repository;

    public void save(CidadaoDto cidadaoDto) {
        Cidadao cidadao = new Cidadao();
        cidadao.setIdentificacao(cidadaoDto.getIdentificacao());
        cidadao.setHorarioHoje(cidadaoDto.getHorarioHoje());

        repository.save(cidadao);
    }

    public List<Cidadao> findByIdentificacao(String identificacao) {
        return repository.findByIdentificacao(identificacao);
    }
}
