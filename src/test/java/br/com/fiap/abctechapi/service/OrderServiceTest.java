package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.handler.exception.MaximumAssistException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistRequiredException;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.repository.OrderRepository;
import br.com.fiap.abctechapi.service.impl.AssistanceServiceImpl;
import br.com.fiap.abctechapi.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OrderServiceTest {
    @MockBean
    private AssistanceRepository assistanceRepository;
    @MockBean
    private OrderRepository orderRepository;

    private OrderService orderService;
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(assistanceRepository,orderRepository);
        Mockito.when(assistanceRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new Assistance(1L, "Teste", "Teste Description")));
    }

    //minimum assistencias > 0
    @Test
    public void order_error_min_assist(){
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        Assertions.assertThrows(MinimumAssistRequiredException.class, () -> orderService.saveOrder(newOrder, List.of()));
        Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }

    //maximo assistencias <= 15
    @Test
    public void order_error_max_assist(){
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        Assertions.assertThrows(MaximumAssistException.class, () -> orderService.saveOrder(newOrder, List.of(1L, 2L, 3L, 4L, 5L,6L, 7L, 1L, 2L, 3L, 4L, 5L,6L, 7L, 1L,2L)));
        Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }

    @Test
    public void order_success_assist() throws Exception {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        orderService.saveOrder(newOrder, List.of(1L, 2L, 3L, 4L, 5L,6L, 7L, 1L, 2L, 3L, 4L, 5L,6L, 7L));
        Mockito.verify(orderRepository, Mockito.times(1)).save(newOrder);
    }

}
