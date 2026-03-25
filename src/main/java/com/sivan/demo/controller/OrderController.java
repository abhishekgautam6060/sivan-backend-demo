package com.sivan.demo.controller;



import com.razorpay.RazorpayClient;
import com.sivan.demo.dto.OrderRequest;
import com.sivan.demo.entity.Order;
import com.sivan.demo.repository.OrderRepository;
import com.sivan.demo.service.OrderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public String placeOrder(@RequestBody OrderRequest request) {
        System.out.println("Yes API Started");

        System.out.println(request);
        service.saveOrder(request);
        return "Order Saved Successfully";
    }

//    @GetMapping("/{phone}")
//    public List<OrderItem> getOrders(@PathVariable String phone) {
//        return service.getOrdersByPhone(phone);
//    }

    @GetMapping("/user-orders")
    public ResponseEntity<List<Order>> getUserOrders(@RequestParam String email) {

        System.out.println("Fetching all the orders of the user");
        List<Order> orders = orderRepository.findByEmail(email);

        System.out.println(orders);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/")
    public String getAllOrders(){
        return "Yes its working";
    }

    @PostMapping("/create-payment")
    public ResponseEntity<?> createPayment(@RequestBody Map<String, Object> data) throws Exception {

        int amount = Integer.parseInt(data.get("amount").toString()) * 100; // paise

        RazorpayClient client = new RazorpayClient("rzp_test_SVYcmrkOmNmKFK", "AJemS12ZmgfegW3X2KAuNJM1");

        JSONObject options = new JSONObject();
        options.put("amount", amount);
        options.put("currency", "INR");
        options.put("receipt", "order_rcptid_11");

        com.razorpay.Order order = client.orders.create(options);

        return ResponseEntity.ok(order.toString());
    }
}
