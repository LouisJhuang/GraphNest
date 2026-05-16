package com.example.begraphqlnest.domain.service;

import com.example.begraphqlnest.core.graphql.output.Order;

import java.util.List;

public interface OrderService {

    List<Order> findByMemberId(String memberId);

}
