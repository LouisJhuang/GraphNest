package com.example.begraphqlnest.domain.service.impl;

import com.example.begraphqlnest.core.graphql.output.Order;
import com.example.begraphqlnest.domain.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final List<Order> orders = List.of(
            new Order("O001", "1", "Keyboard", 2500),
            new Order("O002", "1", "Mouse", 1200),
            new Order("O003", "2", "Monitor", 8000)
    );

    @Override
    public List<Order> findByMemberId(String memberId) {
        return orders.stream()
                .filter(order -> order.memberId().equals(memberId))
                .toList();
    }

}
