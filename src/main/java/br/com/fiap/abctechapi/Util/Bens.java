package br.com.fiap.abctechapi.Util;

import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.service.AssistanceService;
import br.com.fiap.abctechapi.service.impl.AssistanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bens {
    @Bean
    public AssistanceService assistanceServiceMongo(){
        return new AssistanceServiceImpl(null);
    }

    @Bean
    public AssistanceService assistanceService(@Autowired AssistanceRepository assistanceRepository){
        return new AssistanceServiceImpl(assistanceRepository);
    }
}
