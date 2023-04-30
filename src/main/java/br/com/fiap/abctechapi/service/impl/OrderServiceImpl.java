package br.com.fiap.abctechapi.service.impl;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.handler.exception.MaximumAssistException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistRequiredException;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.repository.OrderRepository;
import br.com.fiap.abctechapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private AssistanceRepository assistanceRepository;
    private OrderRepository orderRepository;

    public OrderServiceImpl(AssistanceRepository assistanceRepository, OrderRepository orderRepository) {
        this.assistanceRepository = assistanceRepository;
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void OrderServiceImpl(AssistanceRepository assistanceRepository,OrderRepository orderRepository){
        this.assistanceRepository = assistanceRepository;
        this.orderRepository = orderRepository;
    }
    @Override
    public void saveOrder(Order order, List<Long> assistsId) throws Exception {
        ArrayList<Assistance> list = new ArrayList<>();
        assistsId.forEach(id-> {

            Assistance assistance = assistanceRepository.findById(id).orElseThrow();
            list.add(assistance);
        });
        if (list.isEmpty()){
            throw new MinimumAssistRequiredException("Error nas assistências", "Não encontramos nenhuma assistência valida");
        } else  if (list.size() > 15){
            throw new MaximumAssistException("Error nas assistências", "Não devemos enviar mais de 15 assistências");
        }
        order.setAssists(list);
        orderRepository.save(order);
    }
}
