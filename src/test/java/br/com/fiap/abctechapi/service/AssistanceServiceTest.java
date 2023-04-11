package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.service.impl.AssistanceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootTest
public class AssistanceServiceTest {
    private AssistanceService assistanceService;
    @MockBean
    private AssistanceRepository assistanceRepository;
    @Autowired
    private AssistanceService assistanceServiceMongo;

    @Bean
    private AssistanceService getAssistanceServiceMongo(){
        return new AssistanceServiceImpl(assistanceRepository);
    }
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImpl(assistanceRepository);
    }
    @Test
    public void test_lista_assistance(){
        //Mockito.when(assistanceService.getAssista()).thenReturn(List.of());
        List<Assistance> list = assistanceService.getAssists();
        Assertions.assertNotNull(list);
    }

}
