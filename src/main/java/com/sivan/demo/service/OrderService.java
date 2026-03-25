package com.sivan.demo.service;

import com.sivan.demo.dto.OrderRequest;
import com.sivan.demo.dto.ProductDto;
import com.sivan.demo.entity.Order;
import com.sivan.demo.entity.OrderItem;
import com.sivan.demo.repository.OrderItemRepository;
import com.sivan.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void saveOrder(OrderRequest request) {

        Order order = new Order();

        order.setEmail(request.getEmail());
        order.setPhone(request.getPhone());
        order.setAddress(request.getAddress());
        order.setState(request.getState());
        order.setPincode(request.getPincode());
        order.setPaymentMethod(request.getPaymentMethod());
        List<OrderItem> items = new ArrayList<>();

        double totalAmount=0.0;

        for (ProductDto p : request.getProducts()) {

            OrderItem item = new OrderItem();
            item.setName(p.getName());
            item.setPrice(p.getPrice());
            totalAmount= p.getPrice() + totalAmount;
            item.setQuantity(p.getQuantity());
            item.setImage(p.getImage());
            item.setOrder(order); // 🔥 IMPORTANT
            items.add(item);
        }
        order.setTotalAmount(totalAmount);
        order.setItems(items);
        orderRepository.save(order);
    }


}
