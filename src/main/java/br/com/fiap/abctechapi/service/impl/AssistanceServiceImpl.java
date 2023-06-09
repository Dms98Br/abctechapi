package br.com.fiap.abctechapi.service.impl;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.service.AssistanceService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AssistanceServiceImpl implements AssistanceService {
    private final AssistanceRepository assistanceRepository;

    public AssistanceServiceImpl(AssistanceRepository assistanceRepository){
        this.assistanceRepository = assistanceRepository;
    }
    @Override
    public List<Assistance> getAssists() {
        return this.assistanceRepository.findAll();
    }
}
