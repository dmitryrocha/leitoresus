package br.ucsal.bes.iot.leitorsus.leitoresus.controller;

import br.ucsal.bes.iot.leitorsus.leitoresus.dto.CidadaoDto;
import br.ucsal.bes.iot.leitorsus.leitoresus.model.Cidadao;
import br.ucsal.bes.iot.leitorsus.leitoresus.repository.CidadaoRepository;
import br.ucsal.bes.iot.leitorsus.leitoresus.service.CidadaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/cidadao")
public class CidadaoController {

    @Autowired
    private CidadaoRepository repository;

    @Autowired
    private CidadaoService service;

    @GetMapping
    public List<CidadaoDto> list() {
        List<Cidadao> cidadoes = repository.findAll();
        return CidadaoDto.conversor(cidadoes);
    }

    @GetMapping("/{identificacao}") @ResponseBody
    public Boolean temHorarioHoje(@PathVariable String identificacao) {
        Cidadao cidadao = service.findByIdentificacao(identificacao).get(0);
        return cidadao.getHorarioHoje();
    }

    @PostMapping
    public void save(@RequestBody CidadaoDto cidadaoDto) {
        service.save(cidadaoDto);
    }
}
